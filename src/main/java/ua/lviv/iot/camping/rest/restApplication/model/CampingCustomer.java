package ua.lviv.iot.camping.rest.restApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "campingcustomers")
public class CampingCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;

    @JsonIgnoreProperties("campingcustomers")
    @ManyToMany(mappedBy = "campingcustomers")
    private Set<CampingMagazine> campingmagazines;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public CampingCustomer() {

    }


    public Set<CampingMagazine> getCampingmagazines() {
        return campingmagazines;
    }

    public void setCampingmagazines(Set<CampingMagazine> campingmagazines) {
        this.campingmagazines = campingmagazines;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}