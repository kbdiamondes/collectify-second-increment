package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.FollowUp;
import org.springframework.http.ResponseEntity;

public interface FollowUpService {
    void createFollowUp(Long collectorId, FollowUp paymentDues);

    Iterable<FollowUp> getFollowUp();

    Iterable<FollowUp> getFollowUpByCollectorId(Long collectorId);;

    ResponseEntity deleteFollowUp(Long collectorId, Long id);

    ResponseEntity updateFollowUp(Long collectorId, Long id, FollowUp paymentDues);
}
