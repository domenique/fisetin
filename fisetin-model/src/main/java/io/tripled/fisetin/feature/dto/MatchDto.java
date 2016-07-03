package io.tripled.fisetin.feature.dto;

import java.util.List;

public class MatchDto {

    private String location;
    private List<ArgumentDto> arguments;

    public String getLocation() {
        return location;
    }

    public List<ArgumentDto> getArguments() {
        return arguments;
    }
}
