package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import org.springframework.http.ResponseEntity;

public interface CollectAllDuePaymentsService{
    void createCollectAllDuePayments(CollectAllDuePayments paymentDues);

    Iterable<CollectAllDuePayments> getCollectAllDuePayments();

    ResponseEntity deleteCollectAllDuePayments(Long id);

    ResponseEntity updateCollectAllDuePayments(Long id, CollectAllDuePayments paymentDues);
}
