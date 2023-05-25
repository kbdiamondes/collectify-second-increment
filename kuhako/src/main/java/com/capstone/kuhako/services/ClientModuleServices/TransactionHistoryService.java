package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.TransactionHistory;
import org.springframework.http.ResponseEntity;

public interface TransactionHistoryService {
    void createTransactionHistory(TransactionHistory transactionHistory);

    Iterable<TransactionHistory> getTransactionHistory();

    ResponseEntity deleteTransactionHistory(Long id);

    ResponseEntity updateTransactionHistory(Long id, TransactionHistory transactionHistory);
}
