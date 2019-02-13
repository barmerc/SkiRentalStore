public class Main {
    public static void main(String[] args){

        Store store = new Store(2,200, 100);
        System.out.println("Welcome, the new SkiRentalStore is now open!");
        if(store.tryToRent()){
            Storage storage = store.getNextAvailableStorage();
            Ticket rentTicket = storage.startRental();
            storage.endRental();
        }else{
            System.out.println("Sorry, no more storage left to rent.");
        }
    }
}
