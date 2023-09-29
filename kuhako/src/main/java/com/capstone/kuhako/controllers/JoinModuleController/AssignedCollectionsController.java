package com.capstone.kuhako.controllers.JoinModuleController;

import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.JoinModule.AssignedCollections;
import com.capstone.kuhako.repositories.ResellerRepository;
import com.capstone.kuhako.services.JoinModuleServices.AssignedCollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/resellerPage")
public class AssignedCollectionsController {
    @Autowired
    AssignedCollectionsService assignedCollectionsService;

    @Autowired
    private ResellerRepository resellerRepository;

    @RequestMapping(value="/assignedCollections/{resellerId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createAssignedCollections(@PathVariable Long resellerId,@RequestBody AssignedCollections assignedCollections) {
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if (reseller != null) {
            assignedCollectionsService.createAssignedCollections(resellerId,assignedCollections);
            return new ResponseEntity<>("AssignedCollections created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("AssignedCollections does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/assignedCollections", method = RequestMethod.GET)
    public ResponseEntity<Object> getAssignedCollections() {
        return new ResponseEntity<>(assignedCollectionsService.getAssignedCollections(), HttpStatus.OK);
    }

//    @RequestMapping(value="/assignedCollections/reseller/{resellerId}", method = RequestMethod.GET)
//    public ResponseEntity<Object> getAssignedCollectionsByResellerId(@PathVariable Long resellerId) {
//        return new ResponseEntity<>(assignedCollectionsService.getAssignedCollectionsByResellerId(resellerId), HttpStatus.OK);
//    }

    @RequestMapping(value = "/assignedCollections/{resellerId}/{assignedCollections_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAssignedCollections(@PathVariable Long resellerId, @PathVariable Long assignedCollections_id) {
        return assignedCollectionsService.deleteAssignedCollections(resellerId,assignedCollections_id);
    }

    @RequestMapping(value="/assignedCollections/{resellerId}/{assignedCollections_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAssignedCollections(@PathVariable Long resellerId,@PathVariable Long assignedCollections_id, @RequestBody AssignedCollections assignedCollections) {
        return assignedCollectionsService.updateAssignedCollections(resellerId,assignedCollections_id, assignedCollections);
    }
}
