package repository;
import Entity.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

public interface LinkR extends Repository<Link, Long> {
    Page<Link> findAll();
}
