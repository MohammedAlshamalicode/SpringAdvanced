package be.vdab.restclient;

import fictief.NieuweUser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;


public interface Requests {

    @GetExchange("{id}")
    UserResponse findById(@PathVariable long id);

    @GetExchange
    UserResponse[] findAll();

    @PostExchange(contentType = MediaType.APPLICATION_JSON_VALUE)
    void post(@RequestBody NieuweUser nieuweUser);

}
