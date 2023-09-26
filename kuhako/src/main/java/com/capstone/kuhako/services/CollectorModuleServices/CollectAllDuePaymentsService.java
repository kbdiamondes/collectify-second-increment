package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import org.springframework.http.ResponseEntity;

public interface CollectAllDuePaymentsService{
    void createCollectAllDuePayments(Long collectorId, CollectAllDuePayments paymentDues);

    Iterable<CollectAllDuePayments> getCollectAllDuePayments();

    Iterable<CollectAllDuePayments> getCollectAllDuePaymentsByCollectorId(Long collectorId);

    ResponseEntity deleteCollectAllDuePayments(Long collectorId, Long id);

    ResponseEntity updateCollectAllDuePayments(Long collectorId, Long id, CollectAllDuePayments paymentDues);
}
