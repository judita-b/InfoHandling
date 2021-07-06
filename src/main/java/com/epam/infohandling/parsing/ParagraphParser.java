package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;

public class ParagraphParser extends AbstractParser {

    private static final String SPLITTER = "[.|!|?]";

    ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return SPLITTER;
    }
}
