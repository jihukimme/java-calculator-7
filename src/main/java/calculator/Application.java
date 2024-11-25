package calculator;

import calculator.controller.CalculatorController;
import calculator.parser.CalculatorParser;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorParser calculatorParser = new CalculatorParser();
        CalculatorService calculatorService = new CalculatorService();
        CalculatorController calculatorController = new CalculatorController(calculatorView, calculatorService, calculatorParser);

        calculatorController.run();
    }
}
