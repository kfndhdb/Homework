package services;

import Entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import repository.ChatR;

@Service
public class ChatLogic {
    @Autowired
    private ChatR chat;
    public Page<Chat> getChats(){
        return chat.findAll();
    }
}
