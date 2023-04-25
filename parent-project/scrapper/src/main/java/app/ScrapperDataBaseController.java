package app;

import Entity.Chat;
import Entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import serviceBD.ChatLogic;
import serviceBD.LinkLogic;

import java.util.List;

@RestController
@RequestMapping("/scrapper")
public class ScrapperDataBaseController {
    @Autowired
    ChatLogic chatLogic;
    @Autowired
    LinkLogic linkLogic;
    @GetMapping("/chats")
    @ResponseBody
    public List<Chat> chats(){

        return chatLogic.getChats();
    }
    @GetMapping("/links")
    @ResponseBody
    public List<Link> links(){

        return linkLogic.getLinks();
    }

}