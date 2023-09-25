package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;
import com.capstone.kuhako.models.CollectorModules.PaymentAssuranceMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAssuranceRepository extends CrudRepository<PaymentAssurance,Object> {
    @Query("SELECT pa FROM PaymentAssurance pa WHERE pa.collector.collector_id = :collectorId")
    Iterable<PaymentAssurance> findPaymentAssuranceByCollectorId(@Param("collectorId") Long collectorId);
}
