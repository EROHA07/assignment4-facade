public class BitrateReader {
    public int selectBitrate(MediaData source, CodecProfile target) {
        if (target.getFormat().equals("wav")) {
            return target.getMaxBitrateKbps();
        }
        // Do not claim a compressed result has higher bitrate than its source.
        return Math.min(source.getBitrateKbps(), target.getMaxBitrateKbps());
    }
}
