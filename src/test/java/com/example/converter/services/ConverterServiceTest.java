package com.example.converter.services;

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

    @Test(expected = RuntimeException.class)
    public void shouldReturnErrorWhenNegativeNumber() {
        converterService.convert(-90);
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnErrorWhenNumberMoreThanSixChar() {
        converterService.convert(1000000);
    }

    @Test
    public void shouldReturnCorrectNumberWhenSingleChar() {
        String nbStr = converterService.convert(3);
        assertTrue(nbStr.equals("3"));
    }

    @Test
    public void shouldReturnCorrectNumberWhenTwoChar() {
        String nbStr = converterService.convert(26);
        assertTrue(nbStr.equals("twenty six"));
    }

    @Test
    public void shouldReturnCorrectNumberWhenThreeChar() {
        String nbStr = converterService.convert(750);
        assertTrue(nbStr.equals("seven hundred fixty"));
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
    public void shouldReturnCorrectNumberWhenSixChar() {
        String nbStr = converterService.convert(820976);
        assertTrue(nbStr.equals("height hundred twenty thousand nine hundred seventy six"));
    }

}
