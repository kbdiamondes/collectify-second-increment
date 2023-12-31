package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import com.capstone.kuhako.models.CollectorModules.collectorCollectionRecords;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface collectorCollectionRecordsRepository extends CrudRepository<collectorCollectionRecords,Object> {
    @Query("SELECT ccr FROM collectorCollectionRecords ccr WHERE ccr.collector.collector_id = :collectorId")
    Iterable<collectorCollectionRecords> findCollectorCollectionRecordsByCollectorId(@Param("collectorId") Long collectorId);
}
