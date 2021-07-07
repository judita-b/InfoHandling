package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    private static final String SPLITTER = " ";
    private static final String  MATH_SPLITTER = "\\[(.*?)\\]";
    private static final String SENTENCE = "Sentence";
    private static final String WORD = "Word";

    SentenceParser(Parser successor) {
        super(null);
    }

    public Composite parse(String text) {
        text = text.trim();
        Composite composite = new Composite(SENTENCE, text);

        Pattern pattern = Pattern.compile(MATH_SPLITTER);
        Matcher matcher = pattern.matcher(text);

        List<Integer> sentenceSeparators = new ArrayList<Integer>();

        sentenceSeparators.add(0);
        while (matcher.find()) {
            sentenceSeparators.add(matcher.start());
            sentenceSeparators.add(matcher.end());
        }
        sentenceSeparators.add(text.length());

        List<String> sentenceParts = new ArrayList<String>();
        for (int i = 0; i < sentenceSeparators.size() - 1; i++) {
            String part = text.substring(sentenceSeparators.get(i), sentenceSeparators.get(i+1));
            sentenceParts.add(part);
        }

        for (String part : sentenceParts) {
            part = part.trim();

            if (Pattern.matches(MATH_SPLITTER, part)) {
                String temp = part.replaceAll("[\\[\\]]","");
                Leaf leaf = new Leaf(WORD, temp);
                composite.add(leaf);
            } else {
                String[] words = part.split(SPLITTER);
                for (String word : words) {
                    if(!word.isEmpty()) {
                        Leaf leaf = new Leaf(WORD, word);
                        composite.add(leaf);
                    }
                }
            }
        }
        return composite;
    }

}
