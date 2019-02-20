
public class Storage {
    private int storageId;
    private boolean isRented;
    private int rentalFeePerDay;
    private int discount;
    private int delayFee;

    public Storage(int storageId, int rentalFee, int delayFee, int discount) {
        this.storageId = storageId;
        this.isRented = false;
        this.rentalFeePerDay = rentalFee;
        this.delayFee = delayFee;
        this.discount = discount;
    }

    public int getStorageId() {
        return storageId;
    }

    public boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(boolean rentalState) {
        this.isRented = rentalState;
    }

    public int getRentalFeePerDay() {
        return rentalFeePerDay;
    }

    public int getDiscount() {
        return discount;
    }

    public int getDelayFee() {
        return delayFee;
    }
}
