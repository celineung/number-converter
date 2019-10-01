package com.example.converter.controllers;

import com.example.converter.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @Autowired
    private ConverterService converterService;

    @RequestMapping("/")
    public void convert() {
        int number = 123;
        converterService.convert(number);
    }
}
