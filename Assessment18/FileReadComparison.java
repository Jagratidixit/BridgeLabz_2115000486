import java.io.*;

public class FileReadComparison {

    public static void measureReadTime(String filePath) throws IOException {
        long start, fileReaderTime, inputStreamReaderTime;

        // FileReader (Character Stream)
        start = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            while (fr.read() != -1);
        }
        fileReaderTime = System.nanoTime() - start;

        // InputStreamReader (Byte Stream to Character Stream)
        start = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1);
        }
        inputStreamReaderTime = System.nanoTime() - start;

        System.out.println("File Size: " + (new File(filePath).length() / (1024 * 1024)) + " MB");
        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000 + " ms");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; // Change this to your file path
        measureReadTime(filePath);
    }
}
