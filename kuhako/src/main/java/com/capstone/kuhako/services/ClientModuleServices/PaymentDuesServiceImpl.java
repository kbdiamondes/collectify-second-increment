package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PaymentDues;
import com.capstone.kuhako.repositories.ClientModuleRepository.PaymentDuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentDuesServiceImpl {
    @Autowired
    private PaymentDuesRepository paymentDuesRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createPaymentDues(PaymentDues paymentDues){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        PaymentDues newPaymentDues = new PaymentDues();
        newPaymentDues.setItemName(paymentDues.getItemName());
        newPaymentDues.setRequiredCollectible(paymentDues.getRequiredCollectible());
        newPaymentDues.setDueStatus(paymentDues.isDueStatus());
        paymentDuesRepository.save(newPaymentDues);
    }
    public Iterable<PaymentDues> getPaymentDues(){
        return paymentDuesRepository.findAll();
    }

    public ResponseEntity deletePaymentDues(Long id){
        paymentDuesRepository.deleteById(id);
        return new ResponseEntity<>("PaymentDues Deleted successfully", HttpStatus.OK);

//        PaymentDues paymentDuesForDeleting = paymentDuesRepository.findById(id).get();
//        String paymentDuesName = paymentDuesForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(paymentDuesName)){
//            paymentDuesRepository.deleteById(id);
//            return new ResponseEntity<>("PaymentDues Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this PaymentDues",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updatePaymentDues(Long id, PaymentDues paymentDues){
        PaymentDues paymentDuesForUpdate = paymentDuesRepository.findById(id).get();

        paymentDuesForUpdate.setItemName(paymentDues.getItemName());
        paymentDuesForUpdate.setRequiredCollectible(paymentDues.getRequiredCollectible());
        paymentDuesForUpdate.setDueStatus(paymentDues.isDueStatus());

        paymentDuesRepository.save(paymentDuesForUpdate);

        return new ResponseEntity("PaymentDues updated successfully", HttpStatus.OK);

//        PaymentDues paymentDuesForUpdating = paymentDuesRepository.findById(id).get();
//        String paymentDuesName = paymentDuesForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(paymentDuesName)){
//            paymentDuesForUpdating.setName(paymentDues.getName());
//            paymentDuesForUpdating.setDescription(paymentDues.getDescription());
//            paymentDuesForUpdating.setPrice(paymentDues.getPrice());
//
//            paymentDuesRepository.save(paymentDuesForUpdating);
//            return  new ResponseEntity("PaymentDues has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this PaymentDues.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
