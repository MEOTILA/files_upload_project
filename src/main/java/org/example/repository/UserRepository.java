package org.example.repository;

import org.example.entity.User;
import org.hibernate.Session;

import java.util.Optional;

public class UserRepository {

    public User save(Session session, User user){
        session.persist(user);
        return user;
    }

    public Optional<User> findById (Session session, Long id){
        return session.byId(User.class).loadOptional(id);
    }

    public int deleteById(Session session, Long id){
        return session.createMutationQuery("DELETE FROM User WHERE id = :id")
                .setParameter("id",id)
                .executeUpdate();
    }


}
