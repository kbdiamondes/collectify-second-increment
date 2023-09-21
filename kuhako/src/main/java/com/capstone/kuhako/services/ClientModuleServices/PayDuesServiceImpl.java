package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PayDues;
import com.capstone.kuhako.repositories.ClientModuleRepository.PayDuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PayDuesServiceImpl implements PayDuesService{
    @Autowired
    private PayDuesRepository payDuesRepository;


    public void createPayDues(PayDues payDues){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        PayDues newPayDues = new PayDues();
        newPayDues.setClient(payDues.getClient());
        newPayDues.setDuePayments(payDues.getDuePayments());
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
    }

    public ResponseEntity updatePayDues(Long id, PayDues payDues){
        PayDues payDuesForUpdate = payDuesRepository.findById(id).get();
        payDuesForUpdate.setClient(payDues.getClient());
        payDuesForUpdate.setDuePayments(payDues.getDuePayments());
        payDuesForUpdate.setItemPrice(payDues.getItemPrice());
        payDuesForUpdate.setReferenceNumber(payDues.getReferenceNumber());
        payDuesForUpdate.setPaymentType(payDues.getPaymentType());
        payDuesForUpdate.setTransactionProof(payDues.getTransactionProof());
        payDuesRepository.save(payDuesForUpdate);
        return new ResponseEntity("PayDues updated successfully", HttpStatus.OK);
    }
}
