package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.PayDues;
import org.springframework.http.ResponseEntity;

public interface PayDuesService {
    void createPayDues(PayDues payDues);

    Iterable<PayDues> getPayDues();

    ResponseEntity deletePayDues(Long id);

    ResponseEntity updatePayDues(Long id, PayDues payDues);
}
