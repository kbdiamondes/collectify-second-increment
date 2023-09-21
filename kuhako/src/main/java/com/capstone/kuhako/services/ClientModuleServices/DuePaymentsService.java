package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import org.springframework.http.ResponseEntity;

public interface DuePaymentsService {
    void createDuePayments(DuePayments duePayments);

    Iterable<DuePayments> getDuePayments();

    ResponseEntity deleteDuePayments(Long id);

    ResponseEntity updateDuePayments(Long id, DuePayments duePayments);
}
