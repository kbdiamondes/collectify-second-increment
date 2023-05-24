package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import com.capstone.kuhako.repositories.ResellerRepositories.MyCollectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyCollectorsServiceImpl {
    @Autowired
    private MyCollectorsRepository myCollectorsRepository;

    public void createMyCollectors(MyCollectors myCollectors){
        MyCollectors newMyCollectors = new MyCollectors();
        newMyCollectors.setCollectionStatus(myCollectors.getCollectionStatus());
        newMyCollectors.setAvailabilityStatus(myCollectors.getAvailabilityStatus());
        newMyCollectors.setRequiredCollectibles(myCollectors.getRequiredCollectibles());
        myCollectorsRepository.save(newMyCollectors);
    }
    public Iterable<MyCollectors> getMyCollectors(){
        return myCollectorsRepository.findAll();
    }
    public ResponseEntity deleteMyCollectors(Long id){
        myCollectorsRepository.deleteById(id);
        return new ResponseEntity<>("MyCollectors Deleted successfully", HttpStatus.OK);


    }
    public ResponseEntity updateMyCollectors(Long id, MyCollectors myCollectors){
        MyCollectors myCollectorsForUpdate = myCollectorsRepository.findById(id).get();
        myCollectorsForUpdate.setCollectionStatus(myCollectors.getCollectionStatus());
        myCollectorsForUpdate.setAvailabilityStatus(myCollectors.getAvailabilityStatus());
        myCollectorsForUpdate.setRequiredCollectibles(myCollectors.getRequiredCollectibles());
        myCollectorsRepository.save(myCollectorsForUpdate);
        return new ResponseEntity("MyCollectors updated successfully", HttpStatus.OK);

    }
}
