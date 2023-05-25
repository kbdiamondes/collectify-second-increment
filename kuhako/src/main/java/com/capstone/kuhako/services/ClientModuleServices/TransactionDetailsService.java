package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.TransactionDetails;
import org.springframework.http.ResponseEntity;

public interface TransactionDetailsService {
    void createTransactionDetails(TransactionDetails transactionDetails);

    Iterable<TransactionDetails> getTransactionDetails();

    ResponseEntity deleteTransactionDetails(Long id);

    ResponseEntity updateTransactionDetails(Long id, TransactionDetails transactionDetails);
}
