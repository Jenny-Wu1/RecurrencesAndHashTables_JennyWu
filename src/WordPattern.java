import java.util.HashMap;

public class WordPattern {
    public static boolean followsPattern(String p, char d, String s) {
        String delim = Character.toString(d);
        if ("?*+.^$|()[]{}\\".contains(delim)) {
            delim = "\\" + delim;
        }

        String[] words = s.split(delim);

        if (words.length != p.length()) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }
        return true;
    }
}
