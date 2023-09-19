package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.TransactionHistory;
import com.capstone.kuhako.repositories.ClientModuleRepository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryServiceImpl {
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createTransactionHistory(TransactionHistory transactionHistory){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

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

//        TransactionHistory transactionHistoryForDeleting = transactionHistoryRepository.findById(id).get();
//        String transactionHistoryName = transactionHistoryForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(transactionHistoryName)){
//            transactionHistoryRepository.deleteById(id);
//            return new ResponseEntity<>("TransactionHistory Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this TransactionHistory",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateTransactionHistory(Long id, TransactionHistory transactionHistory){
        TransactionHistory transactionHistoryForUpdate = transactionHistoryRepository.findById(id).get();

        transactionHistoryForUpdate.setClient(transactionHistory.getClient());
        transactionHistoryForUpdate.setTransactionDate(transactionHistory.getTransactionDate());
        transactionHistoryForUpdate.setAmountSent(transactionHistory.getAmountSent());

        transactionHistoryRepository.save(transactionHistoryForUpdate);

        return new ResponseEntity("TransactionHistory updated successfully", HttpStatus.OK);

//        TransactionHistory transactionHistoryForUpdating = transactionHistoryRepository.findById(id).get();
//        String transactionHistoryName = transactionHistoryForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(transactionHistoryName)){
//            transactionHistoryForUpdating.setName(transactionHistory.getName());
//            transactionHistoryForUpdating.setDescription(transactionHistory.getDescription());
//            transactionHistoryForUpdating.setPrice(transactionHistory.getPrice());
//
//            transactionHistoryRepository.save(transactionHistoryForUpdating);
//            return  new ResponseEntity("TransactionHistory has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this TransactionHistory.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
