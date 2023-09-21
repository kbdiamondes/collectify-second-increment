package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.repositories.ClientModuleRepository.DuePaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DuePaymentsServiceImpl implements DuePaymentsService {
    @Autowired
    private DuePaymentsRepository paymentDuesRepository;

    public void createDuePayments(DuePayments paymentDues){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        DuePayments newPaymentDues = new DuePayments();
        newPaymentDues.setClient(paymentDues.getClient());
        newPaymentDues.setItemName(paymentDues.getItemName());
        newPaymentDues.setRequiredCollectible(paymentDues.getRequiredCollectible());
        newPaymentDues.setDueStatus(paymentDues.isDueStatus());
        paymentDuesRepository.save(newPaymentDues);
    }
    public Iterable<DuePayments> getDuePayments(){
        return paymentDuesRepository.findAll();
    }

    public ResponseEntity deleteDuePayments(Long id){
        paymentDuesRepository.deleteById(id);
        return new ResponseEntity<>("PaymentDues Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateDuePayments(Long id, DuePayments paymentDues){
        DuePayments paymentDuesForUpdate = paymentDuesRepository.findById(id).get();
        paymentDuesForUpdate.setClient(paymentDues.getClient());
        paymentDuesForUpdate.setItemName(paymentDues.getItemName());
        paymentDuesForUpdate.setRequiredCollectible(paymentDues.getRequiredCollectible());
        paymentDuesForUpdate.setDueStatus(paymentDues.isDueStatus());
        paymentDuesRepository.save(paymentDuesForUpdate);
        return new ResponseEntity("PaymentDues updated successfully", HttpStatus.OK);
    }
}
