package com.capstone.kuhako.services.JoinModuleServices;

import com.capstone.kuhako.models.JoinModule.ContractsClient;
import com.capstone.kuhako.models.JoinModule.ContractsCollector;
import com.capstone.kuhako.models.JoinModule.ContractsReseller;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.repositories.JoinModuleRepository.ContractsRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContractsServiceImpl implements ContractsService {
    @Autowired
    private ContractsRepository contractsRepository;
    @Autowired
    private ResellerRepository resellerRepository;

    // create Contracts
    public void createContract(Long resellerId, Contracts contracts){
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if(reseller != null){
            contracts.setReseller(reseller);
            contractsRepository.save(contracts);
        }
    }
    // get all Contracts
    public Iterable<Contracts> getContracts(){
        return contractsRepository.findAll();
    }

    public Iterable<ContractsReseller> getContractsByResellerId(Long resellerId){
        return contractsRepository.findContractsByResellerId(resellerId);
    }

    public Iterable<ContractsCollector> getContractsByCollectorId(Long collectorId){
        return contractsRepository.findContractsByCollectorId(collectorId);
    }

    public Iterable<ContractsClient> getContractsByClientId(Long clientId){
        return contractsRepository.findContractsByClientId(clientId);
    }

    // delete Contracts
    public ResponseEntity deleteContract(Long resellerId,Long id){
       Contracts contractsToDelete = contractsRepository.findById(id).orElse(null);
       if (contractsToDelete != null && contractsToDelete.getReseller().getReseller_id().equals(resellerId)) {
           contractsRepository.deleteById(id);
           return new ResponseEntity<>("Assign Collector Deleted Successfully", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("Assign Collector Not Found",HttpStatus.NOT_FOUND);
       }
    }
    // update Contracts
    public ResponseEntity updateContract(Long resellerId,Long id, Contracts contracts){
        Contracts contractsForUpdate = contractsRepository.findById(id).orElse(null);
        if(contractsForUpdate !=null && contractsForUpdate.getReseller().getReseller_id().equals(resellerId)){
            contractsForUpdate.setCollector(contracts.getCollector());
            contractsRepository.save(contractsForUpdate);
            return new ResponseEntity("Contracts updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity("Contracts Not Found", HttpStatus.NOT_FOUND);
    }
}