package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import com.capstone.kuhako.repositories.ResellerRepositories.AssignCollectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AssignCollectorsServiceImpl implements AssignCollectorsService{
    @Autowired
    private AssignCollectorsRepository assignCollectorsRepository;


    // create Assign Collectors
    public void createAssignCollectors(AssignCollectors assignCollectors){
        assignCollectorsRepository.save(assignCollectors);
    }
    // get all Assign Collectors
    public Iterable<AssignCollectors> getAssignCollectors(){
        return assignCollectorsRepository.findAll();
    }

    // delete Assign Collectors
    public ResponseEntity deleteAssignCollectors(int id){
        assignCollectorsRepository.deleteById(id);
        return new ResponseEntity<>("AssignCollectors Deleted successfully", HttpStatus.OK);
    }
    // update Assign Collectorss
    public ResponseEntity updateAssignCollectors(int id, AssignCollectors assignCollectors){
        AssignCollectors assignCollectorsForUpdate = assignCollectorsRepository.findById(id).get();

        assignCollectorsForUpdate.setCollector(assignCollectors.getCollector());

        assignCollectorsRepository.save(assignCollectorsForUpdate);

        return new ResponseEntity("AssignCollectors updated successfully", HttpStatus.OK);

    }
}