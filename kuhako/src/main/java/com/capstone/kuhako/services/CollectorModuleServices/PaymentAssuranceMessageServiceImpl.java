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

    public void createPaymentAssuranceMessage(PaymentAssuranceMessage paymentAssuranceMessage){
//      Collector author = collectorRepository.findByCollectorname(jwtToken.getCollectornameFromToken(stringToken));
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
    }

    public ResponseEntity updatePaymentAssuranceMessage(Long id, PaymentAssuranceMessage paymentAssuranceMessage){
        PaymentAssuranceMessage paymentAssuranceMessageForUpdate = paymentAssuranceMessageRepository.findById(id).get();
        paymentAssuranceMessageForUpdate.setCollector(paymentAssuranceMessageForUpdate.getCollector());
        paymentAssuranceMessageForUpdate.setCollectorMessage(paymentAssuranceMessage.getCollectorMessage());
        paymentAssuranceMessageForUpdate.setChatCollector(paymentAssuranceMessage.getChatCollector());
        paymentAssuranceMessageRepository.save(paymentAssuranceMessageForUpdate);
        return new ResponseEntity("PaymentAssuranceMessage updated successfully", HttpStatus.OK);
    }
}
