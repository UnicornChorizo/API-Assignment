package com.csc340f23.worldtimeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WorldTimeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    private final RestTemplate restTemplate = new RestTemplate();


    /**
     * Gets users current IP to return timezone data.
     *
     * @return EST time
     */
    @GetMapping("/current-time")
    public String getCurrentTime() {
        String worldTimeApiUrl = "http://worldtimeapi.org/api/ip";
        return restTemplate.getForObject(worldTimeApiUrl, String.class);
    }

    @GetMapping("/CST")
    public String getESTime() {
        String worldTimeApiUrl = "http://worldtimeapi.org/api/America/Mexico_City";
        return restTemplate.getForObject(worldTimeApiUrl, String.class);
    }

    @GetMapping("/PST")
    public String getPSTime() {
        String worldTimeApiUrl = "http://worldtimeapi.org/api/America/Los_Angeles";
        return restTemplate.getForObject(worldTimeApiUrl, String.class);

    }
}