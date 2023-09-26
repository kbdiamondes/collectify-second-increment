package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.models.ClientModules.SchedulePaymentReminders;
import com.capstone.kuhako.repositories.ClientModuleRepository.SchedulePaymentRemindersRepository;
import com.capstone.kuhako.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SchedulePaymentRemindersServiceImpl implements SchedulePaymentRemindersService {
    @Autowired
    private SchedulePaymentRemindersRepository schedulePaymentRemindersRepository;

    @Autowired
    private ClientRepository clientRepository;
    
    public void createSchedulePaymentReminders(Long clientId,SchedulePaymentReminders schedulePaymentReminders){
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client != null) {
            schedulePaymentReminders.setClient(client);
            schedulePaymentRemindersRepository.save(schedulePaymentReminders);
        }
    }
    public Iterable<SchedulePaymentReminders> getSchedulePaymentReminders(){
        return schedulePaymentRemindersRepository.findAll();
    }

    public Iterable<SchedulePaymentReminders> getSchedulePaymentRemindersByClientId(Long clientId) {
        return schedulePaymentRemindersRepository.findSchedulePaymentRemindersByClientId(clientId);
    }
    
    public ResponseEntity deleteSchedulePaymentReminders(Long clientId,Long id){
        SchedulePaymentReminders schedulePaymentRemindersToDelete = schedulePaymentRemindersRepository.findById(id).orElse(null);

        if (schedulePaymentRemindersToDelete != null && schedulePaymentRemindersToDelete.getClient().getClient_id().equals(clientId)) {
            schedulePaymentRemindersRepository.deleteById(id);
            return new ResponseEntity<>("Schedule Payment Reminders Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Schedule Payment Reminders not found or does not belong to the specified client", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity updateSchedulePaymentReminders(Long clientId,Long id, SchedulePaymentReminders schedulePaymentReminders){
        SchedulePaymentReminders schedulePaymentRemindersForUpdate = schedulePaymentRemindersRepository.findById(id).orElse(null);
        if (schedulePaymentRemindersForUpdate != null && schedulePaymentRemindersForUpdate.getClient().getClient_id().equals(clientId)) {
            schedulePaymentRemindersForUpdate.setCollectionDate(schedulePaymentReminders.getCollectionDate());
            schedulePaymentRemindersForUpdate.setProductTypeID(schedulePaymentReminders.getProductTypeID());
            schedulePaymentRemindersForUpdate.setReminderTitle(schedulePaymentReminders.getReminderTitle());
            schedulePaymentRemindersForUpdate.setReminderDate(schedulePaymentReminders.getReminderDate());
            schedulePaymentRemindersRepository.save(schedulePaymentRemindersForUpdate);
            return new ResponseEntity<>("SchedulePaymentReminders  Updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Schedule Payment Reminders  not found",HttpStatus.NOT_FOUND);
    }
}



