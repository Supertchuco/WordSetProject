import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.apache.commons.lang3.StringUtils.containsAny;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * WordSet data structure.
 */
public class WordSet {

    private final TreeSet<String> words = new TreeSet<>();

    /**
     * @param word String input.
     * @return if word exists returns a list of words where each contains a character from given  word.
     * or if word does not exist return an empty list.
     */
    public List<String> add(final String word) {
        if (words.contains(word)) {
            return buildListThatContainsAnyCharacterFromWordParameterInStoredWords(word);
        } else {
            words.add(word);
        }
        return new ArrayList<>();
    }

    /**
     * @param word String input.
     * @return list of words where each contains a character from given word.
     */
    public List<String> get(final String word) {
        return buildListThatContainsAnyCharacterFromWordParameterInStoredWords(word);
    }

    /**
     * @param word String input.
     * @return if word exists in stored words remove it and return true, else return false.
     * if word not exist return false.
     */
    public boolean remove(final String word) {
        return words.remove(word);
    }

    /**
     * @param word String input.
     * @return list that contains any word in stored words that contains any character from word parameter.
     */
    private List<String> buildListThatContainsAnyCharacterFromWordParameterInStoredWords(final String word) {
        List<String> wordsContainsCharacter = new ArrayList<>();
        if (isNotBlank(word)) {
            for (String wordStored : words) {
                if (wordOneContainsAnyCharacterFromWordTwo(wordStored, word) && !wordStored.equals(word)) {
                    wordsContainsCharacter.add(wordStored);
                }
            }
        }
        return wordsContainsCharacter;
    }

    /**
     * @param wordOne String input.
     * @param wordTwo String input.
     * @return true if word one contains any character from word two.
     */
    private boolean wordOneContainsAnyCharacterFromWordTwo(final String wordOne, final String wordTwo) {
        return containsAny(wordOne, wordTwo.toCharArray());
    }

}
