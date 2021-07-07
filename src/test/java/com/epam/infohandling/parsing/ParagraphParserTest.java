package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    @Test
    public void parseShouldParseWhenDataValid() {

        Parser successor = mock(Parser.class);

        when(successor.parse(anyString())).thenAnswer(invocation -> {
            String argument = (String) invocation.getArguments()[0];
            return new Leaf(argument);
        });

        ParagraphParser paragraphParser = new ParagraphParser(successor);
        Composite composite = (Composite) paragraphParser.parse("Test text first sentence. Test text second sentence.");
        Assert.assertEquals(new Leaf("Test text first sentence"), composite.getChild(0));
        Assert.assertEquals(new Leaf("Test text second sentence"), composite.getChild(1));
    }
}
