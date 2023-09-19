package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.ClientPaymentRecords;
import com.capstone.kuhako.services.ClientModuleServices.ClientPaymentRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ClientPaymentRecordsController {
    @Autowired
    ClientPaymentRecordsService clientPaymentRecordsService;

    @RequestMapping(value="/clientPaymentRecords", method = RequestMethod.POST)
    public ResponseEntity<Object> createClientPaymentRecords(@RequestBody ClientPaymentRecords clientPaymentRecords) {
        clientPaymentRecordsService.createClientPaymentRecords(clientPaymentRecords);
        return new ResponseEntity<>("ClientPaymentRecords created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/clientPaymentRecords", method = RequestMethod.GET)
    public ResponseEntity<Object> getClientPaymentRecords() {
        return new ResponseEntity<>(clientPaymentRecordsService.getClientPaymentRecords(), HttpStatus.OK);
    }

    @RequestMapping(value = "/clientPaymentRecords/{clientPaymentRecordsid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClientPaymentRecords(@PathVariable Long clientPaymentRecordsid) {
        return clientPaymentRecordsService.deleteClientPaymentRecords(clientPaymentRecordsid);
    }

    @RequestMapping(value="/clientPaymentRecords/{clientPaymentRecordsid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateClientPaymentRecords(@PathVariable Long clientPaymentRecordsid, @RequestBody ClientPaymentRecords clientPaymentRecords) {
        return clientPaymentRecordsService.updateClientPaymentRecords(clientPaymentRecordsid, clientPaymentRecords);
    }
}