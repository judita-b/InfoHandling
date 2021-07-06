package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public class TextParser extends AbstractParser {

    private static final String SPLITTER = "\n";

    TextParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] parts = text.split(SPLITTER);

        for (String part : parts) {
            Component inner = getSuccessor().parse(part);
            composite.add(inner);
        }
        return composite;
    }
}
