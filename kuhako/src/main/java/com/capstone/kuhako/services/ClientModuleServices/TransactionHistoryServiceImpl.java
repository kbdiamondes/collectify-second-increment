package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.TransactionHistory;
import com.capstone.kuhako.repositories.ClientModuleRepository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService{
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    public void createTransactionHistory(TransactionHistory transactionHistory){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        TransactionHistory newTransactionHistory = new TransactionHistory();
        newTransactionHistory.setClient(transactionHistory.getClient());
        newTransactionHistory.setTransactionDate(transactionHistory.getTransactionDate());
        newTransactionHistory.setAmountSent(transactionHistory.getAmountSent());
        transactionHistoryRepository.save(newTransactionHistory);
    }
    public Iterable<TransactionHistory> getTransactionHistory(){
        return transactionHistoryRepository.findAll();
    }

    public ResponseEntity deleteTransactionHistory(Long id){
        transactionHistoryRepository.deleteById(id);
        return new ResponseEntity<>("TransactionHistory Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateTransactionHistory(Long id, TransactionHistory transactionHistory){
        TransactionHistory transactionHistoryForUpdate = transactionHistoryRepository.findById(id).get();
        transactionHistoryForUpdate.setClient(transactionHistory.getClient());
        transactionHistoryForUpdate.setTransactionDate(transactionHistory.getTransactionDate());
        transactionHistoryForUpdate.setAmountSent(transactionHistory.getAmountSent());
        transactionHistoryRepository.save(transactionHistoryForUpdate);
        return new ResponseEntity("TransactionHistory updated successfully", HttpStatus.OK);
    }
}
