package com.capstone.kuhako.controllers.CollectorModuleController;


import com.capstone.kuhako.models.CollectorModules.PaymentAssuranceMessage;
import com.capstone.kuhako.services.CollectorModuleServices.PaymentAssuranceMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/collector")
public class PaymentAssuranceMessageController {
    @Autowired
    PaymentAssuranceMessageService paymentAssuranceMessageService;

    @RequestMapping(value="/paymentAssuranceMessage", method = RequestMethod.POST)
    public ResponseEntity<Object> createPaymentAssuranceMessage(@RequestBody PaymentAssuranceMessage paymentAssuranceMessage) {
        paymentAssuranceMessageService.createPaymentAssuranceMessage(paymentAssuranceMessage);
        return new ResponseEntity<>("PaymentAssuranceMessage created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/paymentAssuranceMessage", method = RequestMethod.GET)
    public ResponseEntity<Object> getPaymentAssuranceMessage() {
        return new ResponseEntity<>(paymentAssuranceMessageService.getPaymentAssuranceMessage(), HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentAssuranceMessage/{paymentAssuranceMessageid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePaymentAssuranceMessage(@PathVariable Long paymentAssuranceMessageid) {
        return paymentAssuranceMessageService.deletePaymentAssuranceMessage(paymentAssuranceMessageid);
    }

    @RequestMapping(value="/paymentAssuranceMessage/{paymentAssuranceMessageid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePaymentAssuranceMessage(@PathVariable Long paymentAssuranceMessageid, @RequestBody PaymentAssuranceMessage paymentAssuranceMessage) {
        return paymentAssuranceMessageService.updatePaymentAssuranceMessage(paymentAssuranceMessageid, paymentAssuranceMessage);
    }
}