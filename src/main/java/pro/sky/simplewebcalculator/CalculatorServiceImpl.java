package pro.sky.simplewebcalculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private static final String GREETING_MESSAGE = "<b>Добро пожаловать в калькулятор</b>";
    private static final String NUMBER_ERROR_MESSAGE = "Ошибка: параметры должны быть числами.";
    private static final String DIVISION_BY_ZERO_MESSAGE = "Ошибка: деление на 0 невозможно";

    public CalculatorServiceImpl() {
    }

    public String greetings() {
        return GREETING_MESSAGE;
    }

    public String addition(String param1, String param2) {
        return calculate(param1, param2, "+");
    }

    public String subtraction(String param1, String param2) {
        return calculate(param1, param2, "-");
    }

    public String multiplication(String param1, String param2) {
        return calculate(param1, param2, "*");
    }

    public String division(String param1, String param2) {
        if (isIllegalArgument(param1, param2)) return NUMBER_ERROR_MESSAGE;
        if (Integer.parseInt(param2) == 0) {
            return DIVISION_BY_ZERO_MESSAGE;
        }
        return String.format("%s / %s = %d", param1, param2, Integer.parseInt(param1) / Integer.parseInt(param2));
    }

    private String calculate(String param1, String param2, String operation) {
        if (isIllegalArgument(param1, param2)) return NUMBER_ERROR_MESSAGE;

        int num1 = Integer.parseInt(param1);
        int num2 = Integer.parseInt(param2);
        int result = 0;

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
        }
        return param1 + " " + operation + " " + param2 + " = " + result;
    }

    private boolean isIllegalArgument(String p1, String p2) {
        return !isNumeric(p1) || !isNumeric(p2) || p1.isEmpty() || p2.isEmpty();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
