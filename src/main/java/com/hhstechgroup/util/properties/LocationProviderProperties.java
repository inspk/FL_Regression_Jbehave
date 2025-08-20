package com.hhstechgroup.util.properties;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LocationProviderProperties {

    private static final String FILENAME = "LocationProviderID.properties";
    private static final String LOCATION_PROVIDER_HEADER = "location_provider_id:";
    private static final String BASE_PROVIDER_HEADER = "PES_ID:";

    public static void appendLocationProviderId(String locationId) {
        appendValueToSection(LOCATION_PROVIDER_HEADER, locationId);
    }

    public static void appendBasePES_Id(String baseId) {
        appendValueToSection(BASE_PROVIDER_HEADER, baseId);
    }

    private static void appendValueToSection(String sectionHeader, String newValue) {
        try {
            Path path = Paths.get(FILENAME);
            if (!Files.exists(path)) {
                Files.createFile(path);
                Files.write(path, Arrays.asList(sectionHeader, newValue, ""), StandardOpenOption.APPEND);
                return;
            }

            List<String> lines = Files.readAllLines(path);
            List<String> updatedLines = new ArrayList<>();

            boolean sectionFound = false;
            boolean valueAlreadyPresent = false;
            boolean inserted = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                updatedLines.add(line);

                if (line.trim().equalsIgnoreCase(sectionHeader)) {
                    sectionFound = true;
                    // Start scanning the section block
                    int j = i + 1;
                    while (j < lines.size() && !lines.get(j).trim().isEmpty()) {
                        if (lines.get(j).trim().equalsIgnoreCase(newValue)) {
                            valueAlreadyPresent = true;
                            break;
                        }
                        j++;
                    }
                    if (!valueAlreadyPresent) {
                        updatedLines.add(newValue);
                        inserted = true;
                    }
                }
            }

            // Section was not found, so append it
            if (!sectionFound) {
                updatedLines.add("");
                updatedLines.add(sectionHeader);
                updatedLines.add(newValue);
                inserted = true;
            }

            if (inserted || !valueAlreadyPresent) {
                Files.write(path, updatedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getLocationProviderIds() {
        List<String> ids = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILENAME));
            boolean inSection = false;

            for (String line : lines) {
                line = line.trim();
                if (line.equalsIgnoreCase(LOCATION_PROVIDER_HEADER)) {
                    inSection = true;
                    continue;
                }
                if (inSection) {
                    if (line.isEmpty() || line.endsWith(":")) {
                        break; // Stop if empty or a new section starts
                    }
                    ids.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ids;
    }
    public static List<String> getPES_Id() {
        List<String> ids = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILENAME));
            boolean inSection = false;

            for (String line : lines) {
                line = line.trim();
                if (line.equalsIgnoreCase(BASE_PROVIDER_HEADER)) {
                    inSection = true;
                    continue;
                }
                if (inSection) {
                    if (line.isEmpty() || line.endsWith(":")) {
                        break; // Stop if empty or a new section starts
                    }
                    ids.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
