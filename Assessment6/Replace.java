import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the sentence: ");
        String sentence = sc.nextLine();
        
        System.out.print("Enter the word to replace: ");
        String oldWord = sc.next();
        
        System.out.print("Enter the new word: ");
        String newWord = sc.next();    
        sentence = sentence.replace(oldWord, newWord);
        System.out.println("Modified Sentence: " + sentence);
    }
}
