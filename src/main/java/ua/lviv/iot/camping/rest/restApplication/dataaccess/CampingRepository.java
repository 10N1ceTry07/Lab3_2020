package ua.lviv.iot.camping.rest.restApplication.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.camping.rest.restApplication.model.*;

@Repository
public interface CampingRepository extends JpaRepository<AbstractCamping, Integer> {

}