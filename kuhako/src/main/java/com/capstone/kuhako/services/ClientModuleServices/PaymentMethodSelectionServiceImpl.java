package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PaymentMethodSelection;
import com.capstone.kuhako.repositories.ClientModuleRepository.PaymentMethodSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodSelectionServiceImpl implements PaymentMethodSelectionService{
    @Autowired
    private PaymentMethodSelectionRepository paymentMethodSelectionRepository;


    public void createPaymentMethodSelection(PaymentMethodSelection paymentMethodSelection){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        PaymentMethodSelection newPaymentMethodSelection = new PaymentMethodSelection();
        newPaymentMethodSelection.setClient(paymentMethodSelection.getClient());
        newPaymentMethodSelection.setPurchaseMethod(paymentMethodSelection.getPurchaseMethod());
        newPaymentMethodSelection.setItemName(paymentMethodSelection.getItemName());
        newPaymentMethodSelection.setItemPrice(paymentMethodSelection.getItemPrice());
        newPaymentMethodSelection.setItemSpecs(paymentMethodSelection.getItemSpecs());
        newPaymentMethodSelection.setInstallmentAmount(paymentMethodSelection.getInstallmentAmount());
        paymentMethodSelectionRepository.save(newPaymentMethodSelection);
    }
    public Iterable<PaymentMethodSelection> getPaymentMethodSelection(){
        return paymentMethodSelectionRepository.findAll();
    }

    public ResponseEntity deletePaymentMethodSelection(Long id){
        paymentMethodSelectionRepository.deleteById(id);
        return new ResponseEntity<>("PaymentMethodSelection Deleted successfully", HttpStatus.OK);

    }

    public ResponseEntity updatePaymentMethodSelection(Long id, PaymentMethodSelection paymentMethodSelection){
        PaymentMethodSelection paymentMethodSelectionForUpdate = paymentMethodSelectionRepository.findById(id).get();
        paymentMethodSelectionForUpdate.setClient(paymentMethodSelection.getClient());
        paymentMethodSelectionForUpdate.setPurchaseMethod(paymentMethodSelection.getPurchaseMethod());
        paymentMethodSelectionForUpdate.setItemName(paymentMethodSelection.getItemName());
        paymentMethodSelectionForUpdate.setItemPrice(paymentMethodSelection.getItemPrice());
        paymentMethodSelectionForUpdate.setItemSpecs(paymentMethodSelection.getItemSpecs());
        paymentMethodSelectionForUpdate.setInstallmentAmount(paymentMethodSelection.getInstallmentAmount());
        paymentMethodSelectionRepository.save(paymentMethodSelectionForUpdate);
        return new ResponseEntity("PaymentMethodSelection updated successfully", HttpStatus.OK);
    }
}
