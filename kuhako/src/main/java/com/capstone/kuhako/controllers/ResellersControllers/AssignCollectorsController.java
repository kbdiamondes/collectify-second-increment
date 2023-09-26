package com.capstone.kuhako.controllers.ResellersControllers;

import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import com.capstone.kuhako.services.ResellerServices.AssignCollectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/resellerPage")
public class AssignCollectorsController {
    @Autowired
    AssignCollectorsService assignCollectorsService;

    @RequestMapping(value="/assignCollectors/{resellerId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createAssignCollectors(@PathVariable Long resellerId ,@RequestBody AssignCollectors assignCollectors) {
        assignCollectorsService.createAssignCollectors(resellerId,assignCollectors);
        return new ResponseEntity<>("AssignCollectors created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/assignCollectors", method = RequestMethod.GET)
    public ResponseEntity<Object> getAssignCollectors() {
        return new ResponseEntity<>(assignCollectorsService.getAssignCollectors(), HttpStatus.OK);
    }

    @RequestMapping(value="/assignCollectors/reseller/{resellerId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAssignCollectorsByResellerId(@PathVariable Long resellerId) {
        return new ResponseEntity<>(assignCollectorsService.getAssignCollectorsByResellerId(resellerId), HttpStatus.OK);
    }

    @RequestMapping(value = "/assignCollectors/{resellerId}/{assignCollectors_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAssignCollectors(@PathVariable Long resellerId,@PathVariable Long assignCollectors_id) {
        return assignCollectorsService.deleteAssignCollectors(resellerId,assignCollectors_id);
    }
    @RequestMapping(value="/assignCollectors/{resellerId}/{assignCollectors_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAssignCollectors(@PathVariable Long resellerId,@PathVariable Long assignCollectors_id, @RequestBody AssignCollectors assignCollectors) {
        return assignCollectorsService.updateAssignCollectors(resellerId,assignCollectors_id, assignCollectors);
    }
}
