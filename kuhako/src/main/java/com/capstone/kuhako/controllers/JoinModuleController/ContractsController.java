package com.capstone.kuhako.controllers.JoinModuleController;

import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.repositories.ResellerRepository;
import com.capstone.kuhako.services.JoinModuleServices.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/resellerPage")
public class ContractsController {
    @Autowired
    ContractsService contractsService;
    @Autowired
    private ResellerRepository resellerRepository;

    @RequestMapping(value="/contracts/{resellerId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createContracts(@PathVariable Long resellerId, @RequestBody Contracts contracts) {
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if (reseller != null) {
            contractsService.createContract(resellerId,contracts);
            return new ResponseEntity<>("Contracts created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Contracts Records does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/contracts", method = RequestMethod.GET)
    public ResponseEntity<Object> getContracts() {
        return new ResponseEntity<>(contractsService.getContracts(), HttpStatus.OK);
    }

    @RequestMapping(value="/contracts/reseller/{resellerId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContractsByResellerId(@PathVariable Long resellerId) {
        return new ResponseEntity<>(contractsService.getContractsByResellerId(resellerId), HttpStatus.OK);
    }

    @RequestMapping(value="/contracts/collector/{collectorId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContractsByCollectorId(@PathVariable Long collectorId) {
        return new ResponseEntity<>(contractsService.getContractsByCollectorId(collectorId), HttpStatus.OK);
    }

    @RequestMapping(value="/contracts/client/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContractsByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(contractsService.getContractsByClientId(clientId), HttpStatus.OK);
    }

    @RequestMapping(value = "/contracts/{resellerId}/{contracts_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteContracts(@PathVariable Long resellerId,@PathVariable Long contracts_id) {
        return contractsService.deleteContract(resellerId,contracts_id);
    }
    @RequestMapping(value="/contracts/{resellerId}/{contracts_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateContracts(@PathVariable Long resellerId,@PathVariable Long contracts_id, @RequestBody Contracts contracts) {
        return contractsService.updateContract(resellerId,contracts_id, contracts);
    }
}
