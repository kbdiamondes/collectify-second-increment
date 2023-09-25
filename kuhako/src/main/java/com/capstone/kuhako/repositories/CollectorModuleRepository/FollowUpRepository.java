package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.FollowUp;
import com.capstone.kuhako.models.CollectorModules.collectorCollectionRecords;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowUpRepository extends CrudRepository<FollowUp,Object> {

    @Query("SELECT fu FROM FollowUp fu WHERE fu.collector.collector_id = :collectorId")
    Iterable<FollowUp> findFollowUpByCollectorId(@Param("collectorId") Long collectorId);


}
