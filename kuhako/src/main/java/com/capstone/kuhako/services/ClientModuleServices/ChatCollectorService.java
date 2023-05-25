package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.ChatCollector;
import org.springframework.http.ResponseEntity;

public interface ChatCollectorService {
    void createChatCollector(ChatCollector chatCollector);

    Iterable<ChatCollector> getChatCollector();

    ResponseEntity deleteChatCollector(Long id);

    ResponseEntity updateChatCollector(Long id, ChatCollector chatCollector);
}
