package com.capstone.kuhako.controllers.CollectorModuleController;



import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import com.capstone.kuhako.services.CollectorModuleServices.SendFollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SendFollowUpController {
    @Autowired
    SendFollowUpService sendFollowUpService;

    @RequestMapping(value="/sendFollowUp", method = RequestMethod.POST)
    public ResponseEntity<Object> createSendFollowUp(@RequestBody SendFollowUp sendFollowUp) {
        sendFollowUpService.createSendFollowUp(sendFollowUp);
        return new ResponseEntity<>("Send Follow Up created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/sendFollowUp", method = RequestMethod.GET)
    public ResponseEntity<Object> getSendFollowUp() {
        return new ResponseEntity<>(sendFollowUpService.getSendFollowUp(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sendFollowUp/{sendFollowUp_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleSendFollowUp(@PathVariable Long sendFollowUp_id) {
        return sendFollowUpService.deleteSendFollowUp(sendFollowUp_id);
    }

    @RequestMapping(value="/sendFollowUp/{sendFollowUp_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSendFollowUp(@PathVariable Long sendFollowUp_id, @RequestBody SendFollowUp sendFollowUp) {
        return sendFollowUpService.updateSendFollowUp(sendFollowUp_id, sendFollowUp);
    }
}
