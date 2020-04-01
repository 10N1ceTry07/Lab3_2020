package ua.lviv.iot.camping.model;

public class Boating extends AbstractCamping {

    private boolean isAvailabilityOfBoat;

    public Boating(String name, String producer, double priceInUAH, double weightInKilo, ThingsType sortType,
            boolean isAvailabilityOfBoat) {
        super(name, producer, priceInUAH, weightInKilo, sortType);
        this.isAvailabilityOfBoat = isAvailabilityOfBoat;
    }

    public boolean isAvailabilityOfBoat() {
        return isAvailabilityOfBoat;
    }

    public void setAvailabilityOfBoat(boolean isAvailabilityOfBoat) {
        this.isAvailabilityOfBoat = isAvailabilityOfBoat;
    }
    public String getHeaders() { return super.getHeaders() + "," +
            "isAvailabilityOfBoat"; }
            
    public String toCSV() { return super.toCSV() + "," + isAvailabilityOfBoat()+"\n"; }
}
