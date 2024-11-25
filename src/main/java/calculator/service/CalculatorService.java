package calculator.service;

import calculator.model.CalculatorModel;
import calculator.parser.CalculatorParser;

import java.util.Set;
import java.util.regex.Pattern;

public class CalculatorService {
    // 계산 수행
    public int calculate(CalculatorModel model) {
        String input = model.getInput();
        Set<String> separators = model.getSeparators();

        // 구분자를 정규식으로 변환
        String delimiters = createDelimiterRegex(separators);

        // 입력 분리 및 숫자 합산
        String[] numbers = splitInput(input, delimiters);
        return sumNumbers(numbers);
    }

    // 모든 구분자를 정규식으로 생성
    private String createDelimiterRegex(Set<String> separators) {
        StringBuilder delimiterRegex = new StringBuilder();
        for (String separator : separators) {
            if (delimiterRegex.length() > 0) {
                delimiterRegex.append("|");
            }
            delimiterRegex.append(Pattern.quote(separator));
        }
        return delimiterRegex.toString();
    }

    // 입력 문자열을 구분자로 분리
    private String[] splitInput(String input, String delimiters) {
        return input.split(delimiters);
    }

    // 숫자 합산
    private int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int parsedNumber = parseNumber(number.trim());
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + parsedNumber);
            }
            sum += parsedNumber;
        }

        return sum;
    }

    // 문자열을 숫자로 변환
    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + number);
        }
    }

}
