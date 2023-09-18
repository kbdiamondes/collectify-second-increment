package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import org.springframework.http.ResponseEntity;

public interface SendFollowUpService {
    void createSendFollowUp(SendFollowUp paymentDues);

    Iterable<SendFollowUp> getSendFollowUp();

    ResponseEntity deleteSendFollowUp(Long id);

    ResponseEntity updateSendFollowUp(Long id, SendFollowUp paymentDues);
}
