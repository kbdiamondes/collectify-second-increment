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

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createCollectorCollectionRecords(collectorCollectionRecords collectorCollectionRecords){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

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

//        collectorCollectionRecords collectorCollectionRecordsForDeleting = collectorCollectionRecordsRepository.findById(id).get();
//        String collectorCollectionRecordsName = collectorCollectionRecordsForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(collectorCollectionRecordsName)){
//            collectorCollectionRecordsRepository.deleteById(id);
//            return new ResponseEntity<>("collectorCollectionRecords Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this collectorCollectionRecords",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateCollectorCollectionRecords(Long id, collectorCollectionRecords collectorCollectionRecords){
        collectorCollectionRecords collectorCollectionRecordsForUpdate = collectorCollectionRecordsRepository.findById(id).get();

        collectorCollectionRecordsForUpdate.setCollector(collectorCollectionRecords.getCollector());
        collectorCollectionRecordsForUpdate.setPayDues(collectorCollectionRecords.getPayDues());
        collectorCollectionRecordsForUpdate.setCollectPayments(collectorCollectionRecords.getCollectPayments());

        collectorCollectionRecordsRepository.save(collectorCollectionRecordsForUpdate);

        return new ResponseEntity("collectorCollectionRecords updated successfully", HttpStatus.OK);

//        collectorCollectionRecords collectorCollectionRecordsForUpdating = collectorCollectionRecordsRepository.findById(id).get();
//        String collectorCollectionRecordsName = collectorCollectionRecordsForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(collectorCollectionRecordsName)){
//            collectorCollectionRecordsForUpdating.setName(collectorCollectionRecords.getName());
//            collectorCollectionRecordsForUpdating.setDescription(collectorCollectionRecords.getDescription());
//            collectorCollectionRecordsForUpdating.setPrice(collectorCollectionRecords.getPrice());
//
//            collectorCollectionRecordsRepository.save(collectorCollectionRecordsForUpdating);
//            return  new ResponseEntity("collectorCollectionRecords has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("You are not authorize to update this collectorCollectionRecords.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
