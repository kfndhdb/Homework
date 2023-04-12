package app;

import services.ChatLogic;
import services.LinkLogic;
import Entity.Chat;
import Entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scrapper")
public class ScrapperDataBC {
    @Autowired
    ChatLogic chatLogic;
    @Autowired
    LinkLogic linkLogic;
    @GetMapping("/chats")
    @ResponseBody
    public Page<Chat> chats(){
        return chatLogic.getChats();
    }
    @GetMapping("/links")
    @ResponseBody
    public Page<Link> links(){
        return linkLogic.getLinks();
    }

}
