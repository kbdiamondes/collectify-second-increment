package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;
import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SendFollowUpRepository extends CrudRepository<SendFollowUp,Object> {

    @Query("SELECT sfu FROM SendFollowUp sfu WHERE sfu.collector.collector_id = :collectorId")
    Iterable<SendFollowUp> findSendFollowUpByCollectorId(@Param("collectorId") Long collectorId);

}
