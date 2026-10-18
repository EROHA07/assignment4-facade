public class CodecProfile {
    private final String format;
    private final int maxBitrateKbps;
    private final int quantizationStep;

    public CodecProfile(String format, int maxBitrateKbps, int quantizationStep) {
        this.format = format;
        this.maxBitrateKbps = maxBitrateKbps;
        this.quantizationStep = quantizationStep;
    }

    public String getFormat() { return format; }
    public int getMaxBitrateKbps() { return maxBitrateKbps; }
    public int getQuantizationStep() { return quantizationStep; }
}
