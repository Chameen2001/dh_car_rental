package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.CustomerDTO;
import lk.bula.chameen.spring.entity.Customer;
import lk.bula.chameen.spring.repo.CustomerRepo;
import lk.bula.chameen.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!customerRepo.existsCustomerByEmail(dto.getEmail())) {
            System.out.println("athuleeee");
            dto.setId(this.getNewId());
            Customer customer = modelMapper.map(dto, Customer.class);
            System.out.println(customer);
            customerRepo.save(customer);

        } else {
            throw new RuntimeException("Your email is already in use");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new RuntimeException("There is no customer like " + id);
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getId())) {
            customerRepo.save(modelMapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("There is not a customer like " + dto.getId());
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerRepo.existsById(id)) {
            System.out.println(customerRepo.findById(id).get());
            return modelMapper.map(customerRepo.findById(id).get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {

        }.getType());
    }

    @Override
    public String getNewId() {
        String latestId = customerRepo.getLatestId();
        if (latestId != null) {
            String id;
            int nextNumber = Integer.parseInt(latestId.split("-")[1]) + 1;

            if (nextNumber < 10) {
                id = "C00-00" + nextNumber;
            } else if (nextNumber < 100) {
                id = "C00-0" + nextNumber;
            } else {
                id = "C00-" + nextNumber;
            }

            return id;

        } else {
            return "C00-001";
        }
    }

}
