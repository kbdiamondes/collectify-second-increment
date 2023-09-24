package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.TransactionDetails;
import com.capstone.kuhako.services.ClientModuleServices.TransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/clientPage")
public class TransactionDetailsController {
    @Autowired
    TransactionDetailsService transactionDetailsService;

    @RequestMapping(value="/transactionDetails", method = RequestMethod.POST)
    public ResponseEntity<Object> createTransactionDetails(@RequestBody TransactionDetails transactionDetails) {
        transactionDetailsService.createTransactionDetails(transactionDetails);
        return new ResponseEntity<>("TransactionDetails created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/transactionDetails", method = RequestMethod.GET)
    public ResponseEntity<Object> getTransactionDetails() {
        return new ResponseEntity<>(transactionDetailsService.getTransactionDetails(), HttpStatus.OK);
    }

    @RequestMapping(value = "/transactionDetails/{transactionDetailsid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTransactionDetails(@PathVariable Long transactionDetailsid) {
        return transactionDetailsService.deleteTransactionDetails(transactionDetailsid);
    }

    @RequestMapping(value="/transactionDetails/{transactionDetailsid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTransactionDetails(@PathVariable Long transactionDetailsid, @RequestBody TransactionDetails transactionDetails) {
        return transactionDetailsService.updateTransactionDetails(transactionDetailsid, transactionDetails);
    }
}