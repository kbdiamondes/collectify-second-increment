package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.PaymentAssuranceMessage;
import com.capstone.kuhako.repositories.CollectorModuleRepository.PaymentAssuranceMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentAssuranceMessageServiceImpl {
    @Autowired
    private PaymentAssuranceMessageRepository paymentAssuranceMessageRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createPaymentAssuranceMessage(PaymentAssuranceMessage paymentAssuranceMessage){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        PaymentAssuranceMessage newPaymentAssuranceMessage = new PaymentAssuranceMessage();
        newPaymentAssuranceMessage.setCollectorMessage(paymentAssuranceMessage.getCollectorMessage());
        newPaymentAssuranceMessage.setChatCollector(paymentAssuranceMessage.getChatCollector());
        paymentAssuranceMessageRepository.save(newPaymentAssuranceMessage);
    }
    public Iterable<PaymentAssuranceMessage> getPaymentAssuranceMessage(){
        return paymentAssuranceMessageRepository.findAll();
    }

    public ResponseEntity deletePaymentAssuranceMessage(Long id){
        paymentAssuranceMessageRepository.deleteById(id);
        return new ResponseEntity<>("PaymentAssuranceMessage Deleted successfully", HttpStatus.OK);

//        PaymentAssuranceMessage paymentAssuranceMessageForDeleting = paymentAssuranceMessageRepository.findById(id).get();
//        String paymentAssuranceMessageName = paymentAssuranceMessageForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(paymentAssuranceMessageName)){
//            paymentAssuranceMessageRepository.deleteById(id);
//            return new ResponseEntity<>("PaymentAssuranceMessage Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this PaymentAssuranceMessage",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updatePaymentAssuranceMessage(Long id, PaymentAssuranceMessage paymentAssuranceMessage){
        PaymentAssuranceMessage paymentAssuranceMessageForUpdate = paymentAssuranceMessageRepository.findById(id).get();

        paymentAssuranceMessageForUpdate.setCollectorMessage(paymentAssuranceMessage.getCollectorMessage());
        paymentAssuranceMessageForUpdate.setChatCollector(paymentAssuranceMessage.getChatCollector());

        paymentAssuranceMessageRepository.save(paymentAssuranceMessageForUpdate);

        return new ResponseEntity("PaymentAssuranceMessage updated successfully", HttpStatus.OK);

//        PaymentAssuranceMessage paymentAssuranceMessageForUpdating = paymentAssuranceMessageRepository.findById(id).get();
//        String paymentAssuranceMessageName = paymentAssuranceMessageForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(paymentAssuranceMessageName)){
//            paymentAssuranceMessageForUpdating.setName(paymentAssuranceMessage.getName());
//            paymentAssuranceMessageForUpdating.setDescription(paymentAssuranceMessage.getDescription());
//            paymentAssuranceMessageForUpdating.setPrice(paymentAssuranceMessage.getPrice());
//
//            paymentAssuranceMessageRepository.save(paymentAssuranceMessageForUpdating);
//            return  new ResponseEntity("PaymentAssuranceMessage has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("You are not authorize to update this PaymentAssuranceMessage.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
