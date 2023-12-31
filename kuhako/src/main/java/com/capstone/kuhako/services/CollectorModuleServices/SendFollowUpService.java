package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import org.springframework.http.ResponseEntity;

public interface SendFollowUpService {
    void createSendFollowUp(Long collectorId, SendFollowUp paymentDues);

    Iterable<SendFollowUp> getSendFollowUp();

    Iterable<SendFollowUp> getSendFollowUpByCollectorId(Long collectorId);

    ResponseEntity deleteSendFollowUp(Long collectorId, Long id);

    ResponseEntity updateSendFollowUp(Long collectorId, Long id, SendFollowUp paymentDues);
}
