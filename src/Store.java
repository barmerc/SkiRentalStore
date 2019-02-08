import java.util.ArrayList;
import java.util.List;

public class Store {
    private int numberOfStorage;
    private List<Storage> lockers;
    private Storage nextAvailableStorage;

    public Store(int numberOfStorage, int rentalFee, int delayFee){
        this.numberOfStorage = numberOfStorage;
        this.lockers = new ArrayList<>();

        for(int i = 0; i < numberOfStorage; i++){
            this.lockers.add(new Storage(i, rentalFee, delayFee));
        }
    }

    public Storage getNextAvailableStorage(){
        return this.nextAvailableStorage;
    }

    public Storage findNextAvailableStorage(){
        for (Storage storage: this.lockers
        ) {
            if(!storage.getIsRented()){
                return storage;
            }
        }
        return null;
    }

    public boolean tryToRent(){
        this.nextAvailableStorage = this.findNextAvailableStorage();
        if(this.nextAvailableStorage != null){
            return true;
        }
        return false;
    }
}
