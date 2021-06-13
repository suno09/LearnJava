package dz.sundev.controller;

import dz.sundev.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/")
@RestController
@CrossOrigin
public class MailController {

    @Autowired
    MailService mailService;

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public Object sendEmailMessage() {
        return mailService.sendMail("sabrina.houas66@gmail.com");
    }
}