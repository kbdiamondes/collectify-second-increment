package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PayDues;
import com.capstone.kuhako.repositories.ClientModuleRepository.PayDuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PayDuesServiceImpl {
    @Autowired
    private PayDuesRepository payDuesRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createPayDues(PayDues payDues){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        PayDues newPayDues = new PayDues();

        newPayDues.setClient(payDues.getClient());
        newPayDues.setPaymentDues(payDues.getPaymentDues());
        newPayDues.setItemPrice(payDues.getItemPrice());
        newPayDues.setReferenceNumber(payDues.getReferenceNumber());
        newPayDues.setPaymentType(payDues.getPaymentType());
        newPayDues.setTransactionProof(payDues.getTransactionProof());
        payDuesRepository.save(newPayDues);
    }
    public Iterable<PayDues> getPayDues(){
        return payDuesRepository.findAll();
    }

    public ResponseEntity deletePayDues(Long id){
        payDuesRepository.deleteById(id);
        return new ResponseEntity<>("PayDues Deleted successfully", HttpStatus.OK);

//        PayDues payDuesForDeleting = payDuesRepository.findById(id).get();
//        String payDuesName = payDuesForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(payDuesName)){
//            payDuesRepository.deleteById(id);
//            return new ResponseEntity<>("PayDues Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this PayDues",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updatePayDues(Long id, PayDues payDues){
        PayDues payDuesForUpdate = payDuesRepository.findById(id).get();

        payDuesForUpdate.setClient(payDues.getClient());
        payDuesForUpdate.setPaymentDues(payDues.getPaymentDues());
        payDuesForUpdate.setItemPrice(payDues.getItemPrice());
        payDuesForUpdate.setReferenceNumber(payDues.getReferenceNumber());
        payDuesForUpdate.setPaymentType(payDues.getPaymentType());
        payDuesForUpdate.setTransactionProof(payDues.getTransactionProof());

        payDuesRepository.save(payDuesForUpdate);

        return new ResponseEntity("PayDues updated successfully", HttpStatus.OK);

//        PayDues payDuesForUpdating = payDuesRepository.findById(id).get();
//        String payDuesName = payDuesForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(payDuesName)){
//            payDuesForUpdating.setName(payDues.getName());
//            payDuesForUpdating.setDescription(payDues.getDescription());
//            payDuesForUpdating.setPrice(payDues.getPrice());
//
//            payDuesRepository.save(payDuesForUpdating);
//            return  new ResponseEntity("PayDues has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this PayDues.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
