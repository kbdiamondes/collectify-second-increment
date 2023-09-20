package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PaymentDues;
import com.capstone.kuhako.repositories.ClientModuleRepository.PaymentDuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentDuesServiceImpl implements PaymentDuesService {
    @Autowired
    private PaymentDuesRepository paymentDuesRepository;

    public void createPaymentDues(PaymentDues paymentDues){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        PaymentDues newPaymentDues = new PaymentDues();
        newPaymentDues.setClient(paymentDues.getClient());
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
    }

    public ResponseEntity updatePaymentDues(Long id, PaymentDues paymentDues){
        PaymentDues paymentDuesForUpdate = paymentDuesRepository.findById(id).get();
        paymentDuesForUpdate.setClient(paymentDues.getClient());
        paymentDuesForUpdate.setItemName(paymentDues.getItemName());
        paymentDuesForUpdate.setRequiredCollectible(paymentDues.getRequiredCollectible());
        paymentDuesForUpdate.setDueStatus(paymentDues.isDueStatus());
        paymentDuesRepository.save(paymentDuesForUpdate);
        return new ResponseEntity("PaymentDues updated successfully", HttpStatus.OK);
    }
}
