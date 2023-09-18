package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.CollectPayments;
import org.springframework.http.ResponseEntity;

public interface CollectPaymentsService {
    void createCollectPayments(CollectPayments paymentDues);

    Iterable<CollectPayments> getCollectPayments();

    ResponseEntity deleteCollectPayments(Long id);

    ResponseEntity updateCollectPayments(Long id, CollectPayments paymentDues);
}
