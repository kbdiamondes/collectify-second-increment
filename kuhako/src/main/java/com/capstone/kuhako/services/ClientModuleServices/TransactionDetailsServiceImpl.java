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

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createTransactionDetails(TransactionDetails transactionDetails){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

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

//        TransactionDetails transactionDetailsForDeleting = transactionDetailsRepository.findById(id).get();
//        String transactionDetailsName = transactionDetailsForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(transactionDetailsName)){
//            transactionDetailsRepository.deleteById(id);
//            return new ResponseEntity<>("TransactionDetails Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this TransactionDetails",HttpStatus.UNAUTHORIZED);
//        }
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

//        TransactionDetails transactionDetailsForUpdating = transactionDetailsRepository.findById(id).get();
//        String transactionDetailsName = transactionDetailsForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(transactionDetailsName)){
//            transactionDetailsForUpdating.setName(transactionDetails.getName());
//            transactionDetailsForUpdating.setDescription(transactionDetails.getDescription());
//            transactionDetailsForUpdating.setPrice(transactionDetails.getPrice());
//
//            transactionDetailsRepository.save(transactionDetailsForUpdating);
//            return  new ResponseEntity("TransactionDetails has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this TransactionDetails.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
