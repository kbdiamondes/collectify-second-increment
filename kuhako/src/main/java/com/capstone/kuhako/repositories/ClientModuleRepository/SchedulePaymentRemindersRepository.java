package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.models.ClientModules.SchedulePaymentReminders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulePaymentRemindersRepository extends CrudRepository<SchedulePaymentReminders,Object> {

    @Query("SELECT spr FROM SchedulePaymentReminders spr WHERE spr.client.client_id = :clientId")
    Iterable<SchedulePaymentReminders> findSchedulePaymentRemindersByClientId(@Param("clientId") Long clientId);


}
