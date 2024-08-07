package pro.sky.simplewebcalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServiceImpl calculatorServiceImpl;

    public CalculatorController(CalculatorServiceImpl calculatorServiceImpl) {
        this.calculatorServiceImpl = calculatorServiceImpl;
    }

    @GetMapping
    public String greetings() {
        return calculatorServiceImpl.greetings();
    }

    @GetMapping(path = "/plus")
    public String addition(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return calculatorServiceImpl.addition(param1, param2);
    }

    @GetMapping(path = "/minus")
    public String subtraction(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return calculatorServiceImpl.subtraction(param1, param2);
    }

    @GetMapping(path = "/multiply")
    public String multiplication(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return calculatorServiceImpl.multiplication(param1, param2);
    }

    @GetMapping(path = "/divide")
    public String division(@RequestParam("num1") String param1, @RequestParam("num2") String param2) {
        return calculatorServiceImpl.division(param1, param2);
    }
}
