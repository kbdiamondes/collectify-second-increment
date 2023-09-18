package com.capstone.kuhako.controllers.CollectorModuleController;


import com.capstone.kuhako.models.CollectorModules.CollectPayments;
import com.capstone.kuhako.services.CollectorModuleServices.CollectPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CollectPaymentsController {
    @Autowired
    CollectPaymentsService collectPaymentsService;

    @RequestMapping(value="/collectPayments", method = RequestMethod.POST)
    public ResponseEntity<Object> createCollectPayments(@RequestBody CollectPayments collectPayments) {
        collectPaymentsService.createCollectPayments(collectPayments);
        return new ResponseEntity<>("CollectPayments created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/collectPayments", method = RequestMethod.GET)
    public ResponseEntity<Object> getCollectPayments() {
        return new ResponseEntity<>(collectPaymentsService.getCollectPayments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/collectPayments/{collectPaymentsid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCollectPayments(@PathVariable Long collectPaymentsid) {
        return collectPaymentsService.deleteCollectPayments(collectPaymentsid);
    }

    @RequestMapping(value="/collectPayments/{collectPaymentsid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCollectPayments(@PathVariable Long collectPaymentsid, @RequestBody CollectPayments collectPayments) {
        return collectPaymentsService.updateCollectPayments(collectPaymentsid, collectPayments);
    }
}