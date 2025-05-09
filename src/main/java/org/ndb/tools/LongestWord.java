package org.ndb.tools;

import java.util.*;
import java.util.logging.Logger;

/**
 * The {@code LongestWord} class provides functionality to find the longest word
 * from a predefined list of French words that can be constructed using a given
 * set of characters. The search is case-insensitive and considers only the
 * characters provided.
 * <p>
 * This class includes a predefined constant list of French words and utilities to
 * validate word construction from the provided characters.
 * <p>
 * Methods:
 * - {@code extractLongestWord(String characters)}: Identifies the longest word
 *   that can be formed from the input characters.
 * <p>
 * The main method demonstrates the invocation of {@code extractLongestWord} and
 * logs the result.
 */
public class LongestWord {

    private static final Logger logger = Logger.getLogger(LongestWord.class.getName());

    private static final List<String> FRENCH_WORDS = Arrays.asList(
            "abricot", "banane", "cerise", "dauphin", "éléphant", "fleur", "girafe", "hibou", "iguane",
            "jaguar", "kangourou", "lion", "mouton", "nénuphar", "oiseau", "panda", "quatre", "renard",
            "singe", "tigre", "un", "vache", "wombat", "xylophone", "yak", "zèbre", "bac", "abaca"
    );

    /**
     * Extracts the longest word from a predefined list of French words that can be
     * constructed using the given characters. The input characters are case-insensitive
     * and must not exceed a length of 26. If no valid word can be formed, an empty
     * {@code Optional} is returned.
     *
     * @param characters a string containing the set of characters that can be used to
     *                   construct a word. Must not be null, empty, or longer than 26
     *                   characters.
     * @return an {@code Optional} containing the longest word that can be formed
     *         using the given characters. Returns an empty {@code Optional} if no
     *         valid word can be constructed.
     */
    public static Optional<String> extractLongestWord(String characters) {
        if (characters == null || characters.isEmpty() || characters.length() > 26) {
            return Optional.empty();
        }

        List<String> possibleWords = new ArrayList<>();
        characters = characters.toLowerCase();

        for (String word : FRENCH_WORDS) {
            if (isValidWithCharacters(word, characters)) {
                possibleWords.add(word);
            }
        }

        if (possibleWords.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(possibleWords.stream().max(Comparator.comparing(String::length)).orElse(null));
    }

    /**
     * Checks if all characters in the given word are present in the specified set of characters.
     *
     * @param word the word to validate, must not be null
     * @param characters the set of characters against which the word is validated, must not be null
     * @return true if all characters in the word are present in the characters string; false otherwise
     */
    private static boolean isValidWithCharacters(String word, String characters) {
        for (char c : word.toCharArray()) {
            if (!characters.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "abcd";
        Optional<String> longestWord = extractLongestWord(characters);
        if (longestWord.isPresent()) {
            logger.info("The longest word is: " + longestWord.get());
        } else {
            logger.info("No word found.");
        }
    }
}
