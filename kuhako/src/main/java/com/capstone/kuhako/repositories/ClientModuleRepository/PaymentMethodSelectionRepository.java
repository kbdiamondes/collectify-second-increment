package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.PaymentMethodSelection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodSelectionRepository extends CrudRepository<PaymentMethodSelection,Object> {
}
