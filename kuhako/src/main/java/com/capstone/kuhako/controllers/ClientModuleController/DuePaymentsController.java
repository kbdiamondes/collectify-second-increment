package com.capstone.kuhako.controllers.ClientModuleController;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.services.ClientModuleServices.DuePaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/client")
public class DuePaymentsController {
    @Autowired
    DuePaymentsService duePaymentsService;

    @RequestMapping(value="/duePayments", method = RequestMethod.POST)
    public ResponseEntity<Object> createDuePayments(@RequestBody DuePayments duePayments) {
        duePaymentsService.createDuePayments(duePayments);
        return new ResponseEntity<>("PaymentDues created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/duePayments", method = RequestMethod.GET)
    public ResponseEntity<Object> getDuePayments() {
        return new ResponseEntity<>(duePaymentsService.getDuePayments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/duePayments/{duePayments_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDuePayments(@PathVariable Long duePayments_id) {
        return duePaymentsService.deleteDuePayments(duePayments_id);
    }

    @RequestMapping(value="/duePayments/{duePayments_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDuePayments(@PathVariable Long duePayments_id, @RequestBody DuePayments duePayments) {
        return duePaymentsService.updateDuePayments(duePayments_id, duePayments);
    }
}