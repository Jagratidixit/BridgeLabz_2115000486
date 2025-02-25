public class SpaceReducer {
    public static String reduceSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        String text = "This   is  an    example   with   multiple   spaces.";
        System.out.println(reduceSpaces(text)); // "This is an example with multiple spaces."
    }
}
