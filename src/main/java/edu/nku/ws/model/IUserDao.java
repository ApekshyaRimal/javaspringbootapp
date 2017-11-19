package edu.nku.ws.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserDao extends CrudRepository<User, Long> {

    public Iterable<User> findAll();
    public User findByUserId(int userId);
    public long count();
}
