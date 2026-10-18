# Assignment 4 - Facade Pattern

**Student:** Nassypkeliyev Yerassyl  
**Group:** SE2538  
**Topic:** Option A - Media / File Conversion Facade  
**Language:** Java 17

## Project idea

The client has one simple operation:

```java
MediaConversionFacade facade = new MediaConversionFacade();
System.out.println(facade.convert("lecture.wav", "mp3"));
```

The facade coordinates five subsystem classes:

1. `MetadataReader` - validates a filename, determines source format and builds sample input.
2. `CodecFactory` - selects output format and encoding settings.
3. `BitrateReader` - selects an output bitrate.
4. `AudioMixer` - combines stereo channels into mono samples.
5. `AudioEncoder` - applies simplified sample quantization.

`Main` creates only `MediaConversionFacade`; it does not create or directly call subsystem services. The subsystem classes do not know about the facade. They remain available to an advanced client that wants to use them directly.

**Important:** This is a simulation with small integer audio samples. It does **not** read, write, or produce playable audio files. The chosen option explicitly allows simulated media data.

## Run (JDK 17)

In the project folder:

```bash
javac --release 17 -encoding UTF-8 -d out @sources.txt
java -cp out Main
java -cp out Main --test
```

`Main` demonstrates three successful conversions and two invalid requests.
`Main --test` checks six cases and should print `SUMMARY: 6/6 PASS`.

## Structure

```text
src/
  Main.java
  MediaConversionFacade.java
  MetadataReader.java
  CodecFactory.java
  BitrateReader.java
  AudioMixer.java
  AudioEncoder.java
  MediaData.java
  CodecProfile.java
sources.txt
README.md
report.pdf
```

## Why Facade?

Without the facade, `Main` would have to create all five services, know their call order, move data between them, and handle exceptions. The facade hides these coordination details behind `convert(fileName, targetFormat)`.

## GitHub repository

Create a repository named `assignment4-facade` under your account `EROHA07` before submission:

https://github.com/EROHA07/assignment4-facade

The URL above is the intended repository address, not confirmation that the repository has already been created.
