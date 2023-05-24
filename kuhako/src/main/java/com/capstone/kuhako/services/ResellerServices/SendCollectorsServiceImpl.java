package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import com.capstone.kuhako.repositories.ResellerRepositories.SendCollectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SendCollectorsServiceImpl {
    @Autowired
    private SendCollectorsRepository sendCollectorsRepository;
    public void createSendCollectors(SendCollectors sendCollectors){

        SendCollectors newSendCollectors = new SendCollectors();
        newSendCollectors.setReseller(sendCollectors.getReseller());
        newSendCollectors.setPaymentDues(sendCollectors.getPaymentDues());
        sendCollectorsRepository.save(newSendCollectors);
    }
    public Iterable<SendCollectors> getSendCollectors(){
        return sendCollectorsRepository.findAll();
    }

    public ResponseEntity deleteSendCollectors(Long id){
        sendCollectorsRepository.deleteById(id);
        return new ResponseEntity<>("SendCollectors Deleted successfully", HttpStatus.OK);

    }

    public ResponseEntity updateSendCollectors(Long id, SendCollectors sendCollectors){
        SendCollectors sendCollectorsForUpdate = sendCollectorsRepository.findById(id).get();

        sendCollectorsForUpdate.setReseller(sendCollectors.getReseller());
        sendCollectorsForUpdate.setPaymentDues(sendCollectors.getPaymentDues());

        sendCollectorsRepository.save(sendCollectorsForUpdate);

        return new ResponseEntity("SendCollectors updated successfully", HttpStatus.OK);

    }
}

