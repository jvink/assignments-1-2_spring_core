package com.jvink.assignments12_spring_core.controllers;

import com.jvink.assignments12_spring_core.models.StringDTO;
import com.jvink.assignments12_spring_core.services.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StringController {
    private StringService stringService;
 
    @Autowired
    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @PostMapping
    @RequestMapping("reverseString")
    public @ResponseBody String reverseString(@RequestBody String name) {
        return stringService.reverseString(name);
    }

    @PostMapping
    @RequestMapping("encapsulateString")
    public @ResponseBody String encapsulateString(@RequestBody String name) {
        return stringService.encapsulateString(name);
    }

    @PostMapping
    @RequestMapping("countCharacters")
    public @ResponseBody Number countCharacters(@RequestBody String name) {
        return stringService.countCharacters(name);
    }

    @RequestMapping("all")
    public @ResponseBody List<StringDTO> getStrings() {
        return stringService.getAllStrings();
    }
}
