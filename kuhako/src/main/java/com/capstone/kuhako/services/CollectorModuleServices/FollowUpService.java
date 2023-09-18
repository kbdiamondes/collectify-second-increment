package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.FollowUp;
import org.springframework.http.ResponseEntity;

public interface FollowUpService {
    void createFollowUp(FollowUp paymentDues);

    Iterable<FollowUp> getFollowUp();

    ResponseEntity deleteFollowUp(Long id);

    ResponseEntity updateFollowUp(Long id, FollowUp paymentDues);
}
