package dz.sundev.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    /*@Autowired
    UserDTORepository userDTORepository;

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @RequestMapping(value = "/getUserByUserName", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(
            @RequestParam(value = "username", required = false, defaultValue = "Jack") String userName) {
        return new ResponseEntity<>(
//                userRepository.findByUserName(userName),
                userRepository.findByUserName(userName),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserDTOByUserName", method = RequestMethod.GET)
    public UserDTO getUserDTO(
            @RequestParam(value = "username", required = false, defaultValue = "Jack") String userName) {
        UserDTO userDTO = modelMapper.map(userRepository.findByUserName(userName).get(), UserDTO.class);
        return userDTO;
    }

    @RequestMapping(value = "/getUsersDTO", method = RequestMethod.GET)
    public List<UserDTO> getUsersDTO() {
        *//*return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());*//*

        *//*return modelMapper.map(userRepository.findAll(), new TypeToken<List<UserDTO>>() {}.getType());*//*

        return userRepository.findAllUserDTOs();
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>(
                userRepository.findAll(),
                HttpStatus.OK);
    }*/
}
