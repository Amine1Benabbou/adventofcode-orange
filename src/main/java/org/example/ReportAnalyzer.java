package org.example;

import java.util.List;

public class ReportAnalyzer {

    public static boolean isSafe(List<Integer> levels) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            int diff = levels.get(i + 1) - levels.get(i);
            if (diff < 1 || diff > 3) increasing = false;
            if (diff > -1 || diff < -3) decreasing = false;
        }

        return increasing || decreasing;
    }

    public static int countSafeReports(List<List<Integer>> reports) {
        return (int) reports.stream()
                .filter(ReportAnalyzer::isSafe)
                .count();
    }
}
