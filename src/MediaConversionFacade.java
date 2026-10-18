import java.util.Arrays;

public class MediaConversionFacade {
    private final MetadataReader metadataReader = new MetadataReader();
    private final CodecFactory codecFactory = new CodecFactory();
    private final BitrateReader bitrateReader = new BitrateReader();
    private final AudioMixer audioMixer = new AudioMixer();
    private final AudioEncoder audioEncoder = new AudioEncoder();

    public String convert(String fileName, String targetFormat) {
        try {
            MediaData source = metadataReader.read(fileName);
            CodecProfile codec = codecFactory.create(targetFormat);
            int bitrate = bitrateReader.selectBitrate(source, codec);
            int[] mixedSamples = audioMixer.mixToMono(source);
            int[] encodedSamples = audioEncoder.encode(mixedSamples, codec, bitrate);

            String outputName = replaceExtension(source.getFileName(), codec.getFormat());
            return "SUCCESS | " + source.getFileName() + " -> " + outputName
                    + " | bitrate=" + bitrate + " kbps"
                    + " | simulated samples=" + Arrays.toString(encodedSamples);
        } catch (IllegalArgumentException error) {
            return "ERROR | " + error.getMessage();
        }
    }

    private String replaceExtension(String fileName, String extension) {
        int dot = fileName.lastIndexOf('.');
        return fileName.substring(0, dot + 1) + extension;
    }
}
