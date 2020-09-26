package com.nikolinaspringboot.cms.dao;

import com.nikolinaspringboot.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //za rad sa bazom
public interface CustomerDAO extends CrudRepository<Customer, Integer> {

    @Override
    List<Customer> findAll();
}
