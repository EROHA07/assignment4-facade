public class AudioMixer {
    public int[] mixToMono(MediaData source) {
        int[] left = source.getLeftChannel();
        int[] right = source.getRightChannel();
        if (left.length != right.length) {
            throw new IllegalArgumentException("Audio channels have different lengths");
        }

        int[] mono = new int[left.length];
        for (int i = 0; i < left.length; i++) {
            mono[i] = (left[i] + right[i]) / 2;
        }
        return mono;
    }
}
