package pro.sky.simplewebcalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private static final String GREETING_MESSAGE = "<b>Добро пожаловать в калькулятор</b>";
    private static final String ERROR_MESSAGE = "<u>Ошибка.</u><br>Проверьте правильность введённых чисел.";

    private final CalculatorServiceImpl calculatorServiceImpl;

    public CalculatorController(CalculatorServiceImpl calculatorServiceImpl) {
        this.calculatorServiceImpl = calculatorServiceImpl;
    }

    @GetMapping
    public String greetings() {
        return GREETING_MESSAGE;
    }

    @GetMapping(path = "/plus")
    public String addition(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return printResult(param1, param2, calculatorServiceImpl.addition(param1, param2), "+");
    }

    @GetMapping(path = "/minus")
    public String subtraction(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return printResult(param1, param2, calculatorServiceImpl.subtraction(param1, param2), "-");
    }

    @GetMapping(path = "/multiply")
    public String multiplication(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return printResult(param1, param2, calculatorServiceImpl.multiplication(param1, param2), "*");
    }

    @GetMapping(path = "/divide")
    public String division(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return printResult(param1, param2, calculatorServiceImpl.division(param1, param2), "/");
    }

    private String printResult(String param1, String param2, Float result, String operator) {
        if (Float.isNaN(result)) return ERROR_MESSAGE;
        return param1 + " " + operator + " " + param2 + " = " + String.format("%.2f", result);
    }
}
