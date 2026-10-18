public class MetadataReader {
    public MediaData read(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }

        int dot = fileName.lastIndexOf('.');
        if (dot <= 0 || dot == fileName.length() - 1) {
            throw new IllegalArgumentException("File name must have an extension");
        }

        String format = fileName.substring(dot + 1).toLowerCase();
        int bitrate;
        switch (format) {
            case "wav": bitrate = 1411; break;
            case "mp3": bitrate = 320; break;
            case "aac": bitrate = 256; break;
            default: throw new IllegalArgumentException("Unsupported input format: " + format);
        }

        // Demo only: each file gets a small, repeatable stereo sample set.
        int offset = fileName.substring(0, dot).length();
        int[] left = {12 + offset, 24 + offset, 36 + offset, 48 + offset};
        int[] right = {16 + offset, 20 + offset, 40 + offset, 44 + offset};
        return new MediaData(fileName, format, bitrate, left, right);
    }
}
