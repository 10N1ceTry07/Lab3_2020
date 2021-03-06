package ua.lviv.iot.camping.rest.restApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AbstractCamping {

    private String name;
    private String producer;
    private double priceInUAH;
    private double weightInKilo;
    private ThingsType thingsType;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AbstractCamping(String name, String producer, double priceInUAH, double weightInKilo,
            ThingsType thingsType) {
        super();
        this.name = name;
        this.producer = producer;
        this.priceInUAH = priceInUAH;
        this.weightInKilo = weightInKilo;
        this.thingsType = thingsType;
    }

    public AbstractCamping() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPriceInUAH() {
        return priceInUAH;
    }

    public void setPriceInUAH(double priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public double getWeightInKilo() {
        return weightInKilo;
    }

    public void setWeightInKilo(double weightInKilo) {
        this.weightInKilo = weightInKilo;
    }

    public ThingsType getThingsType() {
        return thingsType;
    }

    public void setThingsType(ThingsType thingsType) {
        this.thingsType = thingsType;
    }

    public String getHeaders() {
        return "name" + "," + " producer" + "," + "priceInUAH" + "," + "weightInKilo" + "," + "thingsType";
    }

    public String toCSV() {
        return getName() + "," + getProducer() + "," + getPriceInUAH() + "," + getWeightInKilo() + ","
                + getThingsType();
    }

}
