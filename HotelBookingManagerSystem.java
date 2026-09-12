import java.util.Scanner;

public class HotelBookingManagerSystem {

    static final int TOTAL_ROOMS = 50;

    static String[] roomTypes = {"Basic", "Luxury", "Delux", "Platinum"};
    static int[] roomPrices = {1500, 2000, 2700, 4000};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to Hotel Booking & Occupancy Manager =====");

        System.out.println("Enter your Name: ");
        String name = sc.nextLine();

        System.out.print("Place you are coming from: ");
        String place = sc.nextLine();

        System.out.print("Contact Number: ");
        String contact = sc.nextLine();

        System.out.print("Aadhar Card Number: ");
        String aadhar = sc.nextLine();

        System.out.print("Number of days you want the room for: ");
        int days = sc.nextInt();

        System.out.println("Available Room Types:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i] + " - Rs." + roomPrices[i] + " per day");
        }

        System.out.print("Enter the number corresponding to your room type choice: ");
        int choice = sc.nextInt();

        while (choice < 1 || choice > roomTypes.length) {
            System.out.print("Invalid choice. Please enter a valid option (1-" + roomTypes.length + "): ");
            choice = sc.nextInt();
        }

        int roomIndex = choice - 1;
        String selectedRoom = roomTypes[roomIndex];
        int pricePerDay = roomPrices[roomIndex];

        double totalBill = calculateBill(pricePerDay, days);

        double occupancyRate = calculateOccupancyRate(1, TOTAL_ROOMS);

        printInvoice(name, place, contact, aadhar, days, selectedRoom, pricePerDay, totalBill, occupancyRate);

        sc.close();
    }

    static double calculateBill(int pricePerDay, int days) {
        return pricePerDay * days;
    }

    static double calculateOccupancyRate(int roomsBooked, int totalRooms) {
        return ((double) roomsBooked / totalRooms) * 100;
    }

    static void printInvoice(String name, String place, String contact, String aadhar,
                              int days, String roomType, int pricePerDay,
                              double totalBill, double occupancyRate) {
        System.out.println("===== Booking Summary =====");
        System.out.println("Customer Name   : " + name);
        System.out.println("Place           : " + place);
        System.out.println("Contact Number  : " + contact);
        System.out.println("Aadhar Number   : " + aadhar);
        System.out.println("Room Type       : " + roomType);
        System.out.println("Price per Day   : Rs." + pricePerDay);
        System.out.println("Number of Days  : " + days);
        System.out.println("----------------------------");
        System.out.println("Total Bill      : Rs." + totalBill);
        System.out.println("Occupancy Rate  : " + occupancyRate + "%");
        System.out.println("----------------------------");
        System.out.println("Thank you for booking with us, " + name + "!");
    }
}