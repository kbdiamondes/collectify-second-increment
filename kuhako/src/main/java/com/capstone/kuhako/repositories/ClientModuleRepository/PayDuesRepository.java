package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.ClientModules.PayDues;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayDuesRepository extends CrudRepository<PayDues,Object> {
    List<PayDues> findByClient(Client client);
}
