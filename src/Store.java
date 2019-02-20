import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Store {
    private int numberOfStorage;
    private int numberOfSmallStorage;
    private int numberOfLargeStorage;
    private List<Storage> storages;

    public Store(int numberOfStorage, int numberOfSmallStorage, int numberOfLargeStorage,
                 int normalStorageFee, int smallStorageFee, int largeStorageFee, int delayFee, int discount) {
        this.numberOfStorage = numberOfStorage;
        this.storages = new ArrayList<>();

        for (int i = 0; i < numberOfSmallStorage; i++) {
            this.storages.add(new SmallStorage(i, smallStorageFee, delayFee, discount));
        }
        for (int i = numberOfSmallStorage; i < numberOfStorage - numberOfSmallStorage; i++) {
            this.storages.add(new Storage(i, normalStorageFee, delayFee, discount));
        }

    }

    public Optional<Storage> getNextAvailableStorage(Storage chosenStorageType) {
        for (Storage storage : this.storages
        ) {
            if (!storage.getIsRented() && chosenStorageType instanceof Storage) {
                return Optional.of(storage);
            }
        }
        return Optional.empty();
    }

    public Storage getStorageTypeFromCustomer() {
        System.out.println("Select the storage size from: small, normal, large");
        Storage s = null;
        Scanner scanner = new Scanner(System.in);
        String customerChoice = scanner.next();
        if (customerChoice.equals("small")) {
            return (SmallStorage) s;
        } else if (customerChoice.equals("large")){
            return (LargeStorage) s;
        }
        return s;
    }

}
