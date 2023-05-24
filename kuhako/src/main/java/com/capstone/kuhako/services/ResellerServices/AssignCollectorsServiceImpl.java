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


    public void createAssignCollectors(AssignCollectors assignCollectors){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        AssignCollectors newAssignCollectors = new AssignCollectors();
        newAssignCollectors.setCollector(assignCollectors.getCollector());
        assignCollectorsRepository.save(newAssignCollectors);
    }
    public Iterable<AssignCollectors> getAssignCollectors(){
        return assignCollectorsRepository.findAll();
    }

    public ResponseEntity deleteAssignCollectors(Long id){
        assignCollectorsRepository.deleteById(id);
        return new ResponseEntity<>("AssignCollectors Deleted successfully", HttpStatus.OK);


    }

    public ResponseEntity updateAssignCollectors(Long id, AssignCollectors assignCollectors){
        AssignCollectors assignCollectorsForUpdate = assignCollectorsRepository.findById(id).get();

        assignCollectorsForUpdate.setCollector(assignCollectors.getCollector());

        assignCollectorsRepository.save(assignCollectorsForUpdate);

        return new ResponseEntity("AssignCollectors updated successfully", HttpStatus.OK);

    }
}