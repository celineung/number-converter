package com.example.converter.services;

import com.example.converter.exceptions.BigNumberException;
import com.example.converter.exceptions.NegativeNumberException;
import com.example.converter.helpers.ConverterHelper;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    private static final int MAX_NUMBER = 99999;

    public String convert(int number) {
        throwsExceptionIfNegativeNumber(number);
        throwsExceptionIfNumberTooBig(number);

        return convertIntoWords(number);
    }

    private String convertIntoWords(int number) {
        return convertNumberLessThanTwenty(number)
                + convertNumberBetweenTwentyAndAHundred(number)
                + convertNumberBetweenAHundredAndAThousand(number)
                + convertNumberGreaterThanAHundred(number);
    }

    private void throwsExceptionIfNegativeNumber(int number) {
        if(number < 0) {
            throw new NegativeNumberException();
        }
    }

    private void throwsExceptionIfNumberTooBig(int number) {
        if(number > MAX_NUMBER) {
            throw new BigNumberException();
        }
    }

    private String convertNumberLessThanTwenty(int number) {
        if(number < 20) {
            return ConverterHelper.mapUnitToString(number);
        }
        return "";
    }

    private String convertNumberBetweenTwentyAndAHundred(int number) {
        if (number >= 20 && number < 100) {
            return ConverterHelper.mapTenMultipleToString(number / 10)
                    + ((number % 10 != 0) ? " " : "")
                    + ConverterHelper.mapUnitToString(number % 10);
        }
        return "";
    }

    private String convertNumberBetweenAHundredAndAThousand(int number) {
        if (number >= 100 && number < 1000) {
            return ConverterHelper.mapUnitToString(number / 100)
                    + " hundred"
                    + ((number % 100 != 0) ? " " : "")
                    + convertIntoWords(number % 100);
        }
        return "";
    }

    private String convertNumberGreaterThanAHundred(int number) {
        if (number >= 1000) {
            return convertIntoWords(number / 1000)
                    + " thousand"
                    + ((number % 1000 != 0) ? " " : "")
                    + convertIntoWords(number % 1000);
        }
        return "";
    }

}
