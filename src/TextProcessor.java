public class TextProcessor {
    public StringBuilder processText(String input, char startChar, char endChar) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be empty");
        }

        StringBuilder text = new StringBuilder(input);
        StringBuilder result = new StringBuilder();

        int startPos = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '!' || c == '?' || i == text.length() - 1) {
                int endPos = i + 1;
                StringBuilder sentence = new StringBuilder(text.substring(startPos, endPos));

                removeLongestSubstring(sentence, startChar, endChar);

                result.append(sentence);
                startPos = endPos;
            }
        }
        return result;
    }

    private void removeLongestSubstring(StringBuilder sentence, char start, char end) {
        int maxLength = -1;
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < sentence.length(); i++) {
            if (Character.toLowerCase(sentence.charAt(i)) == Character.toLowerCase(start)) {
                for (int j = sentence.length() - 1; j >= i; j--) {
                    if (Character.toLowerCase(sentence.charAt(j)) == Character.toLowerCase(end)) {
                        int currentLength = j - i + 1;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                            bestStart = i;
                            bestEnd = j;
                        }
                        break;
                    }
                }
            }
        }

        if (bestStart != -1) {
            sentence.delete(bestStart, bestEnd + 1);
        }
    }
}