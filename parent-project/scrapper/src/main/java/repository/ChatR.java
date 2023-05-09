package repository;

import Entity.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;
public interface ChatR extends Repository<Chat, Long> {
    Page<Chat> findAll();

}