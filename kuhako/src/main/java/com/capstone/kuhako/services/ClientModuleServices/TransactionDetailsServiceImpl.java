package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.TransactionDetails;
import com.capstone.kuhako.repositories.ClientModuleRepository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService{
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    public void createTransactionDetails(TransactionDetails transactionDetails){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        TransactionDetails newTransactionDetails = new TransactionDetails();
        newTransactionDetails.setClient(transactionDetails.getClient());
        newTransactionDetails.setMonthlyCollectible(transactionDetails.getMonthlyCollectible());
        newTransactionDetails.setFullCashPrice(transactionDetails.getFullCashPrice());
        newTransactionDetails.setInterestRate(transactionDetails.getInterestRate());
        newTransactionDetails.setDueDate(transactionDetails.getDueDate());
        newTransactionDetails.setTotalPayment(transactionDetails.getTotalPayment());
        transactionDetailsRepository.save(newTransactionDetails);
    }
    public Iterable<TransactionDetails> getTransactionDetails(){
        return transactionDetailsRepository.findAll();
    }

    public ResponseEntity deleteTransactionDetails(Long id){
        transactionDetailsRepository.deleteById(id);
        return new ResponseEntity<>("TransactionDetails Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateTransactionDetails(Long id, TransactionDetails transactionDetails){
        TransactionDetails transactionDetailsForUpdate = transactionDetailsRepository.findById(id).get();
        transactionDetailsForUpdate.setClient(transactionDetails.getClient());
        transactionDetailsForUpdate.setMonthlyCollectible(transactionDetails.getMonthlyCollectible());
        transactionDetailsForUpdate.setFullCashPrice(transactionDetails.getFullCashPrice());
        transactionDetailsForUpdate.setInterestRate(transactionDetails.getInterestRate());
        transactionDetailsForUpdate.setDueDate(transactionDetails.getDueDate());
        transactionDetailsForUpdate.setTotalPayment(transactionDetails.getTotalPayment());
        transactionDetailsRepository.save(transactionDetailsForUpdate);
        return new ResponseEntity("TransactionDetails updated successfully", HttpStatus.OK);
    }
}
