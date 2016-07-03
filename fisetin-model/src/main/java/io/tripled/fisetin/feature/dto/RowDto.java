package io.tripled.fisetin.feature.dto;

import java.util.List;

public class RowDto {

    private List<String> cells;
    private String line;

    public List<String> getCells() {
        return cells;
    }

    public String getLine() {
        return line;
    }
}
