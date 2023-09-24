package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.ClientModules.DuePayments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuePaymentsRepository extends CrudRepository<DuePayments,Object> {
    /*List<DuePayments> findbyClient(Client client);*/
    @Query("SELECT dp FROM DuePayments dp WHERE dp.client.client_id = :clientId")
    Iterable<DuePayments> findDuePaymentsByClientId(@Param("clientId") Long clientId);

}
