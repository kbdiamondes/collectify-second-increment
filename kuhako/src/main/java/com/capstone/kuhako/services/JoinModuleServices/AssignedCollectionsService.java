package com.capstone.kuhako.services.JoinModuleServices;

import com.capstone.kuhako.models.JoinModule.AssignedCollections;
import org.springframework.http.ResponseEntity;

public interface AssignedCollectionsService {
    void createAssignedCollections(Long resellerId,AssignedCollections assignedCollections);

    Iterable<AssignedCollections> getAssignedCollections();

//    Iterable<AssignedCollections>getAssignedCollectionsByResellerId(Long resellerId);

    ResponseEntity deleteAssignedCollections(Long resellerId,Long id);

    ResponseEntity updateAssignedCollections(Long resellerId,Long id, AssignedCollections assignedCollections);
}
