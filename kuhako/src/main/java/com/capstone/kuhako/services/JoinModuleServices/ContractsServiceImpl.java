package com.capstone.kuhako.services.JoinModuleServices;

import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.JoinModule.*;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.CollectorRepository;
import com.capstone.kuhako.repositories.JoinModuleRepository.ContractsRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractsServiceImpl implements ContractsService {
    @Autowired
    private ContractsRepository contractsRepository;
    @Autowired
    private ResellerRepository resellerRepository;
    @Autowired
    private CollectorRepository collectorRepository;

    public boolean canCreateContract(Contracts newContract) {
        // Check if there are existing contracts with the same client and true status
        List<Contracts> existingContracts = contractsRepository.findByClientAndPaymentStatus(
                newContract.getClient(), true);
        if (!existingContracts.isEmpty()) {
            // Contracts with the same client and true status exist, prevent creation
            return false;
        }
        // No existing contracts with the same client and true status, allow creation
        return true;
    }

    // create Contracts
    public void createContract(Long resellerId, Contracts contracts){
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if(reseller != null){
            contracts.setReseller(reseller);
            contracts.setDebtRemaining(contracts.getItemPrice());
            contracts.setPaymentStatus(true);
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

    public Iterable<ContractsCollector> getContractsHistoryByCollectorId(Long collectorId){
        return contractsRepository.findContractsHistoryByCollectorId(collectorId);
    }

    public Iterable<ContractsClient> getContractsByClientId(Long clientId){
        return contractsRepository.findContractsByClientId(clientId);
    }

    // delete Contracts
    public ResponseEntity deleteContract(Long resellerId,Long id){
       Contracts contractsToDelete = contractsRepository.findById(id).orElse(null);
       if (contractsToDelete != null && contractsToDelete.getReseller().getReseller_id().equals(resellerId)) {
           contractsRepository.deleteById(id);
           return new ResponseEntity<>("Contracts Deleted Successfully", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("Contracts Not Found",HttpStatus.NOT_FOUND);
       }
    }

    // update Contracts
    public ResponseEntity updateContract(Long collectorId, Transactions transactions){
        Collector collector = collectorRepository.findById(collectorId).orElse(null);
        if(collector != null){
//            transactions.setCollector(collector);
//            contracts.setPaymentStatus(true);
//            contractsRepository.save(contracts);
        }
//        Contracts contractsForUpdate = contractsRepository.findById(id).orElse(null);
//        if(contractsForUpdate !=null && contractsForUpdate.getCollector().getCollector_id().equals(collectorId)){
//            contractsForUpdate.setCollector(contracts.getCollector());
//            contractsRepository.save(contractsForUpdate);
//            return new ResponseEntity("Contracts updated successfully", HttpStatus.OK);
//        }
        return new ResponseEntity("Contracts Not Found", HttpStatus.NOT_FOUND);
    }
}