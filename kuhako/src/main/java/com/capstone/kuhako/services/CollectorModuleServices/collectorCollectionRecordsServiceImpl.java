package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.collectorCollectionRecords;
import com.capstone.kuhako.repositories.CollectorModuleRepository.collectorCollectionRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class collectorCollectionRecordsServiceImpl implements collectorCollectionRecordsService{
    @Autowired
    private collectorCollectionRecordsRepository collectorCollectionRecordsRepository;

    public void createCollectorCollectionRecords(collectorCollectionRecords collectorCollectionRecords){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        collectorCollectionRecords newCollectorCollectionRecords = new collectorCollectionRecords();
        newCollectorCollectionRecords.setCollector(collectorCollectionRecords.getCollector());
        newCollectorCollectionRecords.setPayDues(collectorCollectionRecords.getPayDues());
        newCollectorCollectionRecords.setCollectPayments(collectorCollectionRecords.getCollectPayments());
        collectorCollectionRecordsRepository.save(newCollectorCollectionRecords);
    }
    public Iterable<collectorCollectionRecords> getCollectorCollectionRecords(){
        return collectorCollectionRecordsRepository.findAll();
    }

    public ResponseEntity deleteCollectorCollectionRecords(Long id){
        collectorCollectionRecordsRepository.deleteById(id);
        return new ResponseEntity<>("collectorCollectionRecords Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateCollectorCollectionRecords(Long id, collectorCollectionRecords collectorCollectionRecords){
        collectorCollectionRecords collectorCollectionRecordsForUpdate = collectorCollectionRecordsRepository.findById(id).get();
        collectorCollectionRecordsForUpdate.setCollector(collectorCollectionRecords.getCollector());
        collectorCollectionRecordsForUpdate.setPayDues(collectorCollectionRecords.getPayDues());
        collectorCollectionRecordsForUpdate.setCollectPayments(collectorCollectionRecords.getCollectPayments());
        collectorCollectionRecordsRepository.save(collectorCollectionRecordsForUpdate);
        return new ResponseEntity("collectorCollectionRecords updated successfully", HttpStatus.OK);

    }
}
