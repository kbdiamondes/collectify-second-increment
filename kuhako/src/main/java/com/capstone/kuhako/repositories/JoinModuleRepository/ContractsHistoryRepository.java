package com.capstone.kuhako.repositories.JoinModuleRepository;

import com.capstone.kuhako.models.JoinModule.ContractsHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsHistoryRepository extends CrudRepository<ContractsHistory,Object> {

}
