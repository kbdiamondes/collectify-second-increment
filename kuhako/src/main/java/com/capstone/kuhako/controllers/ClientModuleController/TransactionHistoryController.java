package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.TransactionHistory;
import com.capstone.kuhako.services.ClientModuleServices.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/client")
public class TransactionHistoryController {
    @Autowired
    TransactionHistoryService transactionHistoryService;

    @RequestMapping(value="/transactionHistory", method = RequestMethod.POST)
    public ResponseEntity<Object> createTransactionHistory(@RequestBody TransactionHistory transactionHistory) {
        transactionHistoryService.createTransactionHistory(transactionHistory);
        return new ResponseEntity<>("TransactionHistory created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/transactionHistory", method = RequestMethod.GET)
    public ResponseEntity<Object> getTransactionHistory() {
        return new ResponseEntity<>(transactionHistoryService.getTransactionHistory(), HttpStatus.OK);
    }

    @RequestMapping(value = "/transactionHistory/{transactionHistoryid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTransactionHistory(@PathVariable Long transactionHistoryid) {
        return transactionHistoryService.deleteTransactionHistory(transactionHistoryid);
    }

    @RequestMapping(value="/transactionHistory/{transactionHistoryid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTransactionHistory(@PathVariable Long transactionHistoryid, @RequestBody TransactionHistory transactionHistory) {
        return transactionHistoryService.updateTransactionHistory(transactionHistoryid, transactionHistory);
    }
}