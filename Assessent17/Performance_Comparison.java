     import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String sample = "hello";
        
        long sbStart = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long sbEnd = System.nanoTime();
        long sbTime = sbEnd - sbStart;
        
        long sBufferStart = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuffer.append(sample);
        }
        long sBufferEnd = System.nanoTime();
        long sBufferTime = sBufferEnd - sBufferStart;
        
        System.out.println("StringBuilder concatenation time: " + sbTime + " ns");
        System.out.println("StringBuffer concatenation time: " + sBufferTime + " ns");

        String fileName = "largefile.txt";
        
        try {
            long frStart = System.nanoTime();
            int wordCountFR = countWordsUsingFileReader(fileName);
            long frEnd = System.nanoTime();
            long frTime = frEnd - frStart;
            System.out.println("FileReader method: " + wordCountFR + " words in " + frTime + " ns");
        } catch (IOException e) {
            System.err.println("Error with FileReader: " + e.getMessage());
        }
        
        try {
            long isrStart = System.nanoTime();
            int wordCountISR = countWordsUsingInputStreamReader(fileName);
            long isrEnd = System.nanoTime();
            long isrTime = isrEnd - isrStart;
            System.out.println("InputStreamReader method: " + wordCountISR + " words in " + isrTime + " ns");
        } catch (IOException e) {
            System.err.println("Error with InputStreamReader: " + e.getMessage());
        }
    }

    public static int countWordsUsingFileReader(String fileName) throws IOException {
        int count = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countWordsUsingInputStreamReader(String fileName) throws IOException {
        int count = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


