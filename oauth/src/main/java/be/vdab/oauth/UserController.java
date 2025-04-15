package be.vdab.oauth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {
    private record UserInfo(String login, String name) { }
    @GetMapping("user")
    UserInfo wieBenJe(@AuthenticationPrincipal OAuth2User principal) {
        return new UserInfo(principal.getAttribute("login"),
                principal.getAttribute("name"));

    }
}