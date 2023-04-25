package serviceBD;

import Entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ChatR;

import java.util.List;

@Service
public class ChatLogic {
    @Autowired
    private ChatR chatRepository;
    public List<Chat> getChats(){

        return chatRepository.findAll();
    }
}