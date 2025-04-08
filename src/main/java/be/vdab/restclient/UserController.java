package be.vdab.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
class UserController {
    private final UserClient userClient;
    UserController(UserClient userClient) {
        this.userClient = userClient;
    }
    @GetMapping("{id}")
    User findById(@PathVariable long id) {
        return userClient.findById(id).orElseThrow(UserNietGevondenException::new);
    }

    @GetMapping
    List<User> findAll() {
        return userClient.findAll();
    }
}