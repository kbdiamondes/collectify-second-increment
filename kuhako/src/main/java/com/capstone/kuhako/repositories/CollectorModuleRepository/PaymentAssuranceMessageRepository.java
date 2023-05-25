package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.PaymentAssuranceMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAssuranceMessageRepository extends CrudRepository<PaymentAssuranceMessage,Object> {
}
