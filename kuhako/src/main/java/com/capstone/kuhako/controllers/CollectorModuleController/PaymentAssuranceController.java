package com.capstone.kuhako.controllers.CollectorModuleController;


import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;
import com.capstone.kuhako.services.CollectorModuleServices.PaymentAssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/collectorPage")
public class PaymentAssuranceController {
    @Autowired
    PaymentAssuranceService paymentAssuranceService;

    @RequestMapping(value="/paymentAssurance", method = RequestMethod.POST)
    public ResponseEntity<Object> createPaymentAssurance(@RequestBody PaymentAssurance paymentAssurance) {
        paymentAssuranceService.createPaymentAssurance(paymentAssurance);
        return new ResponseEntity<>("PaymentAssurance created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/paymentAssurance", method = RequestMethod.GET)
    public ResponseEntity<Object> getPaymentAssurance() {
        return new ResponseEntity<>(paymentAssuranceService.getPaymentAssurance(), HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentAssurance/{paymentAssuranceid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePaymentAssurance(@PathVariable Long paymentAssuranceid) {
        return paymentAssuranceService.deletePaymentAssurance(paymentAssuranceid);
    }

    @RequestMapping(value="/paymentAssurance/{paymentAssuranceid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePaymentAssurance(@PathVariable Long paymentAssuranceid, @RequestBody PaymentAssurance paymentAssurance) {
        return paymentAssuranceService.updatePaymentAssurance(paymentAssuranceid, paymentAssurance);
    }
}