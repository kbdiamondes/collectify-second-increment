package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.SchedulePaymentReminders;
import com.capstone.kuhako.repositories.ClientModuleRepository.SchedulePaymentRemindersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SchedulePaymentRemindersServiceImpl implements SchedulePaymentRemindersService {
    @Autowired
    private SchedulePaymentRemindersRepository schedulePaymentRemindersRepository;

    public void createSchedulePaymentReminders(SchedulePaymentReminders schedulePaymentReminders){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        SchedulePaymentReminders newSchedulePaymentReminders = new SchedulePaymentReminders();
        newSchedulePaymentReminders.setClient(schedulePaymentReminders.getClient());
        newSchedulePaymentReminders.setPaymentDues(schedulePaymentReminders.getPaymentDues());
        newSchedulePaymentReminders.setCollectionDate(schedulePaymentReminders.getCollectionDate());
        newSchedulePaymentReminders.setProductTypeID(schedulePaymentReminders.getProductTypeID());
        newSchedulePaymentReminders.setReminderTitle(schedulePaymentReminders.getReminderTitle());
        newSchedulePaymentReminders.setReminderDate(schedulePaymentReminders.getReminderDate());
        schedulePaymentRemindersRepository.save(newSchedulePaymentReminders);
    }
    public Iterable<SchedulePaymentReminders> getSchedulePaymentReminders(){
        return schedulePaymentRemindersRepository.findAll();
    }

    public ResponseEntity deleteSchedulePaymentReminders(Long id){
        schedulePaymentRemindersRepository.deleteById(id);
        return new ResponseEntity<>("SchedulePaymentReminders Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateSchedulePaymentReminders(Long id, SchedulePaymentReminders schedulePaymentReminders){
        SchedulePaymentReminders schedulePaymentRemindersForUpdate = schedulePaymentRemindersRepository.findById(id).get();
        schedulePaymentRemindersForUpdate.setClient(schedulePaymentReminders.getClient());
        schedulePaymentRemindersForUpdate.setPaymentDues(schedulePaymentReminders.getPaymentDues());
        schedulePaymentRemindersForUpdate.setCollectionDate(schedulePaymentReminders.getCollectionDate());
        schedulePaymentRemindersForUpdate.setProductTypeID(schedulePaymentReminders.getProductTypeID());
        schedulePaymentRemindersForUpdate.setReminderTitle(schedulePaymentReminders.getReminderTitle());
        schedulePaymentRemindersForUpdate.setReminderDate(schedulePaymentReminders.getReminderDate());
        schedulePaymentRemindersRepository.save(schedulePaymentRemindersForUpdate);
        return new ResponseEntity("SchedulePaymentReminders updated successfully", HttpStatus.OK);
    }
}
