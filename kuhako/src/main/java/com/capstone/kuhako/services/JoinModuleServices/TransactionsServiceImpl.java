package com.capstone.kuhako.services.JoinModuleServices;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.models.JoinModule.ContractsHistory;
import com.capstone.kuhako.models.JoinModule.Transactions;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.ClientRepository;
import com.capstone.kuhako.repositories.JoinModuleRepository.ContractsHistoryRepository;
import com.capstone.kuhako.repositories.JoinModuleRepository.ContractsRepository;
import com.capstone.kuhako.repositories.JoinModuleRepository.TransactionsRepository;
import com.capstone.kuhako.repositories.CollectorRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private CollectorRepository collectorRepository;
    @Autowired
    private ContractsRepository contractsRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ResellerRepository resellerRepository;
    @Autowired
    private ContractsHistoryRepository contractsHistoryRepository;

    // Create Transactions
    public void createTransactions(Long collectorId,Transactions transactions){
        Collector collector = collectorRepository.findById(collectorId).get();
        Contracts contracts = contractsRepository.findById(transactions.getContracts().getContracts_id()).get();
        Client client = clientRepository.findById(contracts.getClient().getClient_id()).get();
        Reseller reseller = resellerRepository.findById(contracts.getReseller().getReseller_id()).get();
        transactions.setCollector(collector);

        contracts.setDebtRemaining(contracts.getDebtRemaining()-transactions.getAmountPayments());
        transactionsRepository.save(transactions);
        if (contracts.getDebtRemaining()==0){
            ContractsHistory contractsHistory = new ContractsHistory(
                    contracts.getReseller(),
                    contracts.getClient(),
                    contracts.getCollector(),
                    contracts.getItemName(),
                    contracts.getItemPrice(),
                    contracts.getPaymentType(),
                    contracts.getSpecifications(),
                    new HashSet<>(contracts.getTransactions())
            );
            client.setReseller(null);
            client.setCollector(null);
            reseller.getClients().remove(client);
            collector.getClients().remove(client);
            client.setContract(null);
            reseller.getContracts().remove(contracts);
            collector.getContracts().remove(contracts);
            List<Transactions> transactionsList = transactionsRepository.findByContracts(contracts);
            for (Transactions transaction : transactionsList) {
                transaction.setContracts(null);
                transactionsRepository.save(transaction);
            }
            contractsHistoryRepository.save(contractsHistory);
            // Remove the contract and its transactions
            contractsRepository.delete(contracts);
        }
        else {
            contractsRepository.save(contracts);
        }
}


    // Get all Collector
    public Iterable<Transactions> getTransactions(){
        return transactionsRepository.findAll();
    }

//    public Iterable<Transactions> getTransactionsByCollectorId(Long collectorId){
//        return transactionsRepository.findTransactionsByCollectorId(collectorId);
//    }


    // delete Collectors

    public ResponseEntity deleteTransactions(Long collectorId, Long id){
        Transactions transactionsToDelete = transactionsRepository.findById(id).orElse(null);
        if (transactionsToDelete != null && transactionsToDelete.getCollector().getCollector_id().equals(collectorId)) {
            transactionsRepository.deleteById(id);
            return new ResponseEntity<>("Transactions Deleted Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Transactions Not Found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity updateTransactions(Long collectorId, Long id, Transactions transactions){
        Transactions transactionsForUpdate = transactionsRepository.findById(id).orElse(null);
        if (transactionsForUpdate != null && transactionsForUpdate.getCollector().getCollector_id().equals(collectorId)){
//            transactionsForUpdate.setCollectionStatus(transactions.getCollectionStatus());
//            transactionsForUpdate.setRequiredCollectibles(transactions.getRequiredCollectibles());
            transactionsRepository.save(transactionsForUpdate);
            return new ResponseEntity("Transactions updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity("Transactions updated successfully", HttpStatus.NOT_FOUND);
    }
}
