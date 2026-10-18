public class AudioEncoder {
    public int[] encode(int[] samples, CodecProfile codec, int bitrateKbps) {
        if (bitrateKbps <= 0) {
            throw new IllegalArgumentException("Bitrate must be positive");
        }

        int step = codec.getQuantizationStep();
        if (bitrateKbps < 128) {
            step += 2;
        }

        int[] encoded = new int[samples.length];
        for (int i = 0; i < samples.length; i++) {
            encoded[i] = (int) Math.round((double) samples[i] / step) * step;
        }
        return encoded;
    }
}
