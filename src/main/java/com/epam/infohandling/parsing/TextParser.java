package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public class TextParser extends AbstractParser {

    private static final String SPLITTER = "\n";
    private static final String TEXT = "Text";

    TextParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        text = text.trim();
        Composite composite = new Composite(TEXT, text);
        String[] parts = text.split(SPLITTER);

        for (String part : parts) {
            Component inner = getSuccessor().parse(part);
            composite.add(inner);
        }
        return composite;
    }
}
