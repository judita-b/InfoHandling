package com.epam.infohandling.logic;

import com.epam.infohandling.TextProcessor;
import com.epam.infohandling.TextReader;
import com.epam.infohandling.interpreter.ExpressionCalculator;
import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextLogic {

    ExpressionCalculator calculator = new ExpressionCalculator( );
    Map<String, Integer> myVariables = new HashMap<String, Integer>();
    private static final String  MATH_SPLITTER = "\\[(.*?)\\]";

    public TextLogic() {
        myVariables.put("x", 7);
        myVariables.put("y", 2);
    }

    public Composite calculate(Composite text) {
        List<String> expressions;
        expressions = getExpressions(text);

        List<Integer> result = new ArrayList<>();;
        if (expressions != null) {
            for (String expression : expressions) {
                Integer value = calculator.calculate(expression, myVariables);
                result.add(value);
            }
        }

        Composite root = new Composite("Root", result.toString());
        for (Integer res: result) {
            Leaf leaf = new Leaf("Results", String.valueOf(res));
            root.add(leaf);
        }
        return root;
    }

    public String restore(Composite text) {
        throw new UnsupportedOperationException();
    }



    private List<String> getExpressions(Composite text) {
        List<String> expressions = new ArrayList<String>();

        for (int i = 0; i < text.childrenCount(); i++) {
            Component child = (Component)text.getChild(i);
            if (child.isLeaf()) {
                String value = (String)child.getValue();
                if (value.matches(MATH_SPLITTER)) {
                    expressions.add(value);
                }
            } else {
                expressions = getExpressions((Composite)child);
            }
        }
        return expressions;
    }



}

