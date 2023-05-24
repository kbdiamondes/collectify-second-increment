package com.capstone.kuhako.repositories;

import com.capstone.kuhako.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Object> {

    // Custom method to find a user using username
    User findByUsername(String username);
}
