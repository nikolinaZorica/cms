package com.nikolinaspringboot.cms.service;

import com.nikolinaspringboot.cms.exception.CustomerNotFoundException;
import com.nikolinaspringboot.cms.dao.CustomerDAO;
import com.nikolinaspringboot.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;


    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {
        /*customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/
        return customerDAO.save(customer);
        //return customer;
    }

    public List<Customer> getCustomers(){

        return customerDAO.findAll(); //u interface CustomerDAO overridali smo findAll() metodu (iz Iretable u List)
       // return customerList;
    }

    public Customer geCustomer(int customerId) {
/*        return customerList
                    .stream()
                    .filter(c -> c.getCustomerId() == customerId)
                    .findFirst()
                    .get();*/
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available...");


        return optionalCustomer.get(); //vraća Optional object ako ne pozovemo .get() metodu
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        /*customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        return customerList
                    .stream()
                    .filter(c -> c.getCustomerId() == customerId)
                    .findFirst()
                    .get();*/

        customer.setCustomerId(customerId);
        return customerDAO.save(customer);

    }

    public void deleteCustomer(int customerId) {
        /*customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId) {
                        customerList.remove(c);
                    }
                });*/
        customerDAO.deleteById(customerId);
    }
}
