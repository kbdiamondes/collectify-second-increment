package com.capstone.kuhako.repositories.JoinModuleRepository;

import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.models.JoinModule.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends CrudRepository<Transactions,Object> {
    List<Transactions> findByContracts(Contracts contracts);
}
