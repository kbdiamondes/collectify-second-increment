package com.capstone.kuhako.repositories.JoinModuleRepository;

import com.capstone.kuhako.models.JoinModule.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends CrudRepository<Transactions,Object> {
}
