package dz.sundev.controllers;

import dz.sundev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/getUserByUserName", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserName(
            @RequestParam(value = "username", required = false, defaultValue = "Jack") String userName) {
        return new ResponseEntity<>(
                userRepository.findByUserName(userName),
                HttpStatus.OK);
    }
}
