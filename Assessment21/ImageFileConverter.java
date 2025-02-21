import java.io.*;
import java.util.Arrays;

public class ImageFileConverter {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String outputImage = "copy.jpg";

        byte[] imageBytes = convertImageToByteArray(sourceImage);
        if (imageBytes != null) {
            writeByteArrayToImage(imageBytes, outputImage);
            if (verifyFiles(sourceImage, outputImage)) {
                System.out.println("Verification successful: Files are identical.");
            } else {
                System.out.println("Verification failed: Files are different.");
            }
        }
    }

    private static byte[] convertImageToByteArray(String filePath) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return null;
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image successfully written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
        }
    }

    private static boolean verifyFiles(String file1, String file2) {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] file1Bytes = fis1.readAllBytes();
            byte[] file2Bytes = fis2.readAllBytes();
            return Arrays.equals(file1Bytes, file2Bytes);
        } catch (IOException e) {
            System.out.println("Error verifying files: " + e.getMessage());
            return false;
        }
    }
}
