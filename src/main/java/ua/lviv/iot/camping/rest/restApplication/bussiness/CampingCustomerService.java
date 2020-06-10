package ua.lviv.iot.camping.rest.restApplication.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.camping.rest.restApplication.dataaccess.CampingCustomerRepository;
import ua.lviv.iot.camping.rest.restApplication.model.*;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CampingCustomerService {

    @Autowired
    private CampingCustomerRepository campingCustomerRepository;

    public List<CampingCustomer> getAllCampingCustomers() {
        return campingCustomerRepository.findAll();
    }

    public CampingCustomer getCampingCustomerById(Integer campingcustomerId) {
        try {
            return campingCustomerRepository.findById(campingcustomerId).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public CampingCustomer createCampingCustomer(CampingCustomer campingcustomer) {
        return campingCustomerRepository.save(campingcustomer);
    }

    public CampingCustomer updateCampingCustomer(Integer campingcustomerId, CampingCustomer campingcustomer) {
        campingcustomer.setId(campingcustomerId);
        return campingCustomerRepository.save(campingcustomer);
    }

    public void deleteCampingCustomer(Integer campingcustomerId) {
        campingCustomerRepository.deleteById(campingcustomerId);
    }

    public boolean campingCustomerExists(Integer campingcustomerId) {
        return campingCustomerRepository.existsById(campingcustomerId);
    }

}
