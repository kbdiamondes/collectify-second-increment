package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.PaymentMethodSelection;
import com.capstone.kuhako.services.ClientModuleServices.PaymentMethodSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/client")
public class PaymentMethodSelectionController {
    @Autowired
    PaymentMethodSelectionService paymentMethodSelectionService;

    @RequestMapping(value="/paymentMethodSelection", method = RequestMethod.POST)
    public ResponseEntity<Object> createPaymentMethodSelection(@RequestBody PaymentMethodSelection paymentMethodSelection) {
        paymentMethodSelectionService.createPaymentMethodSelection(paymentMethodSelection);
        return new ResponseEntity<>("PaymentMethodSelection created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/paymentMethodSelection", method = RequestMethod.GET)
    public ResponseEntity<Object> getPaymentMethodSelection() {
        return new ResponseEntity<>(paymentMethodSelectionService.getPaymentMethodSelection(), HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentMethodSelection/{paymentMethodSelectionid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePaymentMethodSelection(@PathVariable Long paymentMethodSelectionid) {
        return paymentMethodSelectionService.deletePaymentMethodSelection(paymentMethodSelectionid);
    }

    @RequestMapping(value="/paymentMethodSelection/{paymentMethodSelectionid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePaymentMethodSelection(@PathVariable Long paymentMethodSelectionid, @RequestBody PaymentMethodSelection paymentMethodSelection) {
        return paymentMethodSelectionService.updatePaymentMethodSelection(paymentMethodSelectionid, paymentMethodSelection);
    }
}