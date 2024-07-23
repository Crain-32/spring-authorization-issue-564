package dev.crain.resource.inner;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/resource")
public class Controller {

    @GetMapping
    public String getUsername(Authentication authentication) {
        return authentication.getName();
    }
}
