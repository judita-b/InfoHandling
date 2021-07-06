package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public class ParagraphParser extends AbstractParser {

    private static final String SPLITTER = "[.|!|?]";

    ParagraphParser(Parser successor) {
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
