package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.SchedulePaymentReminders;
import com.capstone.kuhako.repositories.ClientModuleRepository.SchedulePaymentRemindersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SchedulePaymentRemindersServiceImpl {
    @Autowired
    private SchedulePaymentRemindersRepository schedulePaymentRemindersRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createSchedulePaymentReminders(SchedulePaymentReminders schedulePaymentReminders){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        SchedulePaymentReminders newSchedulePaymentReminders = new SchedulePaymentReminders();
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

//        SchedulePaymentReminders schedulePaymentRemindersForDeleting = schedulePaymentRemindersRepository.findById(id).get();
//        String schedulePaymentRemindersName = schedulePaymentRemindersForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(schedulePaymentRemindersName)){
//            schedulePaymentRemindersRepository.deleteById(id);
//            return new ResponseEntity<>("SchedulePaymentReminders Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this SchedulePaymentReminders",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateSchedulePaymentReminders(Long id, SchedulePaymentReminders schedulePaymentReminders){
        SchedulePaymentReminders schedulePaymentRemindersForUpdate = schedulePaymentRemindersRepository.findById(id).get();

        schedulePaymentRemindersForUpdate.setPaymentDues(schedulePaymentReminders.getPaymentDues());
        schedulePaymentRemindersForUpdate.setCollectionDate(schedulePaymentReminders.getCollectionDate());
        schedulePaymentRemindersForUpdate.setProductTypeID(schedulePaymentReminders.getProductTypeID());
        schedulePaymentRemindersForUpdate.setReminderTitle(schedulePaymentReminders.getReminderTitle());
        schedulePaymentRemindersForUpdate.setReminderDate(schedulePaymentReminders.getReminderDate());

        schedulePaymentRemindersRepository.save(schedulePaymentRemindersForUpdate);

        return new ResponseEntity("SchedulePaymentReminders updated successfully", HttpStatus.OK);

//        SchedulePaymentReminders schedulePaymentRemindersForUpdating = schedulePaymentRemindersRepository.findById(id).get();
//        String schedulePaymentRemindersName = schedulePaymentRemindersForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(schedulePaymentRemindersName)){
//            schedulePaymentRemindersForUpdating.setName(schedulePaymentReminders.getName());
//            schedulePaymentRemindersForUpdating.setDescription(schedulePaymentReminders.getDescription());
//            schedulePaymentRemindersForUpdating.setPrice(schedulePaymentReminders.getPrice());
//
//            schedulePaymentRemindersRepository.save(schedulePaymentRemindersForUpdating);
//            return  new ResponseEntity("SchedulePaymentReminders has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this SchedulePaymentReminders.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
