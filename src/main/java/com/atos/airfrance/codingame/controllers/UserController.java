package com.atos.airfrance.codingame.controllers;

import com.atos.airfrance.codingame.utils.ResponseDTO;
import com.atos.airfrance.codingame.entities.User;
import com.atos.airfrance.codingame.services.SequenceGeneratorService;
import com.atos.airfrance.codingame.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <pre>
 * Title: UserController class
 * Description: Controller for user.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@RestController
@Validated
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    /**
     * Search user with given id
     * @param id  user id
     * @return a user from database
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> get(@PathVariable  Long id) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(userService.getUser(id)).build();
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * Persist a new user
     * @param lastName lastName ,not null, must respect case ex : DUPON
     * @param firstName firstName ,not null, must respect case ex: ALex
     * @param email email , not null
     * @param password password, can be blank, default password is provided
     * @param age must be > 18
     * @param gender can be null, default  value is provided
     * @param country, transient value, must be France citizen, must be one of these value ex : France, FRANCE, france
     * @return new user created
     */
    @PostMapping("/")
    public ResponseEntity<User> add(@RequestParam(value="lastName") @Pattern(regexp = "^[A-Z][a-zA-Z0-9]+$",message = "Last name is not valid ex : DUPONT") @NotBlank String lastName,
                                      @RequestParam(value="firstName") @Pattern(regexp = "^[A-Z][a-zA-Z0-9]+$", message = "First name is not valid ex: Axel") @NotBlank String firstName,
                                      @RequestParam(value="email") @Email(message = "Email address is not valid") @NotBlank String email,
                                      @RequestParam(value="password", defaultValue="password") String password,
                                      @RequestParam(value="age") @Min(value = 19, message = "This site is for adults only, you must be over 18 to register.") int age,
                                      @RequestParam(value="gender", defaultValue="M") char gender,
                                      @RequestParam(value="country")  @Pattern(regexp = "^France|FRANCE|france+$",message = "This site is only for French people and residents of France.") @NotBlank String country
                                    ) {
        User user =  User.builder().lastName(lastName).firstName(firstName).email(email).password(password).age(age).gender(gender).build();
        user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
}
