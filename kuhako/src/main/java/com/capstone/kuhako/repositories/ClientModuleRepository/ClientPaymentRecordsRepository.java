package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.ClientPaymentRecords;
import com.capstone.kuhako.models.ClientModules.DuePayments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPaymentRecordsRepository extends CrudRepository<ClientPaymentRecords,Object> {


    @Query("SELECT cpr FROM ClientPaymentRecords cpr WHERE cpr.client.client_id = :clientId")
    Iterable<ClientPaymentRecords> findClientPaymentRecordsClientId(@Param("clientId") Long clientId);
}
