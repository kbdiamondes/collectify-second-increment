package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;
import org.springframework.http.ResponseEntity;

public interface PaymentAssuranceService {
    void createPaymentAssurance(Long collectorId, PaymentAssurance paymentDues);

    Iterable<PaymentAssurance> getPaymentAssurance();

    Iterable<PaymentAssurance> getPaymentAssuranceByCollectorId(Long collectorId);;

    ResponseEntity deletePaymentAssurance(Long collectorId, Long id);

    ResponseEntity updatePaymentAssurance(Long collectorId, Long id, PaymentAssurance paymentDues);
}
