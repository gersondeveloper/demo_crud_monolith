package exe.badge.backend.controller;

import java.util.List;
import java.util.Optional;


import exe.badge.backend.model.User;
import exe.badge.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("api/users")
    public ResponseEntity<Optional<List<User>>> getUsers() {
        List<User> users = userService.findAll();
        Optional<List<User>> optionalUsers = Optional.of(users);
        return new ResponseEntity<>(optionalUsers, HttpStatus.OK);
    }

    @GetMapping("api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
