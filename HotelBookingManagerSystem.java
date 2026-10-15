import java.util.Scanner;
import java.util.InputMismatchException;

// Parent class
class Room {
    String type;   // room name
    int price;     // price per day

    // Constructor
    Room(String type, int price) {
        this.type = type;
        this.price = price;
    }

    // Method overloading: same name, different parameters
    double calculateBill(int days) {
        return price * days;
    }

    double calculateBill(int days, int discount) {
        return price * days * (100 - discount) / 100.0;
    }
}

// Child class (Inheritance)
class LuxuryRoom extends Room {
    LuxuryRoom() {
        super("Luxury", 2000);   // calls the parent constructor
    }

    // Method overriding: Luxury rooms get 10% off
    @Override
    double calculateBill(int days) {
        return price * days * 0.9;
    }
}

public class HotelBookingManagerSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // for taking user input

        // Room names and prices (same index = same room)
        String[] roomTypes = {"Basic", "Luxury", "Delux", "Platinum"};
        int[] roomPrices = {1500, 2000, 2700, 4000};

        try {
            // Take guest details
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Aadhar Card Number (12 digits): ");
            String aadhar = sc.nextLine();

            // Aadhaar must be 12 characters
            if (aadhar.length() != 12) {
                System.out.println("Invalid Aadhar number.");
                return;
            }

            System.out.print("Number of days: ");
            int days = sc.nextInt();

            // Days must be positive
            if (days <= 0) {
                System.out.println("Days must be more than 0.");
                return;
            }

            // Print the room menu
            for (int i = 0; i < roomTypes.length; i++) {
                System.out.println((i + 1) + ". " + roomTypes[i] + " - Rs." + roomPrices[i]);
            }

            System.out.print("Choose room (1-4): ");
            int choice = sc.nextInt();

            // Keep asking until a valid choice is entered
            while (choice < 1 || choice > 4) {
                System.out.print("Invalid. Choose again (1-4): ");
                choice = sc.nextInt();
            }

            // Create the room object based on choice
            Room room;
            if (choice == 2) {
                room = new LuxuryRoom();
            } else {
                room = new Room(roomTypes[choice - 1], roomPrices[choice - 1]);
            }

            // Calculate the bill (Luxury uses the overridden method)
            double bill = room.calculateBill(days);

            // Print booking summary
            System.out.println("\n===== Booking Summary =====");
            System.out.println("Name      : " + name.toUpperCase());
            System.out.println("Room      : " + room.type);
            System.out.println("Days      : " + days);
            System.out.println("Total Bill: Rs." + bill);

        } catch (InputMismatchException e) {
            // Runs if the user types text instead of a number
            System.out.println("Error: Please enter numbers only.");
        }

        sc.close();
    }
}