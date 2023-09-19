package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PaymentMethodSelection;
import com.capstone.kuhako.repositories.ClientModuleRepository.PaymentMethodSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodSelectionServiceImpl {
    @Autowired
    private PaymentMethodSelectionRepository paymentMethodSelectionRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createPaymentMethodSelection(PaymentMethodSelection paymentMethodSelection){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

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

//        PaymentMethodSelection paymentMethodSelectionForDeleting = paymentMethodSelectionRepository.findById(id).get();
//        String paymentMethodSelectionName = paymentMethodSelectionForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(paymentMethodSelectionName)){
//            paymentMethodSelectionRepository.deleteById(id);
//            return new ResponseEntity<>("PaymentMethodSelection Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this PaymentMethodSelection",HttpStatus.UNAUTHORIZED);
//        }
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

//        PaymentMethodSelection paymentMethodSelectionForUpdating = paymentMethodSelectionRepository.findById(id).get();
//        String paymentMethodSelectionName = paymentMethodSelectionForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(paymentMethodSelectionName)){
//            paymentMethodSelectionForUpdating.setName(paymentMethodSelection.getName());
//            paymentMethodSelectionForUpdating.setDescription(paymentMethodSelection.getDescription());
//            paymentMethodSelectionForUpdating.setPrice(paymentMethodSelection.getPrice());
//
//            paymentMethodSelectionRepository.save(paymentMethodSelectionForUpdating);
//            return  new ResponseEntity("PaymentMethodSelection has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this PaymentMethodSelection.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
