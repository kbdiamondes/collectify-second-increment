package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.ClientPaymentRecords;
import com.capstone.kuhako.services.ClientModuleServices.ClientPaymentRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/clientPage")
public class ClientPaymentRecordsController {
    @Autowired
    ClientPaymentRecordsService clientPaymentRecordsService;

    @RequestMapping(value="/clientPaymentRecords/{clientId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createClientPaymentRecords(@PathVariable Long clientId, @RequestBody ClientPaymentRecords clientPaymentRecords) {
        clientPaymentRecordsService.createClientPaymentRecords(clientId,clientPaymentRecords);
        return new ResponseEntity<>("ClientPaymentRecords created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/clientPaymentRecords/client/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getClientPaymentRecordsByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(clientPaymentRecordsService.getClientPaymentRecordsByClientId(clientId), HttpStatus.OK);
    }

    @RequestMapping(value = "/clientPaymentRecords/{clientId}/{clientPaymentRecords_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClientPaymentRecordsByClientId(@PathVariable Long clientId, @PathVariable Long clientPaymentRecords_id ) {
        return clientPaymentRecordsService.deleteClientPaymentRecordsByClientId(clientId,clientPaymentRecords_id);
    }

    /*@RequestMapping(value="/clientPaymentRecords/{clientPaymentRecordsid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateClientPaymentRecords(@PathVariable Long clientPaymentRecordsid, @RequestBody ClientPaymentRecords clientPaymentRecords) {
        return clientPaymentRecordsService.updateClientPaymentRecords(clientPaymentRecordsid, clientPaymentRecords);
    }*/
}