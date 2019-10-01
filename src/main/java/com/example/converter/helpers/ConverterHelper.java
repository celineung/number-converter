package com.example.converter.helpers;


public class ConverterHelper {

    private static final String[] units = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static final String[] ten_multiple = {
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    public static final String mapUnitToString(int number) {
        return units[number];
    }

    public static final String mapTenMultipleToString(int number) {
        return ten_multiple[number];
    }
}
