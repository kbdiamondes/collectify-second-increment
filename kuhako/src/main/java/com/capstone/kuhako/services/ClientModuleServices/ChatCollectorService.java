package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.ChatCollector;
import org.springframework.http.ResponseEntity;

public interface ChatCollectorService {
    void createChatCollector(Long clientId,ChatCollector chatCollector);
    Iterable<ChatCollector> getChatCollector();
    Iterable<ChatCollector> getChatCollectorByClientId(Long clientId);

    ResponseEntity deleteChatCollector(Long clientId,Long id);

    ResponseEntity updateChatCollector(Long clientId,Long id, ChatCollector chatCollector);
}
