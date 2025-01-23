public class earth_Vol {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double pi = Math.PI;
        double volumeKm3 = (4.0 / 3.0) * pi * Math.pow(radiusKm, 3);
        double kmToMile = 0.621371;
        double volumeMile3 = volumeKm3 * Math.pow(kmToMile, 3);
        System.out.print("The volume of Earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMile3 + "\n");
    }
}

