package ci.service;

import java.util.regex.Pattern;

public class DataTransformServiceImpl {
    private Pattern pattern = Pattern.compile("[., \"\\?!:']");

    public int getWordCount(String text) {
        int count = 0;
        if (text != null) {
            String[] results = pattern.split(text);
            for (String s : results) {
                if (!s.equals("") && !s.equals(" ")) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
