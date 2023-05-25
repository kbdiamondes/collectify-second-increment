package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectAllDuePaymentsRepository extends CrudRepository<CollectAllDuePayments,Object> {
}
