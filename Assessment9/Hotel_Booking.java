import java.util.*;
public class HotelBooking{
        String guestName;
        String roomType;
        int nights;

        public HotelBooking(){}

        public HotelBooking(String guestName,String roomType,int nights){
                this.guestName=guestName;
                this.roomType=roomType;
                this.nights=nights;
        }
        //Copy Constructor
        public HotelBooking(HotelBooking booking){
                this.guestName=booking.guestName;
                this.roomType=booking.roomType;
                this.nights=booking.nights;
        }


        public void display() {
        System.out.println("GuestName is: " + guestName);
        System.out.println("RoomType is: " + roomType);
        System.out.println("Nights are: " + nights);
        }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Details");
        System.out.print("Enter name :");
        String guestname=sc.nextLine();
        System.out.print("Enter roomtype:");
        String roomtype=sc.nextLine();
        System.out.print("Enter nights to stay:");
        int nights=sc.nextInt();
        HotelBooking booking1 = new HotelBooking(guestname,roomtype,nights);
        HotelBooking booking2= new HotelBooking(booking1);
        booking2.display();
    }
}
