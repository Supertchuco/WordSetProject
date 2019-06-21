import org.junit.Test;

import static org.junit.Assert.*;

public class WordSetTest {

    @Test
    public void wordSetTest() {

        final WordSet wordSet = new WordSet();

        wordSet.add("sea");
        wordSet.add("fog");
        wordSet.add("duo");

        assertEquals("[duo]", wordSet.get("fog").toString());

        wordSet.add("ted");
        wordSet.add("ray");
        wordSet.add("wig");
        wordSet.add("ill");
        wordSet.add("toy");
        wordSet.add("mag");
        wordSet.add("try");
        wordSet.add("cow");

        assertEquals("[duo, fog, toy, wig]", wordSet.get("cow").toString());
        assertEquals("[mag, ray, ted]", wordSet.get("sea").toString());

        assertTrue(wordSet.remove("sea"));
        assertFalse(wordSet.remove("sadfasfdfa"));
    }
}
