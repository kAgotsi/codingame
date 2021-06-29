package com.atos.airfrance.codingame.controllers;

import com.atos.airfrance.codingame.entities.User;
import com.atos.airfrance.codingame.services.SequenceGeneratorService;
import com.atos.airfrance.codingame.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * <pre>
 * Title: UserControllerTest class
 * Description: Test for USerController.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
     MockMvc mockMvc;
    @MockBean
     UserService userService;
    @MockBean
     SequenceGeneratorService generatorService;
    private User mockUser =  User.builder().id(1L).lastName("DUPONT").firstName("Alex").email("dupont@gmail.com").password("password").age(20).gender('M').build();

    /**
     * Test application return details for given user
     * @throws Exception
     */
    @Test
    public void testGetUserDetails() throws Exception {
        when(userService.getUser(mockUser.getId())).thenReturn(mockUser);
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.body.firstName", is("Alex")))
        .andDo(print());

    }


}
