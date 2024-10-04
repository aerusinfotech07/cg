package com.cg;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class StringManipulation {

    // 1. Reverse a String
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 2. Check for Palindrome
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // 3. Count Vowels vilas
    public static int countVowels(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // 4. Remove Duplicate Characters
    public static String removeDuplicates(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }

    // 5. Count Words
    public static int countWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    // 6. Find the First Non-Repeating Character
    public static Character firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return null; // Return null if all characters repeat
    }

    // 7. Check if Two Strings are Anagrams
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return java.util.Arrays.equals(arr1, arr2);
    }

    // 8. Count the Occurrences of a Character
    public static int countCharacterOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    // 9. Replace All Spaces with Underscores
    public static String replaceSpacesWithUnderscores(String str) {
        return str.replace(" ", "_");
    }

    // 10. Convert String to Title Case
    public static String toTitleCase(String str) {
        String[] words = str.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1).toLowerCase())
                         .append(" ");
            }
        }
        return titleCase.toString().trim();
    }

    // 11. Find the Length of a String
    public static int stringLength(String str) {
        return str.length();
    }

    // 12. Convert String to Uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    // 13. Convert String to Lowercase
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    // 14. Trim Whitespace from Both Ends
    public static String trimWhitespace(String str) {
        return str.trim();
    }

    // 15. Check if String Contains Another String
    public static boolean containsString(String str, String substr) {
        return str.contains(substr);
    }

    // 16. Split String by Delimiter
    public static String[] splitString(String str, String delimiter) {
        return str.split(delimiter);
    }

    // 17. Join an Array of Strings
    public static String joinStrings(String[] strings, String delimiter) {
        return String.join(delimiter, strings);
    }

    // 18. Convert a String to a Character Array
    public static char[] stringToCharArray(String str) {
        return str.toCharArray();
    }

    // 19. Find the Last Non-Repeating Character
    public static Character lastNonRepeatingCharacter(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (int i = str.length() - 1; i >= 0; i--) {
            if (charCount.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        
        return null; // Return null if all characters repeat
    }

    // 20. Find the First Repeating Character
    public static Character firstRepeatingCharacter(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        for (char c : str.toCharArray()) {
            if (charCount.put(c, 1) != null) {
                return c;
            }
        }
        
        return null; // Return null if no character repeats
    }

    // 21. Check if String is Empty
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // 22. Count Consonants
    public static int countConsonants(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }

    // 23. Find the Longest Word in a String
    public static String longestWord(String str) {
        String[] words = str.split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // 24. Check if a String Starts with a Prefix
    public static boolean startsWith(String str, String prefix) {
        return str.startsWith(prefix);
    }

    // 25. Check if a String Ends with a Suffix
    public static boolean endsWith(String str, String suffix) {
        return str.endsWith(suffix);
    }

    // 26. Convert a String to ASCII Values
    public static String stringToAscii(String str) {
        StringBuilder ascii = new StringBuilder();
        for (char c : str.toCharArray()) {
            ascii.append((int) c).append(" ");
        }
        return ascii.toString().trim();
    }

    // 27. Convert ASCII Values to a String
    public static String asciiToString(String asciiStr) {
        StringBuilder str = new StringBuilder();
        String[] asciiValues = asciiStr.split(" ");
        for (String value : asciiValues) {
            str.append((char) Integer.parseInt(value));
        }
        return str.toString();
    }

    // 28. Count Digits in a String
    public static int countDigits(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    // 29. Check if String is Numeric
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // 30. Replace All Occurrences of a Character
    public static String replaceCharacter(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }

    // 31. Remove All Non-Alphanumeric Characters
    public static String removeNonAlphanumeric(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    // 32. Capitalize the First Letter of Each Word
    public static String capitalizeFirstLetter(String str) {
        String[] words = str.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1)).append(" ");
            }
        }
        return capitalized.toString().trim();
    }

    // 33. Count the Number of Sentences
    public static int countSentences(String str) {
        if (isEmpty(str)) return 0;
        return str.split("[.!?]").length;
    }

    // 34. Remove Leading Zeros
    public static String removeLeadingZeros(String str) {
        return str.replaceFirst("^0+(?!$)", "");
    }

    // 35. Find All Unique Characters
    public static String uniqueCharacters(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        StringBuilder unique = new StringBuilder();
        for (char c : set) {
            unique.append(c);
        }
        return unique.toString();
    }

    // 36. Find the Most Frequent Character
    public static Character mostFrequentCharacter(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    // 37. Check if String is a Valid Email
    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$");
    }

    // 38. Convert a String to Pig Latin
    public static String toPigLatin(String str) {
        String[] words = str.split(" ");
        StringBuilder pigLatin = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                pigLatin.append(word.substring(1)).append(word.charAt(0)).append("ay ").append(" ");
            }
        }
        return pigLatin.toString().trim();
    }

    // 39. Find Substring Index
    public static int substringIndex(String str, String substr) {
        return str.indexOf(substr);
    }

    // 40. Find the Shortest Word
    public static String shortestWord(String str) {
        String[] words = str.split("\\s+");
        String shortest = words[0];
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }
        return shortest;
    }

    // 41. Find All Permutations of a String
    public static void printPermutations(String str, String prefix) {
        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                printPermutations(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
            }
        }
    }

    // 42. Find the Number of Unique Words
    public static int uniqueWordCount(String str) {
        String[] words = str.split("\\s+");
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        return uniqueWords.size();
    }

    // 43. Remove All Punctuation
    public static String removePunctuation(String str) {
        return str.replaceAll("\\p{Punct}", "");
    }

    // 44. Count the Number of Characters in a String (excluding spaces)
    public static int countCharactersExcludingSpaces(String str) {
        return str.replace(" ", "").length();
    }

    // 45. Count the Number of Uppercase Letters
    public static int countUppercaseLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    // 46. Count the Number of Lowercase Letters
    public static int countLowercaseLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }

    // 47. Check if Two Strings are Equal (case insensitive)
    public static boolean areEqualIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    // 48. Check if a String is a Substring of Another String
    public static boolean isSubstring(String str, String substr) {
        return str.contains(substr);
    }

    // 49. Count the Number of Lines in a String
    public static int countLines(String str) {
        if (isEmpty(str)) return 0;
        return str.split("\n").length;
    }

    // 50. Remove All Instances of a Character
    public static String removeAllInstances(String str, char ch) {
        return str.replace(String.valueOf(ch), "");
    }

    // 51. Convert a String to a Map of Character Counts
    public static Map<Character, Integer> stringToCharCountMap(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    // 52. Find Common Characters in Two Strings
    public static String commonCharacters(String str1, String str2) {
        StringBuilder common = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (str2.indexOf(c) != -1 && common.indexOf(String.valueOf(c)) == -1) {
                common.append(c);
            }
        }
        return common.toString();
    }

    // 53. Convert a Camel Case String to Regular String
    public static String camelCaseToRegular(String str) {
        return str.replaceAll("([a-z])([A-Z])", "$1 $2");
    }

    // 54. Count the Number of Lines in a Paragraph
    public static int countParagraphLines(String str) {
        return str.split("\n\n").length;
    }

    // 55. Find the Index of the Last Occurrence of a Character
    public static int lastIndexOfCharacter(String str, char ch) {
        return str.lastIndexOf(ch);
    }

    // 56. Replace All Occurrences of a Substring
    public static String replaceSubstring(String str, String oldSubstr, String newSubstr) {
        return str.replace(oldSubstr, newSubstr);
    }

    // 57. Remove All Leading and Trailing Spaces
    /*public static String removeLeadingAndTrailingSpaces(String str) {
        return str.strip();
    }*/

    // 58. Check if a String is a Valid URL
    public static boolean isValidURL(String url) {
        return url.matches("^(http|https)://.*$");
    }

    // 59. Convert a List of Strings to a Single String
    public static String listToString(java.util.List<String> list) {
        return String.join(", ", list);
    }

    // 60. Convert a String to a List of Words
    public static java.util.List<String> stringToList(String str) {
        return java.util.Arrays.asList(str.split("\\s+"));
    }

    // 61. Count the Number of Words with Length Greater than a Given Value
    public static int countWordsLongerThan(String str, int length) {
        String[] words = str.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.length() > length) {
                count++;
            }
        }
        return count;
    }

    // 62. Find the Most Common Word
    public static String mostCommonWord(String str) {
        String[] words = str.toLowerCase().split("\\s+");
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    // 63. Find the Shortest Sentence in a Paragraph
    public static String shortestSentence(String str) {
        String[] sentences = str.split("[.!?]");
        String shortest = sentences[0];
        for (String sentence : sentences) {
            if (sentence.length() < shortest.length()) {
                shortest = sentence;
            }
        }
        return shortest;
    }

    // 64. Find the Longest Sentence in a Paragraph
    public static String longestSentence(String str) {
        String[] sentences = str.split("[.!?]");
        String longest = sentences[0];
        for (String sentence : sentences) {
            if (sentence.length() > longest.length()) {
                longest = sentence;
            }
        }
        return longest;
    }

    // 65. Count the Number of Unique Characters in a String
    public static int uniqueCharacterCount(String str) {
        return new LinkedHashSet<>(java.util.Arrays.asList(stringToCharArray(str))).size();
    }

    // 66. Check if a String is a Valid Phone Number
    public static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{10}");
    }

    // 67. Convert a String to Binary Representation
    public static String stringToBinary(String str) {
        StringBuilder binary = new StringBuilder();
        for (char c : str.toCharArray()) {
            binary.append(Integer.toBinaryString(c)).append(" ");
        }
        return binary.toString().trim();
    }

    // 68. Convert Binary Representation Back to String
    public static String binaryToString(String binaryStr) {
        StringBuilder str = new StringBuilder();
        String[] binaryValues = binaryStr.split(" ");
        for (String binaryValue : binaryValues) {
            int asciiValue = Integer.parseInt(binaryValue, 2);
            str.append((char) asciiValue);
        }
        return str.toString();
    }

    // 69. Find the Frequency of Each Character
    public static Map<Character, Integer> characterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    // 70. Check if a String Contains Only Letters
    public static boolean containsOnlyLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }

    // 71. Check if a String Contains Only Digits
    public static boolean containsOnlyDigits(String str) {
        return str.matches("\\d+");
    }

    // 72. Check if a String Contains Special Characters
    public static boolean containsSpecialCharacters(String str) {
        return str.matches(".*[^a-zA-Z0-9].*");
    }

    // 73. Count the Number of Punctuation Characters
    public static int countPunctuationCharacters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (String.valueOf(c).matches("\\p{Punct}")) {
                count++;
            }
        }
        return count;
    }

    // 74. Remove All Special Characters
    public static String removeSpecialCharacters(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    // 75. Count the Number of Paragraphs
    public static int countParagraphs(String str) {
        return str.split("\n\n").length;
    }

    // 76. Check if a String is a Valid Credit Card Number
    public static boolean isValidCreditCard(String ccNumber) {
        return ccNumber.matches("\\d{16}");
    }

    // 77. Convert a String to a Hexadecimal String
    public static String stringToHex(String str) {
        StringBuilder hex = new StringBuilder();
        for (char c : str.toCharArray()) {
            hex.append(String.format("%02X", (int) c));
        }
        return hex.toString();
    }

    // 78. Convert a Hexadecimal String Back to String
    public static String hexToString(String hexStr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < hexStr.length(); i += 2) {
            String hexChar = hexStr.substring(i, i + 2);
            str.append((char) Integer.parseInt(hexChar, 16));
        }
        return str.toString();
    }

    // 79. Find the Middle Character of a String
    public static Character middleCharacter(String str) {
        if (str.isEmpty()) return null;
        int middle = str.length() / 2;
        return str.length() % 2 == 0 ? null : str.charAt(middle);
    }

    // 80. Check if a String is a Valid IPv4 Address
    public static boolean isValidIPv4(String ip) {
        return ip.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    }

    // 81. Find the Index of a Substring
    public static int indexOfSubstring(String str, String substr) {
        return str.indexOf(substr);
    }

    // 82. Count the Number of Times a Substring Appears
    public static int countSubstringOccurrences(String str, String substr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length();
        }
        return count;
    }

    // 83. Check if a String is a Valid Zip Code
    public static boolean isValidZipCode(String zip) {
        return zip.matches("\\d{5}");
    }

    // 84. Find All Vowels in a String
    public static String findVowels(String str) {
        StringBuilder vowels = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowels.append(c);
            }
        }
        return vowels.toString();
    }

    // 85. Find All Consonants in a String
    public static String findConsonants(String str) {
        StringBuilder consonants = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ("bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1) {
                consonants.append(c);
            }
        }
        return consonants.toString();
    }

    // 86. Count the Number of Syllables in a Word
    public static int countSyllables(String word) {
        int count = 0;
        String vowels = "aeiouy";
        boolean isPreviousVowel = false;
        for (char c : word.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                if (!isPreviousVowel) {
                    count++;
                    isPreviousVowel = true;
                }
            } else {
                isPreviousVowel = false;
            }
        }
        return count;
    }

    // 87. Generate a Random String of Given Length
    public static String generateRandomString(int length) {
        StringBuilder str = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            str.append(characters.charAt(index));
        }
        return str.toString();
    }

    // 88. Check if a String is a Valid Password
    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{8,}$");
    }

    // 89. Check if a String Contains Only Uppercase Letters
    public static boolean containsOnlyUppercase(String str) {
        return str.matches("[A-Z]+");
    }

    // 90. Check if a String Contains Only Lowercase Letters
    public static boolean containsOnlyLowercase(String str) {
        return str.matches("[a-z]+");
    }

    // 91. Find the Index of the First Occurrence of a Substring
    public static int indexOfFirstOccurrence(String str, String substr) {
        return str.indexOf(substr);
    }

    // 92. Remove All Digits from a String
    public static String removeDigits(String str) {
        return str.replaceAll("\\d", "");
    }

    // 93. Remove All Uppercase Letters
    public static String removeUppercaseLetters(String str) {
        return str.replaceAll("[A-Z]", "");
    }

    // 94. Remove All Lowercase Letters
    public static String removeLowercaseLetters(String str) {
        return str.replaceAll("[a-z]", "");
    }

    // 95. Find the Most Frequent Word in a String
    public static String mostFrequentWord(String str) {
        String[] words = str.toLowerCase().split("\\s+");
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    // 96. Count the Number of Words with Specific Length
    public static int countWordsOfLength(String str, int length) {
        String[] words = str.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.length() == length) {
                count++;
            }
        }
        return count;
    }

    // 97. Check if a String is a Valid Date (format: YYYY-MM-DD)
    public static boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    // 98. Remove All Spaces from a String
    public static String removeAllSpaces(String str) {
        return str.replace(" ", "");
    }

    // 99. Check if a String is a Valid Time (format: HH:MM)
    public static boolean isValidTime(String time) {
        return time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    // 100. Check if a String Contains a Specific Word
    public static boolean containsWord(String str, String word) {
        return str.split("\\s+").length > 0 && str.contains(word);
    }

    public static void main(String[] args) {
        // Example usage of the methods
        String testString = "Hello World! This is a test string.";

        System.out.println("Reversed: " + reverseString(testString));
        System.out.println("Is Empty: " + isEmpty(testString));
        //System.out.println("Word Count: " + wordCount(testString));
        System.out.println("Unique Characters: " + uniqueCharacters(testString));
        System.out.println("Most Frequent Character: " + mostFrequentCharacter(testString));
        System.out.println("Is Valid Email: " + isValidEmail("test@example.com"));
        System.out.println("To Pig Latin: " + toPigLatin("hello world"));
        System.out.println("Substring Index: " + substringIndex(testString, "World"));
        System.out.println("Shortest Word: " + shortestWord(testString));
        // Add more method calls as needed
    }
}
