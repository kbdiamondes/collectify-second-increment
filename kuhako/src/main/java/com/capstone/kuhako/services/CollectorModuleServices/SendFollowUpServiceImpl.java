package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import com.capstone.kuhako.repositories.CollectorModuleRepository.SendFollowUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SendFollowUpServiceImpl {
    @Autowired
    private SendFollowUpRepository sendFollowUpRepository;

//    @Autowired
//    CollectorRepository collectorRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createSendFollowUp(SendFollowUp sendFollowUp){
//        Collector author = collectorRepository.findByCollectorname(jwtToken.getCollectornameFromToken(stringToken));

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

//        SendFollowUp sendFollowUpForDeleting = sendFollowUpRepository.findById(id).get();
//        String sendFollowUpName = sendFollowUpForDeleting.getCollector().getCollectorname();
//        String authenticatedCollectorname = jwtToken.getCollectornameFromToken(stringToken);
//
//        if (authenticatedCollectorname.equals(sendFollowUpName)){
//            sendFollowUpRepository.deleteById(id);
//            return new ResponseEntity<>("SendFollowUp Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this SendFollowUp",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateSendFollowUp(Long id, SendFollowUp sendFollowUp){
        SendFollowUp sendFollowUpForUpdate = sendFollowUpRepository.findById(id).get();

        sendFollowUpForUpdate.setCollector(sendFollowUp.getCollector());
        sendFollowUpForUpdate.setPaymentStatus(sendFollowUp.getPaymentStatus());
        sendFollowUpForUpdate.setReminderMessage(sendFollowUp.getReminderMessage());

        sendFollowUpRepository.save(sendFollowUpForUpdate);

        return new ResponseEntity("SendFollowUp updated successfully", HttpStatus.OK);

//        SendFollowUp sendFollowUpForUpdating = sendFollowUpRepository.findById(id).get();
//        String sendFollowUpName = sendFollowUpForUpdating.getCollector().getCollectorname();
//        String authenticatedCollectorName= jwtToken.getCollectornameFromToken(stringToken);
//
//        if(authenticatedCollectorName.equals(sendFollowUpName)){
//            sendFollowUpForUpdating.setName(sendFollowUp.getName());
//            sendFollowUpForUpdating.setDescription(sendFollowUp.getDescription());
//            sendFollowUpForUpdating.setPrice(sendFollowUp.getPrice());
//
//            sendFollowUpRepository.save(sendFollowUpForUpdating);
//            return  new ResponseEntity("SendFollowUp has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("You are not authorize to update this SendFollowUp.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
