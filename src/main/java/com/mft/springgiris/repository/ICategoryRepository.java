package com.mft.springgiris.repository;

import com.mft.springgiris.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findOptionalByName(String name);

}
