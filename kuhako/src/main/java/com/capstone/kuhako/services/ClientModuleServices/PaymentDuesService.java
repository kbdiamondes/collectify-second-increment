package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PaymentDues;
import org.springframework.http.ResponseEntity;

public interface PaymentDuesService {
    void createPaymentDues(PaymentDues paymentDues);

    Iterable<PaymentDues> getPaymentDues();

    ResponseEntity deletePaymentDues(Long id);

    ResponseEntity updatePaymentDues(Long id, PaymentDues paymentDues);
}
