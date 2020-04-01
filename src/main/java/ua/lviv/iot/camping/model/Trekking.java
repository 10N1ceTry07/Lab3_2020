package ua.lviv.iot.camping.model;

public class Trekking extends AbstractCamping {

    private boolean isAvailabilityOfTrekkingPoles;

    public Trekking(String name, String producer, double priceInUAH, double weightInKilo, ThingsType sortType,
            boolean isAvailabilityOfTrekkingPoles) {
        super(name, producer, priceInUAH, weightInKilo, sortType);
        this.isAvailabilityOfTrekkingPoles = isAvailabilityOfTrekkingPoles;
    }

    public boolean isAvailabilityOfTrekkingPoles() {
        return isAvailabilityOfTrekkingPoles;
    }

    public void setAvailabilityOfTrekkingPoles(boolean isAvailabilityOfTrekkingPoles) {
        this.isAvailabilityOfTrekkingPoles = isAvailabilityOfTrekkingPoles;
    }
    
    public String getHeaders() { return super.getHeaders() + "," +
            "isAvailabilityOfTrekkingPoles"; }
            
    public String toCSV() { return super.toCSV() + "," + isAvailabilityOfTrekkingPoles()+"\n"; }
}