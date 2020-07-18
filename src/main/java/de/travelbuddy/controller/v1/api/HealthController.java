package de.travelbuddy.controller.v1.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HealthController {

    protected static final String HEALTH_RESPONSE = "Yep, I'am here!";

    @GetMapping("/health")
    public String areYouAlive() {
        return HEALTH_RESPONSE;
    }

}
