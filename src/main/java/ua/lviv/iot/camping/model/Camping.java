package ua.lviv.iot.camping.model;

public class Camping extends AbstractCamping {

    private boolean isAvailabilityOfTent;

    public Camping(String name, String producer, double priceInUAH, double weightInKilo, ThingsType sortType,
            boolean isAvailabilityOfTent) {
        super(name, producer, priceInUAH, weightInKilo, sortType);
        this.isAvailabilityOfTent = isAvailabilityOfTent;
    }

    public boolean isAvailabilityOfTent() {
        return isAvailabilityOfTent;
    }

    public void setAvailabilityOfTent(boolean isAvailabilityOfTent) {
        this.isAvailabilityOfTent = isAvailabilityOfTent;
    }
    public String getHeaders() { return super.getHeaders() + "," +
            "isAvailabilityOfTent"; }
            
    public String toCSV() { return super.toCSV() + "," + isAvailabilityOfTent()+"\n"; }
}
