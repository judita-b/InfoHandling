package com.epam.infohandling.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpressionCalculator {

    public int calculate(String expression, Map<String, Integer> variables) {
        Context context = new Context();
        List<Expression> expressions = parse(expression, variables);
        for (Expression terminal: expressions) {
            terminal.interpret(context);

        }
        return context.popValue();
    }

    private List<Expression> parse(String expression, Map<String, Integer> variables) {
        List<Expression> expressions = new ArrayList<>();
        for (String lexeme: expression.split("\\s+")) {
            if (lexeme.isEmpty()){
                continue;
            }
            char tempt = lexeme.charAt(0);
            switch (tempt){
                case '+':
                    expressions.add(new TerminalPlusExpression());
                    break;
                case '-':
                    expressions.add(new TerminalMinusExpression());
                    break;
                case '*':
                    expressions.add(new TerminalMultiplyExpression());
                    break;
                case '/':
                    expressions.add(new TerminalDivideExpression());
                    break;
                default:
                    if (variables.containsKey(lexeme)) {
                        expressions.add(new NonterminalExpression(variables.get(lexeme)));
                    } else {
                        Scanner scan = new Scanner(lexeme);
                        if (scan.hasNextInt()) {
                            expressions.add(new NonterminalExpression(scan.nextInt()));
                        }
                    }
            }
        }
        return expressions;
    }

}
