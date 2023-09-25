package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectAllDuePaymentsRepository extends CrudRepository<CollectAllDuePayments,Object> {
    @Query("SELECT cadp FROM CollectAllDuePayments cadp WHERE cadp.collector.collector_id = :collectorId")
    Iterable<CollectAllDuePayments> findCollectAllDuePaymentsByCollectorId(@Param("collectorId") Long collectorId);
}
