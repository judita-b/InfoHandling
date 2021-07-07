package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class TextParserTest {

    @Test
    public void parseShouldParseWhenDataValid() {

        Parser successor = mock(Parser.class);

        when(successor.parse(anyString())).thenAnswer(invocation -> {
            String argument = (String) invocation.getArguments()[0];
            return new Leaf(argument);
        });

        TextParser textParser = new TextParser(successor);
        Composite composite = (Composite) textParser.parse("1\n2");
        System.out.println(composite.getChild(0));
        Assert.assertEquals(new Leaf("Word", "1"), composite.getChild(0));
        Assert.assertEquals(new Leaf("Word", "2"), composite.getChild(1));


    }
}
