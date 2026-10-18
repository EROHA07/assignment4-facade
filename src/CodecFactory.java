public class CodecFactory {
    public CodecProfile create(String targetFormat) {
        if (targetFormat == null) {
            throw new IllegalArgumentException("Target format cannot be null");
        }

        switch (targetFormat.trim().toLowerCase()) {
            case "wav": return new CodecProfile("wav", 1411, 1);
            case "mp3": return new CodecProfile("mp3", 192, 4);
            case "aac": return new CodecProfile("aac", 160, 3);
            default: throw new IllegalArgumentException("Unsupported target format: " + targetFormat);
        }
    }
}
