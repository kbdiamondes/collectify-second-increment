package com.capstone.kuhako.controllers.ClientModuleController;

import com.capstone.kuhako.models.ClientModules.PaymentDues;
import com.capstone.kuhako.services.ClientModuleServices.PaymentDuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/client")
public class PaymentDuesController {
    @Autowired
    PaymentDuesService paymentDuesService;

    @RequestMapping(value="/paymentDues", method = RequestMethod.POST)
    public ResponseEntity<Object> createPaymentDues(@RequestBody PaymentDues paymentDues) {
        paymentDuesService.createPaymentDues(paymentDues);
        return new ResponseEntity<>("PaymentDues created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/paymentDues", method = RequestMethod.GET)
    public ResponseEntity<Object> getPaymentDues() {
        return new ResponseEntity<>(paymentDuesService.getPaymentDues(), HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentDues/{paymentDuesid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePaymentDues(@PathVariable Long paymentDuesid) {
        return paymentDuesService.deletePaymentDues(paymentDuesid);
    }

    @RequestMapping(value="/paymentDues/{paymentDuesid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePaymentDues(@PathVariable Long paymentDuesid, @RequestBody PaymentDues paymentDues) {
        return paymentDuesService.updatePaymentDues(paymentDuesid, paymentDues);
    }
}