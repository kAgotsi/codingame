package com.atos.airfrance.codingame.services;

import com.atos.airfrance.codingame.exceptions.RecordNotFoundException;
import com.atos.airfrance.codingame.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * <pre>
 * Title: UserServiceTest class
 * Description: Test for USerService.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private User existingUser =  User.builder().id(1L).lastName("DUPONT").firstName("Alex").email("dupont@gmail.com").password("password").age(20).gender('M').build();

    /**
     * Test id for not existing user
     */
    @Test
    void testFindByIdNotExistingUser () {
        Long id = 134L;
        User expected = null;
        UserService mock = org.mockito.Mockito.mock(UserService.class);
        when(mock.getUser(id)).thenReturn(null);
        assertThrows(RecordNotFoundException.class, () -> userService.getUser(id)
        );
    }

    /**
     * Test serach id for existing user
     */
    @Test
    void tesFindByIdExistingUser () {
        UserService mock = org.mockito.Mockito.mock(UserService.class);
        when(mock.getUser(1L)).thenReturn(existingUser);
        User found = userService.getUser(existingUser.getId());
        assertThat(found.getId())
                .isEqualTo(existingUser.getId());
    }

    /**
     * Test persist user
     */
    @Test
    void testSaveUser () {
        UserService mock = org.mockito.Mockito.mock(UserService.class);
        when(mock.getUser(1L)).thenReturn(existingUser);
        User savedUser = userService.saveUser(existingUser);
        assertThat(savedUser.getId())
                .isEqualTo(existingUser.getId());
    }


}
