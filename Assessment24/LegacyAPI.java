class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("Old feature - Do not use");
    }

    void newFeature() {
        System.out.println("New feature - Use this");
    }
}

public class Main {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
