package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;
import org.springframework.http.ResponseEntity;

public interface PaymentAssuranceService {
    void createPaymentAssurance(PaymentAssurance paymentDues);

    Iterable<PaymentAssurance> getPaymentAssurance();

    ResponseEntity deletePaymentAssurance(Long id);

    ResponseEntity updatePaymentAssurance(Long id, PaymentAssurance paymentDues);
}
