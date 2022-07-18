package com.corp.api.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class IdentityDocumentUtils {

    public String format(String s) {
        final String[] splited = s.split("");
        final String TEMPLATE = "%s.%s.%s-%s";

        String firstThreeDigits = stream(splited, 0, 3);

        String secondThreeDigits = stream(splited, 3, 3);

        String thirdThreeDigits = stream(splited, 6, 3);

        String lastTwoDigits = stream(splited, 9, 2);

        return String.format(TEMPLATE, firstThreeDigits, secondThreeDigits, thirdThreeDigits, lastTwoDigits);
    }

    private String stream(String[] splited, int skip, int limit) {
        return Arrays.stream(splited)
                .skip(skip)
                .limit(limit)
                .collect(Collectors.joining());
    }
}
