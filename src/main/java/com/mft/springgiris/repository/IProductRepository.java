package com.mft.springgiris.repository;

import com.mft.springgiris.entity.Category;
import com.mft.springgiris.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByTitle(String title);

}
