package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.models.ClientModules.TransactionHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory,Object> {
    @Query("SELECT ts FROM TransactionHistory ts WHERE ts.client.client_id = :clientId")
    Iterable<TransactionHistory> findTransactionHistoryByClientId(@Param("clientId") Long clientId);
}
