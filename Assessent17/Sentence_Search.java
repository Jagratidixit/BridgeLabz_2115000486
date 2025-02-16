import java.util.Scanner;

public class SentenceSearch {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) return sentence;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine();  //  will consume the leftover newline left by sc.nextInt() instead of reading a proper sentence.

        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        System.out.print("Enter the word to search: ");
        String word = sc.nextLine();

        System.out.println(findSentence(sentences, word));
    }
}
