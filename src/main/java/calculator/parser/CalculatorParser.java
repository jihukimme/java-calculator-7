package calculator.parser;

import java.util.HashSet;
import java.util.Set;

public class CalculatorParser {

    private static final Set<String> DEFAULT_SEPARATORS = Set.of(",", ":");

    // 커스텀 구분자 추출
    public String extractCustomSeparator(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex != -1) {
                return input.substring(2, newlineIndex);
            }
        }
        return null;
    }

    // 커스텀 구분자를 제거한 입력 문자열 반환
    public String trimInput(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex != -1) {
                return input.substring(newlineIndex + 1);
            }
        }
        return input;
    }

    // 모든 구분자(기본 + 커스텀)를 생성
    public Set<String> getAllSeparators(String customSeparator) {
        Set<String> separators = new HashSet<>(DEFAULT_SEPARATORS);
        if (customSeparator != null && !customSeparator.isEmpty()) {
            separators.add(customSeparator);
        }
        return separators;
    }
}

