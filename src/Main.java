public class Main {
    public static void main(String[] args) {
        MediaConversionFacade facade = new MediaConversionFacade();

        if (args.length > 0 && args[0].equals("--test")) {
            runTests(facade);
            return;
        }

        System.out.println("=== Media Conversion Facade Demo ===");
        System.out.println(facade.convert("lecture.wav", "mp3"));
        System.out.println(facade.convert("music.mp3", "aac"));
        System.out.println(facade.convert("voice.aac", "wav"));
        System.out.println(facade.convert("notes.txt", "mp3"));
        System.out.println(facade.convert("lecture.wav", "avi"));
    }

    private static void runTests(MediaConversionFacade facade) {
        int passed = 0;
        passed += test("T1 WAV to MP3", facade.convert("lecture.wav", "mp3"),
                "SUCCESS | lecture.wav -> lecture.mp3");
        passed += test("T2 MP3 to AAC", facade.convert("music.mp3", "aac"),
                "SUCCESS | music.mp3 -> music.aac");
        passed += test("T3 AAC to WAV", facade.convert("voice.aac", "wav"),
                "SUCCESS | voice.aac -> voice.wav");
        passed += test("T4 bad input", facade.convert("notes.txt", "mp3"),
                "ERROR | Unsupported input format: txt");
        passed += test("T5 bad output", facade.convert("lecture.wav", "avi"),
                "ERROR | Unsupported target format: avi");
        passed += test("T6 empty name", facade.convert("", "mp3"),
                "ERROR | File name cannot be empty");
        System.out.println("SUMMARY: " + passed + "/6 PASS");
        if (passed != 6) System.exit(1);
    }

    private static int test(String name, String actual, String expectedStart) {
        boolean pass = actual.startsWith(expectedStart);
        System.out.println(name + " | " + (pass ? "PASS" : "FAIL") + " | " + actual);
        return pass ? 1 : 0;
    }
}
