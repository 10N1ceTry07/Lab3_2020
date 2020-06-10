package ua.lviv.iot.camping.rest.restApplication.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.camping.rest.restApplication.dataaccess.CampingMagazineRepository;
import ua.lviv.iot.camping.rest.restApplication.model.*;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CampingMagazineService {

    @Autowired
    private CampingMagazineRepository campingMagazineRepository;

    public List<CampingMagazine> getAllMagazines() {
        return campingMagazineRepository.findAll();
    }

    public CampingMagazine getMagazineById(Integer magazineId) {
        try {
            return campingMagazineRepository.findById(magazineId).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public CampingMagazine createMagazine(CampingMagazine magazine) {
        return campingMagazineRepository.save(magazine);
    }

    public CampingMagazine updateMagazine(Integer magazineId, CampingMagazine magazine) {
        magazine.setId(magazineId);
        return campingMagazineRepository.save(magazine);
    }

    public void deleteMagazine(Integer magazineId) {
        campingMagazineRepository.deleteById(magazineId);
    }

    public boolean magazineExists(Integer magazineId) {
        return campingMagazineRepository.existsById(magazineId);
    }

}
