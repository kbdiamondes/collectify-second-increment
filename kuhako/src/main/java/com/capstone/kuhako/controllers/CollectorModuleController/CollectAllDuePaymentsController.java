package com.capstone.kuhako.controllers.CollectorModuleController;


import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import com.capstone.kuhako.services.CollectorModuleServices.CollectAllDuePaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CollectAllDuePaymentsController {
    @Autowired
    CollectAllDuePaymentsService collectAllDuePaymentsService;

    @RequestMapping(value="/collectAllDuePayments", method = RequestMethod.POST)
    public ResponseEntity<Object> createCollectAllDuePayments(@RequestBody CollectAllDuePayments collectAllDuePayments) {
        collectAllDuePaymentsService.createCollectAllDuePayments(collectAllDuePayments);
        return new ResponseEntity<>("CollectAllDuePayments created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/collectAllDuePayments", method = RequestMethod.GET)
    public ResponseEntity<Object> getCollectAllDuePayments() {
        return new ResponseEntity<>(collectAllDuePaymentsService.getCollectAllDuePayments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/collectAllDuePayments/{collectAllDuePaymentsid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCollectAllDuePayments(@PathVariable Long collectAllDuePaymentsid) {
        return collectAllDuePaymentsService.deleteCollectAllDuePayments(collectAllDuePaymentsid);
    }

    @RequestMapping(value="/collectAllDuePayments/{collectAllDuePaymentsid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCollectAllDuePayments(@PathVariable Long collectAllDuePaymentsid, @RequestBody CollectAllDuePayments collectAllDuePayments) {
        return collectAllDuePaymentsService.updateCollectAllDuePayments(collectAllDuePaymentsid, collectAllDuePayments);
    }
}