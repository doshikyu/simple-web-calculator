package pro.sky.simplewebcalculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public CalculatorServiceImpl() {
    }

    public Float addition(String param1, String param2) {
        return calculate(param1, param2, "+");
    }

    public Float subtraction(String param1, String param2) {
        return calculate(param1, param2, "-");
    }

    public Float multiplication(String param1, String param2) {
        return calculate(param1, param2, "*");
    }

    public Float division(String param1, String param2) {
        if (Float.parseFloat(param2) == 0) {
            return Float.NaN;
        }
        return calculate(param1, param2, "/");
    }

    private Float calculate(String param1, String param2, String operation) {
        if (isIllegalArgument(param1, param2)) return Float.NaN;

        Float num1 = Float.parseFloat(param1);
        Float num2 = Float.parseFloat(param2);
        float result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }

    private boolean isIllegalArgument(String p1, String p2) {
        return !isNumeric(p1) || !isNumeric(p2) || p1.isEmpty() || p2.isEmpty();
    }

    private boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

