package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i]).append(" ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
                // can replace for loop above with this line
                //builder.append(" ".repeat(Math.max(0, maxWidth - builder.length())));
            } else {
                // middle justified
                int spaces = (maxWidth - count) / diff;
                int remainder = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= spaces + (i - index < remainder ? 1 : 0); j++) {
                            builder.append(" ");
                        }
                        // can replace for loop above with this line
                        //builder.append(" ".repeat(Math.max(0, (spaces + ((i - index) < remainder ? 1 : 0)) + 1)));
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }


        return lines;
    }

    public static void main(String[] args) {
        TextJustification_68 textJustification = new TextJustification_68();

        int maxWidth = 16;
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> justifiedText = textJustification.fullJustify(words, maxWidth);
        justifiedText.forEach(System.out::println);

        words = new String[] {"What","must","be","acknowledgment","shall","be"};
        justifiedText = textJustification.fullJustify(words, maxWidth);
        justifiedText.forEach(System.out::println);

    }
}
