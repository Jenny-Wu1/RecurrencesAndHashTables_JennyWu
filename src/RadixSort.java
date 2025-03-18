import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RadixSort {
    public static int getMaxLength(String[] s) {
        int maxLength = 0;
        for (int i = 0; i < s.length; i++) {
            int currentLength = s[i].length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    public static void radSort(String[] s) {
        int maxLength = getMaxLength(s);

        for (int pos = maxLength - 1; pos >= 0; pos--) {
            HashMap<Character, List<String>> buckets = new HashMap<>();

            for (char c = 'a'; c <= 'z'; c++) {
                buckets.put(c, new ArrayList<>());
            }
            buckets.put('\0', new ArrayList<>());

            char key;
            for(int i = 0; i < s.length; i++) {
                if (pos < s[i].length()) {
                    key = s[i].charAt(pos);
                } else {
                    key = '\0';
                }
                buckets.get(key).add(s[i]);
            }

            int index = 0;
            if (buckets.containsKey('\0')) {
                for (int i = 0; i < buckets.get('\0').size(); i++) {
                    s[index] = buckets.get('\0').get(i);
                    index++;
                }
            }

            for (char c = 'a'; c <= 'z'; c++) {
                if (buckets.containsKey(c)) {
                    for (int i = 0; i < buckets.get(c).size(); i++) {
                        s[index] = buckets.get(c).get(i);
                        index++;
                    }
                }
            }
        }
    }
}
