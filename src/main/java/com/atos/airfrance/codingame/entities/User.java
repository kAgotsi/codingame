package com.atos.airfrance.codingame.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * <pre>
 * Title: User class
 * Description: POJO to illustrate user who will be save on MongoDb
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@Data
@Builder
@Document(collection = "users")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private  String email;
    private String password;
    private  int age;
    private  char gender;
}
