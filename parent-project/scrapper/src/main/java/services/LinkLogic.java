package services;


import Entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import repository.LinkR;

@Service
public class LinkLogic {
    @Autowired
    private LinkR linkRepository;
    public Page<Link> getLinks(){

        return linkRepository.findAll();
    }
}
