package com.hitema.intro.controllers;


import com.hitema.intro.services.Staff;
import com.hitema.intro.services.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/staff")
public class StaffController {
    private static final Logger log = LoggerFactory.getLogger(StaffController.class);

    StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping(value = "/picture/{id}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getPicture(@PathVariable Long id){
        return service.getPicture(id);
    }

    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable Long id){
        return service.read(id);
    }


}
