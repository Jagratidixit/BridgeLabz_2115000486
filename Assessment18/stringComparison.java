import java.util.*;

public class stringComparison{
    
    public static void measureStringTimes(int N) {
        Random rand = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++)
        {
        // 'a' + rand.nextInt(26)
        // 'a' is the character 'a' in ASCII (which is 97).
        // Adding a random number (0 to 25) shifts it to a random lowercase letter ('a' to 'z').
        str.append((char) ('a' + rand.nextInt(26)));
        }
        String inputString = str.toString();


        long start, stringTime, stringBuilderTime, stringBufferTime;

        //string
        start = System.nanoTime();
        String newstr = "";
        for (int i = 0; i < N; i++) newstr += inputString.charAt(i);
        stringTime = System.nanoTime() - start;
        
        //StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(inputString.charAt(i));
        stringBuilderTime = System.nanoTime() - start;

        //StringBuffer
        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) sf.append(inputString.charAt(i));
        stringBufferTime = System.nanoTime() - start;

        System.out.println("Dataset Size: " + N);
        System.out.println("String Time: " + stringTime / 1_000_000 + " ms");
        System.out.println("StringBuilder Time: " + stringBuilderTime / 1_000_000 + " ms");
        System.out.println("StringBuffer Time: " + stringBufferTime / 1_000_000 + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 100000};
        for (int size : datasetSizes) measureStringTimes(size);
    }
}
