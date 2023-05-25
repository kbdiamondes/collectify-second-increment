package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PayDues;
import org.springframework.http.ResponseEntity;

public interface PayDuesService {
    void createPayDueService(PayDues payDues);

    Iterable<PayDues> getPayDueService();

    ResponseEntity deletePayDueService(Long id);

    ResponseEntity updatePayDueService(Long id, PayDues payDues);
}
