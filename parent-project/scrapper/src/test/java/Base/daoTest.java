package Base;



import dao.ChatDao;
import dao.LinkDao;
import controllerBD.jdbcChat;
import controllerBD.jdbcLink;
import Entity.Chat;
import Entity.Link;
import jakarta.transaction.Transactional;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class daoTest {
    @Autowired
    JdbcTemplate template = new JdbcTemplate();
    @Autowired
    private jdbcLink jdbcLinkRepository;
    @Autowired
    private jdbcChat jdbcChatRepository;
    @Autowired
    private LinkDao linkRepository;
    @Autowired
    private ChatDao chatRepository;
    @Transactional
    @Rollback
    void addJdbcLinkTest() {

        Link newLink = new Link();
        newLink.setId(0);
        newLink.setChat_id(0);
        newLink.setLink_url("asda");
        jdbcLinkRepository.addLink(newLink.getChatId(),template,newLink);
        Assert.assertTrue(jdbcLinkRepository.getCertainLinks(template,0).get(0).equals(newLink));
    }

    @Transactional
    @Rollback
    void removeJdbcLinkTest() {
        Link newLink = new Link();
        newLink.setId(0);
        newLink.setChat_id(0);
        newLink.setLink_url("asda");
        jdbcLinkRepository.addLink(newLink.getChatId(),template,newLink);
        jdbcLinkRepository.deleteLink(newLink,template);
        Assert.assertNull(jdbcLinkRepository.getCertainLinks(template,0).get(0));
    }
    @Transactional
    @Rollback
    void addJdbcChatTest() {
        Chat newChat = new Chat();
        newChat.setId(0);
        newChat.setChat_id(0);
        jdbcChatRepository.addChat(0,template,newChat);
        Assert.assertTrue(jdbcChatRepository.getAllChats(template).get(0).equals(newChat));
    }

    @Transactional
    @Rollback
    void removeJdbcChatTest() {
        Chat newChat = new Chat();
        newChat.setId(0);
        newChat.setChat_id(0);
        jdbcChatRepository.addChat(0,template,newChat);
        jdbcChatRepository.deleteChat(newChat,template);
        Assert.assertNull(jdbcChatRepository.getAllChats(template).get(0));
    }


    @Transactional
    @Rollback
    void addLinkTest() {
        Link newLink = new Link();
        newLink.setId(0);
        newLink.setChat_id(0);
        newLink.setLink_url("asda");
        linkRepository.save(newLink);
        Assert.assertTrue(linkRepository.get(0).equals(newLink));
    }

    @Transactional
    @Rollback
    void removeLinkTest() {
        Link newLink = new Link();
        newLink.setId(0);
        newLink.setChat_id(0);
        newLink.setLink_url("asda");
        linkRepository.save(newLink);
        linkRepository.delete(newLink);
        Assert.assertNull(linkRepository.get(0));
    }
    @Transactional
    @Rollback
    void addChatTest() {
        Chat newChat = new Chat();
        newChat.setId(0);
        newChat.setChat_id(0);
        chatRepository.save(newChat);
        Assert.assertTrue(chatRepository.get(0).equals(newChat));
    }

    @Transactional
    @Rollback
    void removeChatTest() {
        Chat newChat = new Chat();
        newChat.setId(0);
        newChat.setChat_id(0);
        chatRepository.save(newChat);
        chatRepository.delete(newChat);
        Assert.assertNull(chatRepository.get(0));
    }
}

