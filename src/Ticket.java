import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private int rentalTicketNumber;
    private LocalDateTime startDateOfRental;

    public Ticket(int rentalTicketNumber, LocalDateTime startDateOfRental){
        this.rentalTicketNumber = rentalTicketNumber;
        this.startDateOfRental = startDateOfRental;
    }

    public String getFormattedStartDateOfRental(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM. dd. HH:mm");
        String formattedStartDateOfRental = this.startDateOfRental.format(formatter);
        return formattedStartDateOfRental;
    }

    public int getRentalTicketNumber(){
        return this.rentalTicketNumber;
    }

    public LocalDateTime getStartDateOfRental(){
        return this.startDateOfRental;
    }

}
