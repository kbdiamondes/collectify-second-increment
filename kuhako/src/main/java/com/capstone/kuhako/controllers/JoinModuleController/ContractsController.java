package com.capstone.kuhako.controllers.JoinModuleController;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.JoinModule.Transactions;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.repositories.ClientRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import com.capstone.kuhako.services.JoinModuleServices.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/contracts")
public class ContractsController {
    @Autowired
    ContractsService contractsService;
    @Autowired
    private ResellerRepository resellerRepository;
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value="/createContracts/{resellerId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createContracts(@PathVariable Long resellerId, @RequestBody Contracts contracts) {
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        Client client = clientRepository.findById(contracts.getClient().getClient_id()).orElse(null);
        if (reseller != null) {
            if (client != null) {
                contractsService.createContract(resellerId, contracts);
                return new ResponseEntity<>("Contracts created successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Client does not exist", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Reseller does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getContracts() {
        return new ResponseEntity<>(contractsService.getContracts(), HttpStatus.OK);
    }

    @RequestMapping(value="reseller/{resellerId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContractsByResellerId(@PathVariable Long resellerId) {
        return new ResponseEntity<>(contractsService.getContractsByResellerId(resellerId), HttpStatus.OK);
    }

    @RequestMapping(value="collector/{collectorId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContractsByCollectorId(@PathVariable Long collectorId) {
        return new ResponseEntity<>(contractsService.getContractsByCollectorId(collectorId), HttpStatus.OK);
    }

    @RequestMapping(value="collector/history/{collectorId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContractsHistoryByCollectorId(@PathVariable Long collectorId) {
        return new ResponseEntity<>(contractsService.getContractsHistoryByCollectorId(collectorId), HttpStatus.OK);
    }

    @RequestMapping(value="lient/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContractsByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(contractsService.getContractsByClientId(clientId), HttpStatus.OK);
    }


    @RequestMapping(value="transactions/{collectorId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateContracts(@PathVariable Long collectorId, @RequestBody Transactions transactions) {
        return contractsService.updateContract(collectorId, transactions);
    }
}
