package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.parser.CalculatorParser;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

import java.util.Set;

public class CalculatorController {
    private final CalculatorView view;
    private final CalculatorService service;
    private final CalculatorParser parser;

    public CalculatorController(CalculatorView view, CalculatorService service, CalculatorParser parser) {
        this.view = view;
        this.service = service;
        this.parser = parser;
    }

    public void run() {
        try {
            // 사용자 입력 받기
            String input = view.receiveInput();

            // Parser로 입력 처리
            String customSeparator = parser.extractCustomSeparator(input);
            String trimmedInput = parser.trimInput(input);
            Set<String> separators = parser.getAllSeparators(customSeparator);

            // Model 생성
            CalculatorModel model = new CalculatorModel(trimmedInput, separators);

            // 계산 수행
            int result = service.calculate(model);
            model.setResult(String.valueOf(result));

            // 결과 출력
            view.displayOutput(model);

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예기치 못한 오류가 발생했습니다. 프로그램을 종료합니다.");
        }
    }
}
