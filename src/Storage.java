import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Storage {
    static final long MAX_RENTAL_TIME = 3;
    private int storageId;
    private int rentalFeePerDay;
    private int delayFee;
    private boolean isRented;
    private Ticket rentalTicket;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private int TicketNumber = random.nextInt(100)+this.storageId;


    public Storage(int storageId, int rentalFee, int delayFee){
        this.storageId = storageId;
        this.rentalFeePerDay = rentalFee;
        this.delayFee = delayFee;
        this.isRented = false;
    }

    public boolean getIsRented(){
        return this.isRented;
    }

    private void setIsRented(boolean rentalState){
        this.isRented = rentalState;
    }

    public Ticket startRental(){
        System.out.println("Please enter how many days you want to rent from the maximal 3 days?");
        int rentalTime = sc.nextInt();
        this.getPayment(rentalTime);
        this.setIsRented(true);
        this.rentalTicket = new Ticket(TicketNumber, LocalDateTime.now());
        System.out.println("You got the "+this.storageId+". storage with the "
                + this.rentalTicket.getRentalTicketNumber() + " rental ticket number, start of your rental: " +
                this.rentalTicket.getFormattedStartDateOfRental() + ". You have 3 days until your ticket expire!");
        return this.rentalTicket;
    }

    public void endRental(){
        System.out.println("Please give your ticket number!");
        int rentalTicketNumber;
        rentalTicketNumber = sc.nextInt();

        while(this.rentalTicket.getRentalTicketNumber() != rentalTicketNumber) {
            System.out.println("Invalid ticket number! Please give your rental ticket number again!");
            rentalTicketNumber = sc.nextInt();
        }
        if(this.isExpired()){
            this.getDelayFee();
        }
        this.setIsRented(false);
        System.out.println("Your rental process successfully closed. Thank you!");
    }

    private void getPayment(int rentalTime){
        System.out.println("Please insert "+this.rentalFeePerDay * rentalTime+" for the storage you would like to rent.");
    }

    private void getDelayFee(){
        System.out.println("Your rental expired, please insert " + this.delayFee + " delay fee!");
    }

    private boolean isExpired(){
        LocalDateTime endDateOfRental = LocalDateTime.now();
        LocalDateTime expireDate = this.rentalTicket.getStartDateOfRental().plusDays(MAX_RENTAL_TIME);
        return endDateOfRental.isAfter(expireDate);
    }
}
