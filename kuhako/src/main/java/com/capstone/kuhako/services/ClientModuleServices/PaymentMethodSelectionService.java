package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.models.ClientModules.PaymentMethodSelection;
import org.springframework.http.ResponseEntity;

public interface PaymentMethodSelectionService {
    void createPaymentMethodSelection(PaymentMethodSelection paymentMethodSelection, Long clientId);

    Iterable<PaymentMethodSelection> getPaymentMethodSelection();

    Iterable<PaymentMethodSelection>getPaymentMethodSelectionByClientId(Long clientId);

    ResponseEntity deletePaymentMethodSelection(Long clientId, Long id);

    ResponseEntity updatePaymentMethodSelection(Long clientId,Long id, PaymentMethodSelection paymentMethodSelection);
}
