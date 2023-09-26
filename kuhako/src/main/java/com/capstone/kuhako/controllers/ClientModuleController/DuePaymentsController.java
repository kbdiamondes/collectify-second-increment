package com.capstone.kuhako.controllers.ClientModuleController;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.services.ClientModuleServices.DuePaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clientPage")
public class DuePaymentsController {

    @Autowired
    DuePaymentsService duePaymentsService;

    // Create a new DuePayments for a specific client
    @RequestMapping(value="/duePayments/{clientId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createDuePayments(@PathVariable Long clientId, @RequestBody DuePayments duePayments) {
        duePaymentsService.createDuePayments(clientId, duePayments);
        return new ResponseEntity<>("PaymentDues created successfully", HttpStatus.CREATED);
    }

    // Get all DuePayments
    @RequestMapping(value="/duePayments", method = RequestMethod.GET)
    public ResponseEntity<Object> getDuePayments() {
        return new ResponseEntity<>(duePaymentsService.getDuePayments(), HttpStatus.OK);
    }

    // Get DuePayments for a specific client
    @RequestMapping(value="/duePayments/client/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDuePaymentsByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(duePaymentsService.getDuePaymentsByClientId(clientId), HttpStatus.OK);
    }

    // Delete a DuePayments entry for a specific client
    @RequestMapping(value="/duePayments/{clientId}/{duePayments_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDuePayments(@PathVariable Long clientId, @PathVariable Long duePayments_id) {
        return duePaymentsService.deleteDuePayments(clientId, duePayments_id);
    }

    // Update a DuePayments entry for a specific client
    @RequestMapping(value="/duePayments/{clientId}/{duePayments_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDuePayments(@PathVariable Long clientId, @PathVariable Long duePayments_id, @RequestBody DuePayments duePayments) {
        return duePaymentsService.updateDuePayments(clientId, duePayments_id, duePayments);
    }
}