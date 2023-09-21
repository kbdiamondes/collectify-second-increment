package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.ChatCollector;
import com.capstone.kuhako.repositories.ClientModuleRepository.ChatCollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChatCollectorServiceImpl implements ChatCollectorService{
    @Autowired
    private ChatCollectorRepository chatCollectorRepository;

    //Create ChatCollector
    public void createChatCollector(ChatCollector chatCollector){
      ChatCollector newChatCollector = new ChatCollector();
      newChatCollector.setClient(chatCollector.getClient());
      newChatCollector.setPaymentAssurance(chatCollector.getPaymentAssurance());
      newChatCollector.setClientMessage(chatCollector.getClientMessage());
      chatCollectorRepository.save(newChatCollector);
    }
    // Get All ChatCollector
    public Iterable<ChatCollector> getChatCollector(){
        return chatCollectorRepository.findAll();
    }
    // Delete Chat Collector
    public ResponseEntity deleteChatCollector(Long id){
        chatCollectorRepository.deleteById(id);
        return new ResponseEntity<>("ChatCollector Deleted successfully", HttpStatus.OK);
    }
    // Update
    public ResponseEntity updateChatCollector(Long id, ChatCollector chatCollector){
        ChatCollector chatCollectorForUpdate = chatCollectorRepository.findById(id).get();
        chatCollectorForUpdate.setClient(chatCollector.getClient());
        chatCollectorForUpdate.setPaymentAssurance(chatCollector.getPaymentAssurance());
        chatCollectorForUpdate.setClientMessage(chatCollector.getClientMessage());
        chatCollectorRepository.save(chatCollectorForUpdate);
        return new ResponseEntity("ChatCollector updated successfully", HttpStatus.OK);
    }

}
