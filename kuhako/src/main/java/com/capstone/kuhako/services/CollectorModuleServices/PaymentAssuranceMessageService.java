package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.PaymentAssuranceMessage;
import org.springframework.http.ResponseEntity;

public interface PaymentAssuranceMessageService {
    void createPaymentAssuranceMessage(PaymentAssuranceMessage paymentDues);

    Iterable<PaymentAssuranceMessage> getPaymentAssuranceMessage();

    ResponseEntity deletePaymentAssuranceMessage(Long id);

    ResponseEntity updatePaymentAssuranceMessage(Long id, PaymentAssuranceMessage paymentDues);
}
