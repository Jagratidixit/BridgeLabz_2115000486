import java.time.LocalDateTime;

class Ticket {
    int ticketID, seatNumber;
    String customerName, movieName;
    LocalDateTime bookingTime;
    Ticket next;

    Ticket(int ticketID, String customerName, String movieName, int seatNumber) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head, tail;

    void addTicket(int ticketID, String customerName, String movieName, int seatNumber) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
    }

    void removeTicket(int ticketID) {
        if (head == null) return;

        Ticket temp = head, prev = null;
        do {
            if (temp.ticketID == ticketID) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    if (temp == head) head = head.next;
                    if (temp == tail) tail = prev;
                    if (prev != null) prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByCustomer(String customerName) {
        if (head == null) return;

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tickets found for " + customerName);
    }

    void searchByMovie(String movieName) {
        if (head == null) return;

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tickets found for movie " + movieName);
    }

    int getTotalTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Jagrati", "Inception", 12);
        system.addTicket(102, "Aditi", "Interstellar", 15);
        system.addTicket(103, "Vishesh", "Inception", 18);

        system.displayTickets();

        System.out.println("\nSearching for tickets by customer 'Jagrati':");
        system.searchByCustomer("Jagrati");

        System.out.println("\nSearching for tickets by movie 'Inception':");
        system.searchByMovie("Inception");

        System.out.println("\nTotal Tickets Booked: " + system.getTotalTickets());

        System.out.println("\nRemoving Ticket ID asked");
        system.removeTicket(102);
        system.displayTickets();
    }
}
