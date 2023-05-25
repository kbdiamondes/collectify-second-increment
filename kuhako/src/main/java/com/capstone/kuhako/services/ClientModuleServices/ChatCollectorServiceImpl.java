package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.ChatCollector;
import com.capstone.kuhako.repositories.ClientModuleRepository.ChatCollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChatCollectorServiceImpl {
    @Autowired
    private ChatCollectorRepository chatCollectorRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createChatCollector(ChatCollector chatCollector){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        ChatCollector newChatCollector = new ChatCollector();
        newChatCollector.setPaymentAssurance(chatCollector.getPaymentAssurance());
        newChatCollector.setClientMessage(chatCollector.getClientMessage());
        chatCollectorRepository.save(newChatCollector);
    }
    public Iterable<ChatCollector> getChatCollector(){
        return chatCollectorRepository.findAll();
    }

    public ResponseEntity deleteChatCollector(Long id){
        chatCollectorRepository.deleteById(id);
        return new ResponseEntity<>("ChatCollector Deleted successfully", HttpStatus.OK);

//        ChatCollector chatCollectorForDeleting = chatCollectorRepository.findById(id).get();
//        String chatCollectorName = chatCollectorForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(chatCollectorName)){
//            chatCollectorRepository.deleteById(id);
//            return new ResponseEntity<>("ChatCollector Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this ChatCollector",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateChatCollector(Long id, ChatCollector chatCollector){
        ChatCollector chatCollectorForUpdate = chatCollectorRepository.findById(id).get();

        chatCollectorForUpdate.setPaymentAssurance(chatCollector.getPaymentAssurance());
        chatCollectorForUpdate.setClientMessage(chatCollector.getClientMessage());

        chatCollectorRepository.save(chatCollectorForUpdate);

        return new ResponseEntity("ChatCollector updated successfully", HttpStatus.OK);

//        ChatCollector chatCollectorForUpdating = chatCollectorRepository.findById(id).get();
//        String chatCollectorName = chatCollectorForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(chatCollectorName)){
//            chatCollectorForUpdating.setName(chatCollector.getName());
//            chatCollectorForUpdating.setDescription(chatCollector.getDescription());
//            chatCollectorForUpdating.setPrice(chatCollector.getPrice());
//
//            chatCollectorRepository.save(chatCollectorForUpdating);
//            return  new ResponseEntity("ChatCollector has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this ChatCollector.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
