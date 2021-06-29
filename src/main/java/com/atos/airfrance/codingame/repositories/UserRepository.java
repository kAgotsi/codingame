package com.atos.airfrance.codingame.repositories;

import com.atos.airfrance.codingame.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <pre>
 * Title: UserRepository class
 * Description: User repository for data access.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
public interface UserRepository extends MongoRepository<User,Long> {
}
