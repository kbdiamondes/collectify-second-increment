package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.CollectPayments;
import org.springframework.http.ResponseEntity;

public interface CollectPaymentsService {
    void createCollectPayments(Long collectorId, CollectPayments paymentDues);

    Iterable<CollectPayments> getCollectPayments();

    Iterable<CollectPayments> getCollectPaymentsByCollectorId(Long collectorId);

    ResponseEntity deleteCollectPayments(Long collectorId, Long id);

    ResponseEntity updateCollectPayments(Long collectorId, Long id, CollectPayments paymentDues);
}
