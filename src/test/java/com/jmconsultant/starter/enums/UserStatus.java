package com.jmconsultant.starter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum UserStatus {

    ACTIVE("ACT", "active user"),
    BLOCKED("BLO", "blocked user");

    private final String code;
    private final String description;

    public static UserStatus findByDescription(String description) {
        Map<String, UserStatus> byDescription = Arrays.stream(values())
                .collect(
                        Collectors.toMap(
                                element -> element.description,
                                element -> element
                        )
                );

        return byDescription.getOrDefault(description, ACTIVE);
    }
}
