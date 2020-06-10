package ua.lviv.iot.camping.rest.restApplication.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.camping.rest.restApplication.model.*;

public interface CampingMagazineRepository extends JpaRepository<CampingMagazine,Integer> {

}