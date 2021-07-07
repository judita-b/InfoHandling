package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public class ParagraphParser extends AbstractParser {

    private static final String SPLITTER = "[.|!|?]";
    private static final String PARAGRAPH = "Paragraph";

    ParagraphParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        text = text.trim();
        Composite composite = new Composite(PARAGRAPH, text);
        String[] parts = text.split(SPLITTER);

        for (String part : parts) {
            //String value = part + ".";
            Component inner = getSuccessor().parse(part.trim());
            composite.add(inner);
        }
        return composite;
    }
}
