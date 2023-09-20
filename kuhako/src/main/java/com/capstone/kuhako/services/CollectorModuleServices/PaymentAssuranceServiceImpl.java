package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;
import com.capstone.kuhako.repositories.CollectorModuleRepository.PaymentAssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentAssuranceServiceImpl implements PaymentAssuranceService {
    @Autowired
    private PaymentAssuranceRepository paymentAssuranceRepository;

    public void createPaymentAssurance(PaymentAssurance paymentAssurance){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
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
    }
    public ResponseEntity updatePaymentAssurance(Long id, PaymentAssurance paymentAssurance){
        PaymentAssurance paymentAssuranceForUpdate = paymentAssuranceRepository.findById(id).get();
        paymentAssuranceForUpdate.setCollector(paymentAssurance.getCollector());
        paymentAssuranceForUpdate.setPaymentStatus(paymentAssurance.getPaymentStatus());
        paymentAssuranceRepository.save(paymentAssuranceForUpdate);
        return new ResponseEntity("PaymentAssurance updated successfully", HttpStatus.OK);
    }
}
