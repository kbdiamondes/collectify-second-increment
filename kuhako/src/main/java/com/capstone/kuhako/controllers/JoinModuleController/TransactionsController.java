package com.capstone.kuhako.controllers.JoinModuleController;

import com.capstone.kuhako.models.JoinModule.Transactions;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.ResellerRepository;
import com.capstone.kuhako.services.JoinModuleServices.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/collectorPage")
public class TransactionsController {
    @Autowired
    TransactionsService transactionsService;
    @Autowired
    private ResellerRepository resellerRepository;

    @RequestMapping(value="/transactions/{resellerId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createTransactions(@PathVariable Long resellerId,@RequestBody Transactions transactions) {
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if (reseller != null) {
            transactionsService.createTransactions(resellerId, transactions);
            return new ResponseEntity<>("Transactions created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Reseller does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/transactions", method = RequestMethod.GET)
    public ResponseEntity<Object> getTransactions() {
        return new ResponseEntity<>(transactionsService.getTransactions(), HttpStatus.OK);
    }

//    @RequestMapping(value="/transactions/reseller/{resellerId}", method = RequestMethod.GET)
//    public ResponseEntity<Object> getTransactionsByResellerId(@PathVariable Long resellerId) {
//        return new ResponseEntity<>(transactionsService.getTransactionsByResellerId(resellerId), HttpStatus.OK);
//    }

    @RequestMapping(value = "/transactions/{resellerId}/{transactions_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTransactions(@PathVariable Long resellerId, @PathVariable Long transactions_id) {
        return transactionsService.deleteTransactions(resellerId,transactions_id);
    }

    @RequestMapping(value="/transactions/{resellerId}/{transactions_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTransactions(@PathVariable Long resellerId,@PathVariable Long transactions_id, @RequestBody Transactions transactions) {
        return transactionsService.updateTransactions(resellerId,transactions_id, transactions);
    }
}
