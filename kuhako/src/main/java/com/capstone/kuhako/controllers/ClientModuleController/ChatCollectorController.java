package com.capstone.kuhako.controllers.ClientModuleController;

import com.capstone.kuhako.services.ClientModuleServices.ChatCollectorService;
import com.capstone.kuhako.models.ClientModules.ChatCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/clientPage")
public class ChatCollectorController {

    @Autowired
    ChatCollectorService chatCollectorService;
    @RequestMapping(value="/chatCollector/{clientId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createChatCollector(@PathVariable Long clientId,@RequestBody ChatCollector chatCollector) {
        chatCollectorService.createChatCollector(clientId,chatCollector);
        return new ResponseEntity<>("ChatCollector created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/chatCollector", method = RequestMethod.GET)
    public ResponseEntity<Object> getChatCollector() {
        return new ResponseEntity<>(chatCollectorService.getChatCollector(), HttpStatus.OK);
    }
    @RequestMapping(value="/chatCollector/client/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getChatCollectorByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(chatCollectorService.getChatCollectorByClientId(clientId), HttpStatus.OK);
    }

    @RequestMapping(value = "/chatCollector/{chatCollectorid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteChatCollector(@PathVariable Long clientId,@PathVariable Long chatCollector_id) {
        return chatCollectorService.deleteChatCollector(clientId,chatCollector_id);
    }
    @RequestMapping(value="/chatCollector/{clientId}/{chatCollectorid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateChatCollector(@PathVariable Long clientId,@PathVariable Long chatCollector_id, @RequestBody ChatCollector chatCollector) {
        return chatCollectorService.updateChatCollector(clientId,chatCollector_id, chatCollector);
    }
}