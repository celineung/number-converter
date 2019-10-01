package com.example.converter.services;

import com.example.converter.exceptions.BigNumberException;
import com.example.converter.exceptions.NegativeNumberException;
import com.example.converter.helpers.ConverterHelper;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    private static final int MAX_NUMBER_LENGTH = 6;

    public String convert(int number) {
        throwsExceptionIfNegativeNumber(number);
        throwsExceptionIfNumberTooBig(number);

        return convertNumberLessThanTwenty(number)
                + convertNumberLessThanAHundred(number);
    }

    private void throwsExceptionIfNegativeNumber(int number) {
        if(number < 0) {
            throw new NegativeNumberException();
        }
    }

    private void throwsExceptionIfNumberTooBig(int number) {
        if(String.valueOf(number).length() > MAX_NUMBER_LENGTH) {
            throw new BigNumberException();
        }
    }

    private String convertNumberLessThanTwenty(int number) {
        if(number < 20) {
            return ConverterHelper.mapUnitToString(number);
        }
        return "";
    }

    private String convertNumberLessThanAHundred(int number) {
        if (number < 100) {
            return ConverterHelper.mapTenMultipleToString(number / 10)
                    + " "
                    + ConverterHelper.mapUnitToString(number % 10);
        }
        return "";
    }

}
