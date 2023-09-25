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

    @RequestMapping(value="/assignCollectors", method = RequestMethod.POST)
    public ResponseEntity<Object> createAssignCollectors(@RequestBody AssignCollectors assignCollectors) {
        assignCollectorsService.createAssignCollectors(assignCollectors);
        return new ResponseEntity<>("AssignCollectors created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/assignCollectors", method = RequestMethod.GET)
    public ResponseEntity<Object> getAssignCollectors() {
        return new ResponseEntity<>(assignCollectorsService.getAssignCollectors(), HttpStatus.OK);
    }

    @RequestMapping(value = "/assignCollectors/{assignCollectorsid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAssignCollectors(@PathVariable int assignCollectorsid) {
        return assignCollectorsService.deleteAssignCollectors(assignCollectorsid);
    }

    @RequestMapping(value="/assignCollectors/{assignCollectorsid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAssignCollectors(@PathVariable int assignCollectorsid, @RequestBody AssignCollectors assignCollectors) {
        return assignCollectorsService.updateAssignCollectors(assignCollectorsid, assignCollectors);
    }
}
