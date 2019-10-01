package com.example.converter.services;

import com.example.converter.exceptions.BigNumberException;
import com.example.converter.exceptions.NegativeNumberException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ConverterServiceTest {

    @InjectMocks
    private ConverterService converterService;

    @Test(expected = NegativeNumberException.class)
    public void shouldReturnErrorWhenNegativeNumber() {
        converterService.convert(-90);
    }

    @Test(expected = BigNumberException.class)
    public void shouldReturnErrorWhenNumberMoreThanSixChar() {
        converterService.convert(1000000);
    }

    @Test
    public void shouldReturnCorrectNumberWhenSingleChar() {
        String nbStr = converterService.convert(3);
        assertTrue(nbStr.equals("three"));
    }

    @Test
    public void shouldReturnCorrectNumberWhenTwoChar() {
        String nbStr = converterService.convert(96);
        assertTrue(nbStr.equals("ninety six"));
    }

    @Test
    public void shouldReturnCorrectNumberWhenThreeChar() {
        String nbStr = converterService.convert(750);
        assertTrue(nbStr.equals("seven hundred fifty"));
    }

    @Test
    public void shouldReturnCorrectNumberWhenFourChar() {
        String nbStr = converterService.convert(1090);
        assertTrue(nbStr.equals("one thousand ninety"));
    }

    @Test
    public void shouldReturnCorrectNumberWhenFiveChar() {
        String nbStr = converterService.convert(10901);
        assertTrue(nbStr.equals("ten thousand nine hundred one"));
    }

    @Test
    public void shouldReturnCorrectNumberWhenLimit() {
        String nbStr = converterService.convert(99999);
        assertTrue(nbStr.equals("ninety nine thousand nine hundred ninety nine"));
    }

}
