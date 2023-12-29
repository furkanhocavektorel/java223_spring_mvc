package com.mft.springgiris.service;

import com.mft.springgiris.entity.Customer;
import com.mft.springgiris.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void saveCustomer(String name
            ,String surname
            ,String mail
            ,String password
            ,int age){
        Customer customer= Customer.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .email(mail)
                .password(password)
                .build();
        customerRepository.save(customer);

    }

    // 1.yöntem yanlisdir.
    public boolean login(String email, String password) {
       List<Customer> customers =customerRepository.findAll();
       for (Customer customer: customers){
           if (customer.getEmail().equals(email) && customer.getPassword().equals(password)){
               return true;
           }
       }
       return false;
    }
    // 2.yöntem dogrusu...
    public Customer login2(String email,String password){
        Optional<Customer> customer=customerRepository
                .findOptionalByEmailAndPassword(email,password);
        if (customer.isPresent()){
            return customer.get();
        }else {
            return customer.get();
        }
    }
}
