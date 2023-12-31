package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import org.springframework.http.ResponseEntity;

public interface DuePaymentsService {
    void createDuePayments(Long clientId, DuePayments duePayments);

    Iterable<DuePayments> getDuePayments();

    Iterable<DuePayments>getDuePaymentsByClientId(Long clientId);

    ResponseEntity deleteDuePayments(Long clientId, Long id);

    ResponseEntity updateDuePayments(Long clientId, Long id, DuePayments duePayments);
}
