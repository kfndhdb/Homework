package app;

import Entity.Chat;
import Entity.Link;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import serviceBD.ChatLogic;
import serviceBD.LinkLogic;

@RestController
@RequestMapping("/scrapper")
public class ScrapperDataBaseController {

    ChatLogic chatLogic;

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
