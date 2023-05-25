package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.TransactionHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory,Object> {
}
