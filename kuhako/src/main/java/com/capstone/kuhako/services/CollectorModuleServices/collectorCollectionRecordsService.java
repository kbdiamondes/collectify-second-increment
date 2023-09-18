package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.collectorCollectionRecords;
import org.springframework.http.ResponseEntity;

public interface collectorCollectionRecordsService {
    void createCollectorCollectionRecords(collectorCollectionRecords paymentDues);

    Iterable<collectorCollectionRecords> getCollectorCollectionRecords();

    ResponseEntity deleteCollectorCollectionRecords(Long id);

    ResponseEntity updateCollectorCollectionRecords(Long id, collectorCollectionRecords paymentDues);
}
