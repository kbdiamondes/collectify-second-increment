package com.capstone.kuhako.repositories;

import com.capstone.kuhako.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Object> {
    Client findByUsername(String fullName);
}
