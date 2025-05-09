package org.ndb.tools;

import java.util.*;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindKeyWord {

    private static final Logger logger = Logger.getLogger(FindKeyWord.class.getName());
    public static final String FOLLOWING_INDICES = "The keyword {0} occurs in the text \"{1}\" at the following indices: {2}";

    /**
     * Finds all occurrences of a given keyword within a specified text. The search is case-insensitive
     * and normalizes both the text and keyword to handle accents or diacritical marks.
     *
     * @param text the text within which to search for the keyword, must not be null
     * @param keyWord the keyword to search for, must not be null
     * @return a list of starting indices of all occurrences of the keyword within the text
     */
    public static List<Integer> findOccurrences(String text, String keyWord) {
        List<Integer> indices = new ArrayList<>();
        int i = 0;

        while (i <= text.length() - keyWord.length()) {
            String extrait = normalize(text).substring(i, i + keyWord.length());
            if (normalize(extrait).equalsIgnoreCase(normalize(keyWord))) {
                indices.add(i);
                i += keyWord.length();
            } else {
                i++;
            }
        }

        return indices;
    }

    public static String normalize(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

    /**
     * The main execution method. Demonstrates the usage of the {@code findOccurrences} method
     * by logging the results of finding keyword occurrences in sample texts.
     *
     * @param args the command-line arguments, not used in this implementation
     */
    public static void main(String[] args) {
        String keyword1 = "ali";
        String text1 = "Alice aux pays des merveilles et ali baba";
        logger.log(Level.INFO, FOLLOWING_INDICES, new Object[]{keyword1, text1, findOccurrences(text1, keyword1)});

        String keyword2 = "he";
        String text2 = "Hé ho hé ho on rentre du boulot! Heureux comme tout.";
        logger.log(Level.INFO, FOLLOWING_INDICES, new Object[]{keyword2, text2, findOccurrences(text2, keyword2)});
    }
}
