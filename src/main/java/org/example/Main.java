package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> reports = FileUtils.readReports("input.txt");
        int safeCount = ReportAnalyzer.countSafeReports(reports);
        System.out.println("Number of safe reports: " + safeCount);
    }
}
