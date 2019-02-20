import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Rental {
    static final long MAX_RENTAL_TIME = 3;
    private Storage storage;
    private Store store;
    private Ticket rentalTicket;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int TicketNumber = random.nextInt(100) + this.storage.getStorageId();

    public Rental(Storage storage) {
        this.storage = storage;
    }

    public Ticket startRental() {
        System.out.println("Please enter how many days you want to rent from the maximal 3 days?");
        int rentalTime = scanner.nextInt();
        getPayment(rentalTime);
        storage.setIsRented(true);
        rentalTicket = new Ticket(TicketNumber, LocalDateTime.now());
        printTicket();
        return this.rentalTicket;
    }

    public void endRental(Ticket ticket) {
        validateTicket();
        if (isExpired()) {
            printDelayFee();
        }
        storage.setIsRented(false);
        System.out.println("Your rental process successfully closed. Thank you!");
    }

    private void getPayment(int rentalTime) {
        int payment = this.storage.getRentalFeePerDay() * rentalTime;
        int paymentWithDiscount = payment - this.storage.getDiscount();
        if (rentalTime == MAX_RENTAL_TIME) {
            System.out.println(this.printPaymentMessage(paymentWithDiscount));
        } else {
            System.out.println(this.printPaymentMessage(payment));
        }
    }

    private String printPaymentMessage(int payment) {
        return "Please insert " + payment + " for the storage you would like to rent.";
    }

    private void printDelayFee() {
        System.out.println("Your rental expired, please insert " + storage.getDelayFee() + " delay fee!");
    }

    private boolean isExpired() {
        LocalDateTime endDateOfRental = LocalDateTime.now();
        LocalDateTime expireDate = rentalTicket.getStartDateOfRental().plusDays(MAX_RENTAL_TIME);
        return endDateOfRental.isAfter(expireDate);
    }

    private void printTicket() {
        System.out.println("You got the " + storage.getStorageId() + ". storage with the "
                + rentalTicket.getRentalTicketNumber() + " rental ticket number, start of your rental: " +
                rentalTicket.getFormattedStartDateOfRental() + ". You have 3 days until your ticket expire!");
    }

    private void validateTicket() {
        System.out.println("Please give your ticket number!");
        int rentalTicketNumber;
        rentalTicketNumber = scanner.nextInt();

        while (rentalTicket.getRentalTicketNumber() != rentalTicketNumber) {
            System.out.println("Invalid ticket number! Please give your rental ticket number again!");
            rentalTicketNumber = scanner.nextInt();
        }
    }
}
