package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.SchedulePaymentReminders;
import com.capstone.kuhako.services.ClientModuleServices.SchedulePaymentRemindersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/clientPage")
public class SchedulePaymentRemindersController {
    @Autowired
    SchedulePaymentRemindersService schedulePaymentRemindersService;

    @RequestMapping(value="/schedulePaymentReminders", method = RequestMethod.POST)
    public ResponseEntity<Object> createSchedulePaymentReminders(@RequestBody SchedulePaymentReminders schedulePaymentReminders) {
        schedulePaymentRemindersService.createSchedulePaymentReminders(schedulePaymentReminders);
        return new ResponseEntity<>("SchedulePaymentReminders created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/schedulePaymentReminders", method = RequestMethod.GET)
    public ResponseEntity<Object> getSchedulePaymentReminders() {
        return new ResponseEntity<>(schedulePaymentRemindersService.getSchedulePaymentReminders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/schedulePaymentReminders/{schedulePaymentRemindersid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSchedulePaymentReminders(@PathVariable Long schedulePaymentRemindersid) {
        return schedulePaymentRemindersService.deleteSchedulePaymentReminders(schedulePaymentRemindersid);
    }

    @RequestMapping(value="/schedulePaymentReminders/{schedulePaymentRemindersid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSchedulePaymentReminders(@PathVariable Long schedulePaymentRemindersid, @RequestBody SchedulePaymentReminders schedulePaymentReminders) {
        return schedulePaymentRemindersService.updateSchedulePaymentReminders(schedulePaymentRemindersid, schedulePaymentReminders);
    }
}