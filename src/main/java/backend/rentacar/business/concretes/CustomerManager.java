package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CustomerService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.CustomerDao;
import backend.rentacar.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public DataResult<List<Customer>> getall() {
        return new SuccessDataResult<>(this.customerDao.findAll(),"Customers listed.");
    }

    @Override
    public Result add(Customer customer) {
        this.customerDao.save(customer);
        return new SuccessResult("Customer added.");
    }
}
