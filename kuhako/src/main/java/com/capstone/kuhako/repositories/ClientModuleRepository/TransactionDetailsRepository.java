package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.TransactionDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends CrudRepository<TransactionDetails,Object> {
}
