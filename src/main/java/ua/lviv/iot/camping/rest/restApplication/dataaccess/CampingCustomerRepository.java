package ua.lviv.iot.camping.rest.restApplication.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.camping.rest.restApplication.model.*;

public interface CampingCustomerRepository extends JpaRepository<CampingCustomer, Integer> {

}