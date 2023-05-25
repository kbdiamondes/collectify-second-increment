package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import com.capstone.kuhako.repositories.ClientRepository;
import com.capstone.kuhako.repositories.CollectorRepository;
import com.capstone.kuhako.repositories.ResellerRepositories.SendCollectorsRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SendCollectorsServiceImpl implements SendCollectorsService{

    @Autowired
    private SendCollectorsRepository sendCollectorsRepository;

    @Autowired
    ResellerRepository resellerRepository;

    public void createSendCollectors(SendCollectors sendCollectors) {
        sendCollectorsRepository.save(sendCollectors);
    }

    public Iterable<SendCollectors> getSendCollectors(){
        return sendCollectorsRepository.findAll();
    }

    public ResponseEntity deleteSendCollectors(Long id){
        sendCollectorsRepository.deleteById(id);
        return new ResponseEntity<>("SendCollectors Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> updateSendCollectors(Long id, SendCollectors sendCollectors) {
        SendCollectors sendCollectorsForUpdate = sendCollectorsRepository.findById(id).orElse(null);
        if (sendCollectorsForUpdate != null) {
            sendCollectorsForUpdate.setReseller(sendCollectors.getReseller());
            sendCollectorsForUpdate.setPaymentDues(sendCollectors.getPaymentDues());
            sendCollectorsRepository.save(sendCollectorsForUpdate);
            return new ResponseEntity<>("SendCollectors updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("SendCollectors not found", HttpStatus.NOT_FOUND);
        }
    }

}

