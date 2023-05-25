package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.SchedulePaymentReminders;
import org.springframework.http.ResponseEntity;

public interface SchedulePaymentRemindersService {
    void createSchedulePaymentReminders(SchedulePaymentReminders schedulePaymentReminders);

    Iterable<SchedulePaymentReminders> getSchedulePaymentReminders();

    ResponseEntity deleteSchedulePaymentReminders(Long id);

    ResponseEntity updateSchedulePaymentReminders(Long id, SchedulePaymentReminders schedulePaymentReminders);
}
