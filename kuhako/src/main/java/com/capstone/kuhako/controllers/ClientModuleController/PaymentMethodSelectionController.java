package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.PaymentMethodSelection;
import com.capstone.kuhako.services.ClientModuleServices.PaymentMethodSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/clientPage")
public class PaymentMethodSelectionController {
    @Autowired
    PaymentMethodSelectionService paymentMethodSelectionService;

    @RequestMapping(value="/paymentMethodSelection/{clientId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createPaymentMethodSelection(@PathVariable Long clientId,@RequestBody PaymentMethodSelection paymentMethodSelection) {
        paymentMethodSelectionService.createPaymentMethodSelection(clientId,paymentMethodSelection);
        return new ResponseEntity<>("PaymentMethodSelection created successfully", HttpStatus.CREATED);
    }
    @RequestMapping(value="/paymentMethodSelection", method = RequestMethod.GET)
    public ResponseEntity<Object> getPaymentMethodSelection() {
        return new ResponseEntity<>(paymentMethodSelectionService.getPaymentMethodSelection(), HttpStatus.OK);
    }
    @RequestMapping(value="/paymentMethodSelection/client/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getPaymentMethodSelectionByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(paymentMethodSelectionService.getPaymentMethodSelectionByClientId(clientId), HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentMethodSelection/{clientId}/{paymentMethodSelectionid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePaymentMethodSelection(@PathVariable Long clientId,@PathVariable Long paymentMethodSelectionid) {
        return paymentMethodSelectionService.deletePaymentMethodSelection(clientId,paymentMethodSelectionid);
    }

    @RequestMapping(value="/paymentMethodSelection/{clientId}/{paymentMethodSelectionid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePaymentMethodSelection(@PathVariable Long clientId, @PathVariable Long paymentMethodSelection_id, @RequestBody PaymentMethodSelection paymentMethodSelection) {
        return paymentMethodSelectionService.updatePaymentMethodSelection(clientId,paymentMethodSelection_id, paymentMethodSelection);
    }
}