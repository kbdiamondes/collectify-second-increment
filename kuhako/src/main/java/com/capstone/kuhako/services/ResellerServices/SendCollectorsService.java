package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import org.springframework.http.ResponseEntity;

public interface SendCollectorsService{
    void createSendCollectors(Long resellerId,SendCollectors sendCollectors);
    Iterable<SendCollectors> getSendCollectors();
    Iterable<SendCollectors>getSendCollectorsByResellerId(Long resellerId);
    ResponseEntity deleteSendCollectors(Long resellerId,Long id);
    ResponseEntity updateSendCollectors(Long resellerId,Long id, SendCollectors sendCollectors);
}