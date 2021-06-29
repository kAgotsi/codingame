package com.atos.airfrance.codingame.services;

import com.atos.airfrance.codingame.exceptions.RecordNotFoundException;
import com.atos.airfrance.codingame.entities.User;
import com.atos.airfrance.codingame.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

/**
 * <pre>
 * Title: UserService class
 * Description: Handle business logics.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     *  Persist user in database
     * @param user given user
     * @return a created user
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Get user from database
     * @param id user id
     * @return a user in database
     */
    public User getUser(Long id) {
        try {
            return userRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new RecordNotFoundException("No record found");
        }
    }
}
