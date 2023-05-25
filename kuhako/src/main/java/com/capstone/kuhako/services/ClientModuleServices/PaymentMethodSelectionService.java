package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PaymentMethodSelection;
import org.springframework.http.ResponseEntity;

public interface PaymentMethodSelectionService {
    void createPaymentMethodSelection(PaymentMethodSelection paymentMethodSelection);

    Iterable<PaymentMethodSelection> getPaymentMethodSelection();

    ResponseEntity deletePaymentMethodSelection(Long id);

    ResponseEntity updatePaymentMethodSelection(Long id, PaymentMethodSelection paymentMethodSelection);
}
