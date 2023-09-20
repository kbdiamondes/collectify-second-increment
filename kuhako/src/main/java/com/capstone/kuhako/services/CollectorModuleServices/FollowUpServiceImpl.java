package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.FollowUp;
import com.capstone.kuhako.repositories.CollectorModuleRepository.FollowUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FollowUpServiceImpl implements FollowUpService{
    @Autowired
    private FollowUpRepository followUpRepository;

    public void createFollowUp(FollowUp followUp){
//      Collector author = collectorRepository.findByCollectorname(jwtToken.getCollectornameFromToken(stringToken));
        FollowUp newFollowUp = new FollowUp();
        newFollowUp.setCollector(followUp.getCollector());
        newFollowUp.setPaymentStatus(followUp.getPaymentStatus());
        followUpRepository.save(newFollowUp);
    }
    public Iterable<FollowUp> getFollowUp(){
        return followUpRepository.findAll();
    }

    public ResponseEntity deleteFollowUp(Long id){
        followUpRepository.deleteById(id);
        return new ResponseEntity<>("FollowUp Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateFollowUp(Long id, FollowUp followUp){
        FollowUp followUpForUpdate = followUpRepository.findById(id).get();
        followUpForUpdate.setCollector(followUp.getCollector());
        followUpForUpdate.setPaymentStatus(followUp.getPaymentStatus());
        followUpRepository.save(followUpForUpdate);
        return new ResponseEntity("FollowUp updated successfully", HttpStatus.OK);
    }
}
