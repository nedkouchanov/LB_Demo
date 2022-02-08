package com.example.lb_demo.repostirories;

import com.example.lb_demo.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("SELECT p.name FROM Person p WHERE p.name LIKE %:personName%")
    String findByName(String personName);
}
