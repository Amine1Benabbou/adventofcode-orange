package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileUtils {

    public static List<List<Integer>> readReports(String resourcePath) {
        List<List<Integer>> reports = new ArrayList<>();
        InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(resourcePath);

        if (is == null) {
            System.err.println("Resource not found: " + resourcePath);
            return reports;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                List<Integer> levels = Arrays.stream(line.trim().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                reports.add(levels);
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return reports;
    }
}
