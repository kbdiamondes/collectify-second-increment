package com.capstone.kuhako.services.JoinModuleServices;

import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.JoinModule.AssignedCollections;
import com.capstone.kuhako.repositories.JoinModuleRepository.AssignedCollectionsRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AssignedCollectionsServiceImpl implements AssignedCollectionsService {
    @Autowired
    private AssignedCollectionsRepository assignedCollectionsRepository;

    @Autowired
    private ResellerRepository resellerRepository;

    // Create AssignedCollections
    public void createAssignedCollections(Long resellerId, AssignedCollections assignedCollections){
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if(reseller != null){
            assignedCollections.setReseller(reseller);
            assignedCollectionsRepository.save(assignedCollections);
        }
    }
    // Get all Collector
    public Iterable<AssignedCollections> getAssignedCollections(){
        return assignedCollectionsRepository.findAll();
    }

//    public Iterable<AssignedCollections> getAssignedCollectionsByResellerId(Long resellerId){
//        return assignedCollectionsRepository.findAssignedCollectionsByCollectorId(resellerId);
//    }


    // delete Collectors

    public ResponseEntity deleteAssignedCollections(Long resellerId, Long id){
        AssignedCollections assignedCollectionsToDelete = assignedCollectionsRepository.findById(id).orElse(null);
        if (assignedCollectionsToDelete != null && assignedCollectionsToDelete.getReseller().getReseller_id().equals(resellerId)) {
            assignedCollectionsRepository.deleteById(id);
            return new ResponseEntity<>("AssignedCollections Deleted Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("AssignedCollections Not Found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity updateAssignedCollections(Long resellerId, Long id, AssignedCollections assignedCollections){
        AssignedCollections assignedCollectionsForUpdate = assignedCollectionsRepository.findById(id).orElse(null);
        if (assignedCollectionsForUpdate != null && assignedCollectionsForUpdate.getReseller().getReseller_id().equals(resellerId)){
//            assignedCollectionsForUpdate.setCollectionStatus(assignedCollections.getCollectionStatus());
//            assignedCollectionsForUpdate.setRequiredCollectibles(assignedCollections.getRequiredCollectibles());
            assignedCollectionsRepository.save(assignedCollectionsForUpdate);
            return new ResponseEntity("AssignedCollections updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity("AssignedCollections updated successfully", HttpStatus.NOT_FOUND);
    }
}
