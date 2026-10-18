public class MediaData {
    private final String fileName;
    private final String format;
    private final int bitrateKbps;
    private final int[] leftChannel;
    private final int[] rightChannel;

    public MediaData(String fileName, String format, int bitrateKbps,
                     int[] leftChannel, int[] rightChannel) {
        this.fileName = fileName;
        this.format = format;
        this.bitrateKbps = bitrateKbps;
        this.leftChannel = leftChannel.clone();
        this.rightChannel = rightChannel.clone();
    }

    public String getFileName() { return fileName; }
    public String getFormat() { return format; }
    public int getBitrateKbps() { return bitrateKbps; }
    public int[] getLeftChannel() { return leftChannel.clone(); }
    public int[] getRightChannel() { return rightChannel.clone(); }
}
