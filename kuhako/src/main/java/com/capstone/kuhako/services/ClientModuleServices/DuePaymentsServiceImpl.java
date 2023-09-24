package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.repositories.ClientModuleRepository.DuePaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DuePaymentsServiceImpl implements DuePaymentsService {
    @Autowired
    private DuePaymentsRepository duePaymentRepository;

    public void createDuePayments(DuePayments paymentDues){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        DuePayments newDuePayments = new DuePayments();
        newDuePayments.setClient(paymentDues.getClient());
        newDuePayments.setItemName(paymentDues.getItemName());
        newDuePayments.setRequiredCollectible(paymentDues.getRequiredCollectible());
        newDuePayments.setDueStatus(paymentDues.isDueStatus());
        duePaymentRepository.save(newDuePayments);
    }
    public Iterable<DuePayments> getDuePayments(){
        return duePaymentRepository.findAll();
    }


    public ResponseEntity deleteDuePayments(Long id){
        duePaymentRepository.deleteById(id);
        return new ResponseEntity<>("PaymentDues Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateDuePayments(Long id, DuePayments paymentDues){
        DuePayments paymentDuesForUpdate = duePaymentRepository.findById(id).get();
        paymentDuesForUpdate.setClient(paymentDues.getClient());
        paymentDuesForUpdate.setItemName(paymentDues.getItemName());
        paymentDuesForUpdate.setRequiredCollectible(paymentDues.getRequiredCollectible());
        paymentDuesForUpdate.setDueStatus(paymentDues.isDueStatus());
        duePaymentRepository.save(paymentDuesForUpdate);
        return new ResponseEntity("PaymentDues updated successfully", HttpStatus.OK);
    }
    
//    public Iterable<DuePayments> getClientDuePayments(Client client) {
//        return duePaymentRepository.findbyClient(client);
//    }
}
