package calculator.view;

import calculator.model.CalculatorModel;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private static final String INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_STRING = "결과 : ";

    public String receiveInput() {
        System.out.println(INPUT_STRING);
        String input = Console.readLine();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다. 올바른 문자열을 입력해 주세요.");
        }

        return input;
    }

    public void displayOutput(CalculatorModel calculatorModel) {
        System.out.println(OUTPUT_STRING + calculatorModel.getResult());
    }
}
