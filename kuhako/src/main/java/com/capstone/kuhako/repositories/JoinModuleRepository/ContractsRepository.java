package com.capstone.kuhako.repositories.JoinModuleRepository;

import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.models.JoinModule.ContractsClient;
import com.capstone.kuhako.models.JoinModule.ContractsCollector;
import com.capstone.kuhako.models.JoinModule.ContractsReseller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsRepository extends CrudRepository<Contracts,Object> {
    @Query("SELECT NEW com.capstone.kuhako.models.JoinModule.ContractsReseller(cl.username, co.itemName, co.itemPrice, co.paymentType) FROM Contracts co JOIN co.client cl WHERE co.reseller.reseller_id = :resellerId")
    Iterable<ContractsReseller> findContractsByResellerId(@Param("resellerId") Long resellerId);

    @Query("SELECT NEW com.capstone.kuhako.models.JoinModule.ContractsCollector(cl.username, co.totalAmountPaid) FROM Contracts co JOIN co.client cl WHERE co.collector.collector_id = :collectorId")
    Iterable<ContractsCollector> findContractsByCollectorId(@Param("collectorId") Long collectorId);

    @Query("SELECT NEW com.capstone.kuhako.models.JoinModule.ContractsClient(co.itemName, co.itemPrice) FROM Contracts co WHERE co.client.client_id = :clientId")
    Iterable<ContractsClient> findContractsByClientId(@Param("clientId") Long collectorId);
}
