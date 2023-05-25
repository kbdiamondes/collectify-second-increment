package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.SchedulePaymentReminders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulePaymentRemindersRepository extends CrudRepository<SchedulePaymentReminders,Object> {
}
