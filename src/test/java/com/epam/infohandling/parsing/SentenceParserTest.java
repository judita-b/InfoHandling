package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SentenceParserTest {

    @Test
    public void parseShouldParseWhenDataValid() {

        Parser successor = mock(Parser.class);

        when(successor.parse(anyString())).thenAnswer(invocation -> {
            String argument = (String) invocation.getArguments()[0];
            return new Leaf(argument);
        });

        SentenceParser sentenceParser = new SentenceParser(successor);
        Composite composite = (Composite) sentenceParser.parse("Testing text [3 9 +] with expression");
        Assert.assertEquals(new Leaf("text"), composite.getChild(1));
        Assert.assertEquals(new Leaf("3 9 +"), composite.getChild(2));
    }
}
