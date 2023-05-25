package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import org.springframework.http.ResponseEntity;

public interface SendCollectorsService{
    void createSendCollectors(SendCollectors sendCollectors);
    Iterable<SendCollectors> getSendCollectors();
    ResponseEntity deleteSendCollectors(Long id);
    ResponseEntity updateSendCollectors(Long id, SendCollectors sendCollectors);
}