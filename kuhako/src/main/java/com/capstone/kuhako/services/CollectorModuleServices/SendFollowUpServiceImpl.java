package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import com.capstone.kuhako.repositories.CollectorModuleRepository.SendFollowUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SendFollowUpServiceImpl implements SendFollowUpService{
    @Autowired
    private SendFollowUpRepository sendFollowUpRepository;

    public void createSendFollowUp(SendFollowUp sendFollowUp){
//      Collector author = collectorRepository.findByCollectorname(jwtToken.getCollectornameFromToken(stringToken));
        SendFollowUp newSendFollowUp = new SendFollowUp();
        newSendFollowUp.setCollector(sendFollowUp.getCollector());
        newSendFollowUp.setPaymentStatus(sendFollowUp.getPaymentStatus());
        newSendFollowUp.setReminderMessage(sendFollowUp.getReminderMessage());
        sendFollowUpRepository.save(newSendFollowUp);
    }
    public Iterable<SendFollowUp> getSendFollowUp(){
        return sendFollowUpRepository.findAll();
    }

    public ResponseEntity deleteSendFollowUp(Long id){
        sendFollowUpRepository.deleteById(id);
        return new ResponseEntity<>("SendFollowUp Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateSendFollowUp(Long id, SendFollowUp sendFollowUp){
        SendFollowUp sendFollowUpForUpdate = sendFollowUpRepository.findById(id).get();
        sendFollowUpForUpdate.setCollector(sendFollowUp.getCollector());
        sendFollowUpForUpdate.setPaymentStatus(sendFollowUp.getPaymentStatus());
        sendFollowUpForUpdate.setReminderMessage(sendFollowUp.getReminderMessage());
        sendFollowUpRepository.save(sendFollowUpForUpdate);
        return new ResponseEntity("SendFollowUp updated successfully", HttpStatus.OK);
    }
}
