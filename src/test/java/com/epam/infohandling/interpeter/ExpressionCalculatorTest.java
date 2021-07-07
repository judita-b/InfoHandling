package com.epam.infohandling.interpeter;

import com.epam.infohandling.interpreter.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ExpressionCalculatorTest {
    private Map<String, Integer> variables = new HashMap<String, Integer>();

    public ExpressionCalculatorTest() {
        variables.put("x", 7);
    }

    @Test
    public void expressionCalculatorShouldCalculateWhenNumbersPositive() {
        final String expression = "3 x +";

        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        Integer result = expressionCalculator.calculate(expression, variables);

        Assert.assertNotNull(result);
        Assert.assertEquals(10, result, 0.01);
    }
}
