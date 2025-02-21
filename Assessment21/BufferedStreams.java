import java.io.*;

public class FileCopyComparison {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destinationFile1 = "copy_unbuffered.dat";
        String destinationFile2 = "copy_buffered.dat";

        long timeUnbuffered = copyUsingUnbufferedStreams(sourceFile, destinationFile1);
        long timeBuffered = copyUsingBufferedStreams(sourceFile, destinationFile2);

        System.out.println("Unbuffered Copy Time: " + timeUnbuffered + " ns");
        System.out.println("Buffered Copy Time: " + timeBuffered + " ns");
    }

    private static long copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
