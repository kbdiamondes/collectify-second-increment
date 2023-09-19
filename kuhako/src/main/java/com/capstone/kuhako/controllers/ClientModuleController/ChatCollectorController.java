package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.ChatCollector;
import com.capstone.kuhako.services.ClientModuleServices.ChatCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ChatCollectorController {

    @Autowired
    private ChatCollectorService chatCollectorService;
    @RequestMapping(value="/chatCollector", method = RequestMethod.POST)
    public ResponseEntity<Object> createChatCollector(@RequestBody ChatCollector chatCollector) {
        chatCollectorService.createChatCollector(chatCollector);
        return new ResponseEntity<>("ChatCollector created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/chatCollector", method = RequestMethod.GET)
    public ResponseEntity<Object> getChatCollector() {
        return new ResponseEntity<>(chatCollectorService.getChatCollector(), HttpStatus.OK);
    }

    @RequestMapping(value = "/chatCollector/{chatCollectorid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteChatCollector(@PathVariable Long chatCollectorid) {
        return chatCollectorService.deleteChatCollector(chatCollectorid);
    }
    @RequestMapping(value="/chatCollector/{chatCollectorid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateChatCollector(@PathVariable Long chatCollectorid, @RequestBody ChatCollector chatCollector) {
        return chatCollectorService.updateChatCollector(chatCollectorid, chatCollector);
    }
}
