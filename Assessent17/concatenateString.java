public class ConcatenateStrings {
    public static String concatenate(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"Hello", " ", "World", "!", " Welcome"};
        String sb=concatenate(arr);
        System.out.print("Concatenated String is: "+sb);
    }
}
