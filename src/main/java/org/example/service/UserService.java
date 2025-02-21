package org.example.service;

import org.example.config.SessionFactoryInstance;
import org.example.entity.User;
import org.example.repository.UserRepository;

import java.util.Optional;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User save (User user){
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                userRepository.save(session, user);
                session.getTransaction().commit();
                return user;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    public Optional<User> findById(Long id) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Optional<User> optionalEntity = userRepository.findById(session, id);
                User foundedEntity = optionalEntity
                        .orElseThrow(() -> new RuntimeException());
                return optionalEntity;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void delete(Long id) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                int affectedRows = userRepository.deleteById(session, id);
                if (affectedRows == 0)
                    throw new RuntimeException();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

}
