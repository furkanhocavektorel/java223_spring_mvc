package com.mft.springgiris.repository;

import com.mft.springgiris.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    // Optional null dönebilecek durumda
    // sistemin hata fırlatmaması için oluşturulmuş bir yapıdır.

    Optional<Customer> findOptionalByEmailAndPassword(String a, String b);

    List<Customer> findByName(String name);


}
