package calculator.model;


import java.util.Set;

public class CalculatorModel {
    private String input;
    private String result;
    private Set<String> separators;

    public CalculatorModel(String input, Set<String> separators) {
        this.input = input;
        this.separators = separators;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String inpiut) {
        this.input = inpiut;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Set<String> getSeparators() {
        return separators;
    }

    public void setSeparators(Set<String> separators) {
        this.separators = separators;
    }


}
