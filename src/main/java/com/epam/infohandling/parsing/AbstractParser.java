package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] parts = text.split(getSplitter());

        for (String part : parts) {
            Composite inner = getSuccessor().parse(part);
            composite.add(inner);
        }
        return composite;
    }

    protected abstract String getSplitter();


}
