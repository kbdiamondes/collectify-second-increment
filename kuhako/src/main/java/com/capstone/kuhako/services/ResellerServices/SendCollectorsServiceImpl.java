package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
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
    private ResellerRepository resellerRepository;

    public void createSendCollectors(Long resellerId, SendCollectors sendCollectors) {
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if(reseller != null){
            sendCollectors.setReseller(reseller);
            sendCollectorsRepository.save(sendCollectors);
        }
    }
    public Iterable<SendCollectors> getSendCollectors(){
        return sendCollectorsRepository.findAll();
    }

    public Iterable<SendCollectors> getSendCollectorsByResellerId(Long resellerId){
        return sendCollectorsRepository.findSendCollectorsByResellerId(resellerId);
    }
    
    public ResponseEntity deleteSendCollectors(Long resellerId,Long id){
        SendCollectors sendCollectorsToDelete = sendCollectorsRepository.findById(id).orElse(null);
        if (sendCollectorsToDelete != null && sendCollectorsToDelete.getReseller().getReseller_id().equals(resellerId)) {
            sendCollectorsRepository.deleteById(id);
            return new ResponseEntity<>("Assign Collector Deleted Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Assign Collector Not Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> updateSendCollectors(Long resellerId,Long id, SendCollectors sendCollectors) {
        SendCollectors sendCollectorsForUpdate = sendCollectorsRepository.findById(id).orElse(null);
        if (sendCollectorsForUpdate != null && sendCollectorsForUpdate.getReseller().getReseller_id().equals(resellerId)) {
            sendCollectorsForUpdate.setPaymentDues(sendCollectors.getPaymentDues());
            sendCollectorsRepository.save(sendCollectorsForUpdate);
            return new ResponseEntity<>("Send Collectors updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Send Collectors not found", HttpStatus.NOT_FOUND);
        }
    }

}

