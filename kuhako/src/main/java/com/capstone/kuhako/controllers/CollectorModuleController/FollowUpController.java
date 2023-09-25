package com.capstone.kuhako.controllers.CollectorModuleController;


import com.capstone.kuhako.models.CollectorModules.FollowUp;
import com.capstone.kuhako.services.CollectorModuleServices.FollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/collectorPage")
public class FollowUpController {
    @Autowired
    FollowUpService followUpService;

    @RequestMapping(value="/followUp", method = RequestMethod.POST)
    public ResponseEntity<Object> createFollowUp(@RequestBody FollowUp followUp) {
        followUpService.createFollowUp(followUp);
        return new ResponseEntity<>("FollowUp created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/followUp", method = RequestMethod.GET)
    public ResponseEntity<Object> getFollowUp() {
        return new ResponseEntity<>(followUpService.getFollowUp(), HttpStatus.OK);
    }

    @RequestMapping(value = "/followUp/{followUpid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteFollowUp(@PathVariable Long followUpid) {
        return followUpService.deleteFollowUp(followUpid);
    }

    @RequestMapping(value="/followUp/{followUpid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateFollowUp(@PathVariable Long followUpid, @RequestBody FollowUp followUp) {
        return followUpService.updateFollowUp(followUpid, followUp);
    }
}