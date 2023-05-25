package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.collectorCollectionRecords;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface collectorCollectionRecordsRepository extends CrudRepository<collectorCollectionRecords,Object> {
}
