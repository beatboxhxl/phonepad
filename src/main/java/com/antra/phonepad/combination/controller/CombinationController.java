package com.antra.phonepad.combination.controller;

import com.antra.phonepad.combination.service.PhonePadService;
import com.antra.phonepad.combination.vo.InputObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CombinationController {

    @Autowired
    PhonePadService phonePadService;

    @RequestMapping(value = "/combination", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public List<String> getCombinations(@RequestBody InputObject inputObj) {
        String input = inputObj.getContent();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                return Arrays.asList("Input should contain only digits or letters.");
            }
        }
        return phonePadService.findAllCombinations(input);
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public List<String> getWords(@RequestBody InputObject inputObj) {
        return phonePadService.findAllEnglishWords(inputObj.getContent());
    }


}
