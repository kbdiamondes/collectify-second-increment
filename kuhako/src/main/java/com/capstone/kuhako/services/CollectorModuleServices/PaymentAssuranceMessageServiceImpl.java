package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.PaymentAssuranceMessage;
import com.capstone.kuhako.repositories.CollectorModuleRepository.PaymentAssuranceMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentAssuranceMessageServiceImpl implements PaymentAssuranceMessageService{
    @Autowired
    private PaymentAssuranceMessageRepository paymentAssuranceMessageRepository;

//    @Autowired
//    CollectorRepository collectorRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createPaymentAssuranceMessage(PaymentAssuranceMessage paymentAssuranceMessage){
//        Collector author = collectorRepository.findByCollectorname(jwtToken.getCollectornameFromToken(stringToken));

        PaymentAssuranceMessage newPaymentAssuranceMessage = new PaymentAssuranceMessage();
        newPaymentAssuranceMessage.setCollector(paymentAssuranceMessage.getCollector());
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
//        String paymentAssuranceMessageName = paymentAssuranceMessageForDeleting.getCollector().getCollectorname();
//        String authenticatedCollectorname = jwtToken.getCollectornameFromToken(stringToken);
//
//        if (authenticatedCollectorname.equals(paymentAssuranceMessageName)){
//            paymentAssuranceMessageRepository.deleteById(id);
//            return new ResponseEntity<>("PaymentAssuranceMessage Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this PaymentAssuranceMessage",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updatePaymentAssuranceMessage(Long id, PaymentAssuranceMessage paymentAssuranceMessage){
        PaymentAssuranceMessage paymentAssuranceMessageForUpdate = paymentAssuranceMessageRepository.findById(id).get();

        paymentAssuranceMessageForUpdate.setCollector(paymentAssuranceMessageForUpdate.getCollector());
        paymentAssuranceMessageForUpdate.setCollectorMessage(paymentAssuranceMessage.getCollectorMessage());
        paymentAssuranceMessageForUpdate.setChatCollector(paymentAssuranceMessage.getChatCollector());

        paymentAssuranceMessageRepository.save(paymentAssuranceMessageForUpdate);

        return new ResponseEntity("PaymentAssuranceMessage updated successfully", HttpStatus.OK);

//        PaymentAssuranceMessage paymentAssuranceMessageForUpdating = paymentAssuranceMessageRepository.findById(id).get();
//        String paymentAssuranceMessageName = paymentAssuranceMessageForUpdating.getCollector().getCollectorname();
//        String authenticatedCollectorName= jwtToken.getCollectornameFromToken(stringToken);
//
//        if(authenticatedCollectorName.equals(paymentAssuranceMessageName)){
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
