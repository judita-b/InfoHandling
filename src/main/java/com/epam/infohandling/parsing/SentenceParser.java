package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;

public class SentenceParser extends AbstractParser {

    private static final String SPLITTER = " ";

    SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return SPLITTER;
    }
}
