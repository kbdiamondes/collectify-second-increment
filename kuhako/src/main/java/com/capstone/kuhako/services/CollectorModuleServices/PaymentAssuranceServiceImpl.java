package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;
import com.capstone.kuhako.repositories.CollectorModuleRepository.PaymentAssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentAssuranceServiceImpl {
    @Autowired
    private PaymentAssuranceRepository paymentAssuranceRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createPaymentAssurance(PaymentAssurance paymentAssurance){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        PaymentAssurance newPaymentAssurance = new PaymentAssurance();
        newPaymentAssurance.setCollector(paymentAssurance.getCollector());
        newPaymentAssurance.setPaymentStatus(paymentAssurance.getPaymentStatus());
        paymentAssuranceRepository.save(newPaymentAssurance);
    }
    public Iterable<PaymentAssurance> getPaymentAssurance(){
        return paymentAssuranceRepository.findAll();
    }

    public ResponseEntity deletePaymentAssurance(Long id){
        paymentAssuranceRepository.deleteById(id);
        return new ResponseEntity<>("PaymentAssurance Deleted successfully", HttpStatus.OK);

//        PaymentAssurance paymentAssuranceForDeleting = paymentAssuranceRepository.findById(id).get();
//        String paymentAssuranceName = paymentAssuranceForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(paymentAssuranceName)){
//            paymentAssuranceRepository.deleteById(id);
//            return new ResponseEntity<>("PaymentAssurance Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this PaymentAssurance",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updatePaymentAssurance(Long id, PaymentAssurance paymentAssurance){
        PaymentAssurance paymentAssuranceForUpdate = paymentAssuranceRepository.findById(id).get();

        paymentAssuranceForUpdate.setCollector(paymentAssurance.getCollector());
        paymentAssuranceForUpdate.setPaymentStatus(paymentAssurance.getPaymentStatus());

        paymentAssuranceRepository.save(paymentAssuranceForUpdate);

        return new ResponseEntity("PaymentAssurance updated successfully", HttpStatus.OK);

//        PaymentAssurance paymentAssuranceForUpdating = paymentAssuranceRepository.findById(id).get();
//        String paymentAssuranceName = paymentAssuranceForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(paymentAssuranceName)){
//            paymentAssuranceForUpdating.setName(paymentAssurance.getName());
//            paymentAssuranceForUpdating.setDescription(paymentAssurance.getDescription());
//            paymentAssuranceForUpdating.setPrice(paymentAssurance.getPrice());
//
//            paymentAssuranceRepository.save(paymentAssuranceForUpdating);
//            return  new ResponseEntity("PaymentAssurance has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("You are not authorize to update this PaymentAssurance.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
