package com.capstone.kuhako.services.JoinModuleServices;

import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.models.JoinModule.ContractsClient;
import com.capstone.kuhako.models.JoinModule.ContractsCollector;
import com.capstone.kuhako.models.JoinModule.ContractsReseller;
import org.springframework.http.ResponseEntity;

public interface ContractsService {
    void createContract(Long resellerId, Contracts contracts);

    Iterable<Contracts> getContracts();

    Iterable<ContractsReseller>getContractsByResellerId(Long resellerId);

    Iterable<ContractsCollector>getContractsByCollectorId(Long resellerId);

    Iterable<ContractsClient>getContractsByClientId(Long resellerId);

    ResponseEntity deleteContract(Long resellerId,Long id);

    ResponseEntity updateContract(Long resellerId ,Long id, Contracts contracts);
}