package com.hhstechgroup.ui.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface KeyValueMapper {

    Map<String, String> getMappedValues();

    default List<Map<String, String>> getListOfMappedValues() {
        return new ArrayList<>();
    }
}
