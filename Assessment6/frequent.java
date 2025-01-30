import java.util.*;

public class frequent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int freq[]=new int[256];
        int maxfreq=0;
        char mostFrequent=' ';
        for(char ch:str.toCharArray()){
            freq[ch]++;
            if(freq[ch]>maxfreq){
                maxfreq=freq[ch];
                mostFrequent=ch;
            }
        }
        
        System.out.println("Most frequent character is: " + mostFrequent);
    }
}

