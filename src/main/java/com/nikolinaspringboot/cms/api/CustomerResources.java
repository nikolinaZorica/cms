package com.nikolinaspringboot.cms.api;

import com.nikolinaspringboot.cms.model.Customer;
import com.nikolinaspringboot.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResources {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
        return customerService.geCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId")int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
