package ua.lviv.iot.camping.rest.restApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "\"campingMagazines\"")
public class CampingMagazine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer yearOfFoundation;
    private Integer amountOfThings;

    @OneToMany(mappedBy = "campingMagazine")
    @JsonIgnoreProperties("campingMagazine")
    private Set<AbstractCamping> abstractcampings;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Camping_Customer", joinColumns = {
            @JoinColumn(name = "campingcustomer_id", nullable = false) },
            inverseJoinColumns = {
                    @JoinColumn(name = "abstractcamping_id", nullable = false) })
    @JsonIgnoreProperties("campingmagazines")
    private Set<CampingCustomer> campingcustomers;



    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public CampingMagazine() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(Integer yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public Integer getAmountOfThings() {
        return amountOfThings;
    }

    public void setAmountOfThings(Integer amountOfThings) {
        this.amountOfThings = amountOfThings;
    }

    public Set<AbstractCamping> getAbstractcampings() {
        return abstractcampings;
    }

    public void setAbstractcampings(Set<AbstractCamping> abstractcampings) {
        this.abstractcampings = abstractcampings;
    }

    public Set<CampingCustomer> getCampingcustomers() {
        return campingcustomers;
    }

    public void setCampingcustomers(Set<CampingCustomer> campingcustomers) {
        this.campingcustomers = campingcustomers;
    }
}