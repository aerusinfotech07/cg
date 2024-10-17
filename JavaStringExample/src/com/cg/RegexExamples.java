package com.cg;

import java.util.regex.*;
import java.util.*;

public class RegexExamples {
	
	public static void main(String args[])
	{
		String str="This is a test  ing is fun test !";
		System.out.println(isValidPasswordWithSymbol("#00Lord"));
	}

    // 1. Check if a string is a valid email address
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return Pattern.matches(regex, email);
    }

    // 2. Check if a string is a valid phone number (10 digits)
    public static boolean isValidPhoneNumber(String phone) {
        String regex = "^\\d{10}$";
        return Pattern.matches(regex, phone);
    }

    // 3. Check if a string contains only digits
    public static boolean containsOnlyDigits(String str) {
        String regex = "^\\d+$";
        return Pattern.matches(regex, str);
    }

    // 4. Check if a string contains only letters
    public static boolean containsOnlyLetters(String str) {
        String regex = "^[a-zA-Z]+$";
        return Pattern.matches(regex, str);
    }
    
    /*
     * Valid IP Addresses
192.168.0.1: Commonly used in home networks, this address consists of four numbers between 0 and 255.
10.0.0.1: Often found in corporate networks, this address is part of a private IP range.
172.16.0.1: This address falls within a private IP range and follows all the rules.
127.0.0.1: Known as the loopback address, it refers back to your own device.
Invalid IP Addresses
256.168.0.1: Invalid because the first number exceeds 255.
192.168.0.300: Invalid since the last number exceeds 255.
192.168.1: Incomplete address; it lacks the required four numbers.
192.168.01.1: Invalid due to the leading zero in “01.”
192.168.0.0/24: Contains a subnet mask notation, which isn’t part of the IP address itself.
0.0.0.0: Reserved for special purposes and can’t be assigned to a device.

     */

    // 5. Check if a string is a valid IP address (IPv4)
    public static boolean isValidIPv4(String ip) {
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(regex, ip);
    }

    // 6. Extract all digits from a string
    //my value is 8090989898 and before it was 97897676556 and value is 67 3023
    public static List<String> extractDigits(String str) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> digits = new ArrayList<>();
        while (matcher.find()) {
            digits.add(matcher.group());
        }
        return digits;
    }

    // 7. Replace all whitespace with a single space
    //I love   india
    public static String replaceWhitespace(String str) {
        return str.replaceAll("\\s+", " ");
    }

    // 8. Check if a string is a valid URL
    public static boolean isValidURL(String url) {
        String regex = "^(http|https)://.*$";
        return Pattern.matches(regex, url);
    }

    // 9. Check if a string is a valid hex color code
    public static boolean isValidHexColor(String color) {
        String regex = "^#([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})$";
        return Pattern.matches(regex, color);
    }

    // 10. Extract email addresses from a text
    public static List<String> extractEmails(String text) {
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> emails = new ArrayList<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    // 11. Check if a string is a valid credit card number (basic validation)
    public static boolean isValidCreditCard(String ccNumber) {
        String regex = "^\\d{16}$";
        return Pattern.matches(regex, ccNumber);
    }

    // 12. Validate a date in the format YYYY-MM-DD
    public static boolean isValidDate(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(regex, date);
    }

    // 13. Count the number of occurrences of a substring
    public static int countSubstringOccurrences(String str, String substr) {
        String regex = Pattern.quote(substr);
        Matcher matcher = Pattern.compile(regex).matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    // 14. Check if a string is a valid zip code (5 digits)
    public static boolean isValidZipCode(String zip) {
        String regex = "^\\d{5}$";
        return Pattern.matches(regex, zip);
    }

    // 15. Extract all words 12 from 56 a string
    public static List<String> extractWords(String str) {
        String regex = "\\b\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 16. Check if a string contains special characters
    public static boolean containsSpecialCharacters(String str) {
        String regex = ".*[^a-zA-Z0-9].*";
        return Pattern.matches(regex, str);
    }

    // 17. Remove all non-alphanumeric characters
    public static String removeNonAlphanumeric(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    // 18. Check if a string is a valid time (HH:MM)
    public static boolean isValidTime(String time) {
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        return Pattern.matches(regex, time);
    }

    // 19. Validate a password (minimum 8 characters, at least one letter and one number and Symbol)
    /*
     * Explanation of the Regex:
		^ : Asserts the start of the string.
		(?=.*[a-zA-Z]) : Ensures at least one letter (uppercase or lowercase) exists.
		(?=.*\d) : Ensures at least one digit exists.
		(?=.*[\W_]) : Ensures at least one special character exists (non-word character, including symbols).
		.{8,} : Ensures the total length is at least 8 characters.
		$ : Asserts the end of the string.

     */
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return Pattern.matches(regex, password);
    }
    // it must be at least 8 characters long, contain at least one letter, one number, and one symbol.
    public static boolean isValidPasswordWithAnySymbol(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$";
        return Pattern.matches(regex, password);
    }
    /*Explanation of the Updated Regex:
	^ : Asserts the start of the string.
	(?=.*[a-zA-Z]) : Ensures at least one letter (uppercase or lowercase) exists.
	(?=.*\d) : Ensures at least one digit exists.
	(?=.*[@$*#]) : Ensures at least one of the specified symbols (@, $, *, #) exists.
	.{8,} : Ensures the total length is at least 8 characters.
	$ : Asserts the end of the string.
	*/
 // it must be at least 8 characters long, contain at least one letter, one number, and one symbol (@, $,*,#).
    public static boolean isValidPasswordWithSymbol(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$*#]).{6,}$";
        return Pattern.matches(regex, password);
    }

    // 20. Extract hashtags from a string
    public static List<String> extractHashtags(String text) {
        String regex = "#\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> hashtags = new ArrayList<>();
        while (matcher.find()) {
            hashtags.add(matcher.group());
        }
        return hashtags;
    }

    // 21. Check if a string is a valid social security number (SSN)
    public static boolean isValidSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return Pattern.matches(regex, ssn);
    }

    // 22. Check if a string is a valid MAC address
    public static boolean isValidMACAddress(String mac) {
        String regex = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
        return Pattern.matches(regex, mac);
    }

    // 23. Find all words starting with a specific letter
    public static List<String> wordsStartingWith(String str, char letter) {
        String regex = "\\b" + letter + "\\w*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 24. Extract all lowercase letters from a string
    public static List<String> extractLowercaseLetters(String str) {
        String regex = "[a-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> letters = new ArrayList<>();
        while (matcher.find()) {
            letters.add(matcher.group());
        }
        return letters;
    }

    // 25. Extract all uppercase letters from a string
    public static List<String> extractUppercaseLetters(String str) {
        String regex = "[A-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> letters = new ArrayList<>();
        while (matcher.find()) {
            letters.add(matcher.group());
        }
        return letters;
    }

    // 26. Count the number of vowels in a string
    //Count no of time digits(hello rohan my age is 23 year of birth is 2012 and 2011)
    public static int countVowels(String str) {
        String regex = "[aeiouAEIOU]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    // 27. Count the number of consonants in a string
    public static int countConsonants(String str) {
        String regex = "[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    // 28. Validate a string as a valid bank account number
    public static boolean isValidBankAccountNumber(String accountNumber) {
        String regex = "^\\d{10}$";
        return Pattern.matches(regex, accountNumber);
    }

    // 29. Find all repeated words in a string
    public static List<String> findRepeatedWords(String str) {
        String regex = "\\b(\\w+)\\b.*?\\b\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        List<String> repeatedWords = new ArrayList<>();
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        return repeatedWords;
    }

    // 30. Validate a string for HTML tags
    public static boolean hasValidHTMLTags(String str) {
        String regex = "<([a-zA-Z][a-zA-Z0-9]*)\\b[^>]*>(.*?)</\\1>";
        return Pattern.matches(regex, str);
    }

    // 31. Extract all digits from a string
    public static List<String> extractAllDigits(String str) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> digits = new ArrayList<>();
        while (matcher.find()) {
            digits.add(matcher.group());
        }
        return digits;
    }

    // 32. Validate a string as a valid username (alphanumeric, 5-15 characters)
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z0-9]{5,15}$";
        return Pattern.matches(regex, username);
    }

    // 33. Check if a string contains only whitespace
    public static boolean containsOnlyWhitespace(String str) {
        String regex = "^\\s*$";
        return Pattern.matches(regex, str);
    }

    // 34. Validate a string as a valid file extension
    public static boolean isValidFileExtension(String filename) {
        String regex = "^.+\\.(txt|pdf|doc|jpg|png)$";
        return Pattern.matches(regex, filename);
    }

    // 35. Check if a string contains a specific substring
    public static boolean containsSubstring(String str, String substr) {
        String regex = Pattern.quote(substr);
        return Pattern.compile(regex).matcher(str).find();
    }

    // 36. Extract all lines that start with a specific character
    public static List<String> extractLinesStartingWith(String text, char character) {
        String regex = "^" + character + ".*$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        List<String> lines = new ArrayList<>();
        while (matcher.find()) {
            lines.add(matcher.group());
        }
        return lines;
    }

    // 37. Check if a string is a valid UUID
    public static boolean isValidUUID(String uuid) {
        String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
        return Pattern.matches(regex, uuid);
    }

    // 38. Validate a string as a valid integer
    public static boolean isValidInteger(String num) {
        String regex = "^-?\\d+$";
        return Pattern.matches(regex, num);
    }

    // 39. Validate a string as a valid floating-point number
    public static boolean isValidFloat(String num) {
        String regex = "^-?\\d+\\.\\d+$";
        return Pattern.matches(regex, num);
    }

    // 40. Extract all sentences from a string
    public static List<String> extractSentences(String text) {
        String regex = "[^.!?]+[.!?]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group().trim());
        }
        return sentences;
    }

    // 41. Check if a string is a valid vehicle registration number
    public static boolean isValidVehicleRegistration(String reg) {
        String regex = "^[A-Z]{2}\\d{2} [A-Z]{1,2} \\d{1,4}$";
        return Pattern.matches(regex, reg);
    }

    // 42. Extract domain names from URLs
    public static List<String> extractDomainNames(String url) {
        String regex = "https?://([^/]+)/?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        List<String> domains = new ArrayList<>();
        while (matcher.find()) {
            domains.add(matcher.group(1));
        }
        return domains;
    }

    // 43. Find all repeated characters in a string
    public static List<Character> findRepeatedCharacters(String str) {
        String regex = "(.)\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<Character> repeatedChars = new ArrayList<>();
        while (matcher.find()) {
            repeatedChars.add(matcher.group(1).charAt(0));
        }
        return repeatedChars;
    }

    // 44. Validate a string as a valid OTP (One Time Password)
    public static boolean isValidOTP(String otp) {
        String regex = "^\\d{6}$";
        return Pattern.matches(regex, otp);
    }

    // 45. Check if a string contains HTML tags
    public static boolean containsHTMLTags(String str) {
        String regex = "<[^>]+>";
        return Pattern.compile(regex).matcher(str).find();
    }

    // 46. Replace all HTML tags with an empty string
    public static String removeHTMLTags(String str) {
        return str.replaceAll("<[^>]+>", "");
    }

    // 47. Validate a string as a valid Indian mobile number
    public static boolean isValidIndianMobileNumber(String number) {
        String regex = "^[789]\\d{9}$";
        return Pattern.matches(regex, number);
    }

    // 48. Extract all words that are exactly N letters long
    public static List<String> extractWordsOfLength(String str, int length) {
        String regex = "\\b\\w{" + length + "}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 49. Check if a string contains valid XML
    public static boolean isValidXML(String xml) {
        String regex = "<([a-zA-Z]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)";
        return Pattern.matches(regex, xml);
    }

    // 50. Validate a string as a valid ISBN-10 number
    public static boolean isValidISBN10(String isbn) {
        String regex = "^(?=[0-9X]{10}$)(?:[0-9]{9}[0-9X])$";
        return Pattern.matches(regex, isbn);
    }

    // 51. Validate a string as a valid ISBN-13 number
    public static boolean isValidISBN13(String isbn) {
        String regex = "^(978|979)\\d{9}[0-9X]$";
        return Pattern.matches(regex, isbn);
    }

    // 52. Check if a string is a valid license plate number (format: ABC-1234)
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{3}-\\d{4}$";
        return Pattern.matches(regex, plate);
    }

    // 53. Extract all dates from a string in the format DD/MM/YYYY
    public static List<String> extractDates(String text) {
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> dates = new ArrayList<>();
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }

    // 54. Validate a string as a valid Turkish ID number
    public static boolean isValidTurkishID(String id) {
        String regex = "^(1[0-9]{10})$";
        return Pattern.matches(regex, id);
    }

    // 55. Extract all occurrences of a word ignoring case
    public static List<String> extractWordIgnoringCase(String str, String word) {
        String regex = "(?i)\\b" + Pattern.quote(word) + "\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> occurrences = new ArrayList<>();
        while (matcher.find()) {
            occurrences.add(matcher.group());
        }
        return occurrences;
    }

    // 56. Validate a string as a valid Indian Aadhaar number
    public static boolean isValidAadhaar(String aadhaar) {
        String regex = "^\\d{4}-\\d{4}-\\d{4}$";
        return Pattern.matches(regex, aadhaar);
    }

    // 57. Check if a string contains only uppercase letters
    public static boolean containsOnlyUppercase(String str) {
        String regex = "^[A-Z]+$";
        return Pattern.matches(regex, str);
    }

    // 58. Validate a string as a valid bank IFSC code
    public static boolean isValidIFSC(String ifsc) {
        String regex = "^[A-Z]{4}0[A-Z0-9]{6}$";
        return Pattern.matches(regex, ifsc);
    }

    // 59. Validate a string as a valid VAT number
    public static boolean isValidVAT(String vat) {
        String regex = "^[A-Z]{2}\\d{9}$";
        return Pattern.matches(regex, vat);
    }

    // 60. Extract all words with more than N characters
    public static List<String> extractWordsLongerThan(String str, int n) {
        String regex = "\\b\\w{" + (n + 1) + ",}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 61. Validate a string as a valid time zone (e.g., GMT+5)
    public static boolean isValidTimeZone(String timezone) {
        String regex = "^GMT[+-]\\d{1,2}$";
        return Pattern.matches(regex, timezone);
    }

    // 62. Extract all numbers (integers and decimals) from a string
    public static List<String> extractNumbers(String str) {
        String regex = "-?\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(matcher.group());
        }
        return numbers;
    }

    // 63. Validate a string as a valid Latin-1 character
    public static boolean isValidLatin1(String str) {
        String regex = "[\\x00-\\xFF]*";
        return Pattern.matches(regex, str);
    }

    // 64. Check if a string is a valid negative number
    public static boolean isValidNegativeNumber(String num) {
        String regex = "^-\\d+(\\.\\d+)?$";
        return Pattern.matches(regex, num);
    }

    // 65. Extract all unique characters from a string
    public static List<Character> extractUniqueCharacters(String str) {
        String regex = "(.)";
        Set<Character> uniqueChars = new HashSet<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            uniqueChars.add(matcher.group(1).charAt(0));
        }
        return new ArrayList<>(uniqueChars);
    }

    // 66. Validate a string as a valid Russian phone number
    public static boolean isValidRussianPhoneNumber(String phone) {
        String regex = "^\\+7\\d{10}$";
        return Pattern.matches(regex, phone);
    }

    // 67. Check if a string contains balanced parentheses
    public static boolean hasBalancedParentheses(String str) {
        String regex = "^([^()]*|(\\([^()]*\\))*[^()]*$";
        return Pattern.matches(regex, str);
    }

    // 68. Validate a string as a valid stock ticker symbol
    public static boolean isValidTickerSymbol(String symbol) {
        String regex = "^[A-Z]{1,4}$";
        return Pattern.matches(regex, symbol);
    }

    // 69. Validate a string as a valid domain name
    public static boolean isValidDomainName(String domain) {
        String regex = "^(?!-)[A-Za-z0-9-]{1,63}(?<!-)$";
        return Pattern.matches(regex, domain);
    }

    // 70. Extract all numeric values greater than a given number
    public static List<Integer> extractNumbersGreaterThan(String str, int threshold) {
        String regex = "\\d+";
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            if (num > threshold) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    // 71. Extract all words that end with a specific letter
    public static List<String> wordsEndingWith(String str, char letter) {
        String regex = "\\b\\w*" + letter + "\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 72. Check if a string contains a palindrome
    public static boolean containsPalindrome(String str) {
        String regex = "(?<!\\w)(\\w+)(?=.*\\1)";
        return Pattern.compile(regex).matcher(str).find();
    }

    // 73. Extract the first N words from a string
    public static List<String> extractFirstNWords(String str, int n) {
        String regex = "\\b\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find() && words.size() < n) {
            words.add(matcher.group());
        }
        return words;
    }

    // 74. Extract all floating point numbers from a string
    public static List<Double> extractFloatingPoints(String str) {
        String regex = "-?\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<Double> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Double.parseDouble(matcher.group()));
        }
        return numbers;
    }

    // 75. Validate a string as a valid Docker image name
    public static boolean isValidDockerImageName(String name) {
        String regex = "^[a-z0-9]+(?:[._-][a-z0-9]+)*$";
        return Pattern.matches(regex, name);
    }

    // 76. Extract all words with repeating characters
    public static List<String> extractWordsWithRepeatingChars(String str) {
        String regex = "\\b(\\w*([a-zA-Z])\\2+\\w*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 77. Validate a string as a valid API key (32 characters)
    public static boolean isValidAPIKey(String key) {
        String regex = "^[a-f0-9]{32}$";
        return Pattern.matches(regex, key);
    }

    // 78. Count the number of words in a string
    public static int countWords(String str) {
        String regex = "\\b\\w+\\b";
        return str.split(regex).length - 1;
    }

    // 79. Validate a string as a valid Portuguese ID number
    public static boolean isValidPortugueseID(String id) {
        String regex = "^\\d{9}$";
        return Pattern.matches(regex, id);
    }

    // 80. Extract all words with less than N characters
    public static List<String> extractWordsShorterThan(String str, int n) {
        String regex = "\\b\\w{1," + (n - 1) + "}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 81. Validate a string as a valid RFC 3339 date
    public static boolean isValidRFC3339(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(Z|[+-]\\d{2}:\\d{2})$";
        return Pattern.matches(regex, date);
    }

    // 82. Check if a string is a valid HTML entity
    public static boolean isValidHTMLEntity(String entity) {
        String regex = "^&[a-zA-Z]+;$";
        return Pattern.matches(regex, entity);
    }

    // 83. Validate a string as a valid UK National Insurance number
    public static boolean isValidNIN(String nin) {
        String regex = "^[A-CEGHJ-NPR-TW-Z]{1}[A-CEGHJ-NPR-TW-Z]{1}\\d{6}[A-D]{0,1}$";
        return Pattern.matches(regex, nin);
    }

    // 84. Extract all words with a specific vowel
    public static List<String> extractWordsWithVowel(String str, char vowel) {
        String regex = "\\b\\w*" + vowel + "\\w*\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 85. Validate a string as a valid German postal code
    public static boolean isValidGermanPostalCode(String code) {
        String regex = "^\\d{5}$";
        return Pattern.matches(regex, code);
    }

    // 86. Validate a string as a valid Croatian personal identification number
    public static boolean isValidPIN(String pin) {
        String regex = "^\\d{11}$";
        return Pattern.matches(regex, pin);
    }

    // 87. Extract all sentences that contain a specific word
    public static List<String> extractSentencesContaining(String text, String word) {
        String regex = "[^.!?]*\\b" + Pattern.quote(word) + "\\b[^.!?]*[.!?]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group().trim());
        }
        return sentences;
    }

    // 88. Validate a string as a valid Japanese postal code
    public static boolean isValidJapanesePostalCode(String code) {
        String regex = "^\\d{3}-\\d{4}$";
        return Pattern.matches(regex, code);
    }

    // 89. Validate a string as a valid South African ID number
    public static boolean isValidSouthAfricanID(String id) {
        String regex = "^\\d{6}\\d{4}\\d{1}$";
        return Pattern.matches(regex, id);
    }

    // 90. Extract all capitalized words from a string
    public static List<String> extractCapitalizedWords(String str) {
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    // 91. Validate a string as a valid hexadecimal color code
    public static boolean isValidHexColorA(String color) {
        String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        return Pattern.matches(regex, color);
    }

    // 92. Check if a string is a valid HTTP/HTTPS URL
    public static boolean isValidURLA(String url) {
        String regex = "^(https?://)[^\\s/$.?#].[^\\s]*$";
        return Pattern.matches(regex, url);
    }

    // 93. Validate a string as a valid US zip code
    public static boolean isValidUSZipCode(String zip) {
        String regex = "^\\d{5}(-\\d{4})?$";
        return Pattern.matches(regex, zip);
    }

    // 94. Extract all words that are anagrams of a given word
    public static List<String> extractAnagrams(String str, String targetWord) {
        String regex = "\\b" + Pattern.quote(targetWord) + "\\b";
        List<String> anagrams = new ArrayList<>();
        for (String word : str.split("\\s+")) {
            if (areAnagrams(word, targetWord)) {
                anagrams.add(word);
            }
        }
        return anagrams;
    }

    private static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // 95. Check if a string contains a specific character multiple times
    /*public static boolean containsCharacterMultipleTimes(String str, char c, int n) {
        String regex = String.valueOf(c);
        return Pattern.compile(regex).matcher(str).results().count() >= n;
    }*/

    // 96. Count the number of sentences in a string
    public static int countSentences(String str) {
        String regex = "[^.!?]+";
        return str.split(regex).length - 1;
    }

    // 97. Validate a string as a valid South Korean ID number
    public static boolean isValidKoreanID(String id) {
        String regex = "^\\d{6}-\\d{7}$";
        return Pattern.matches(regex, id);
    }

    // 98. Extract all unique words from a string
    public static List<String> extractUniqueWords(String str) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(str.split("\\s+")));
        return new ArrayList<>(uniqueWords);
    }

    // 99. Check if a string contains a specific substring at the start
    public static boolean startsWithSubstring(String str, String substr) {
        return str.startsWith(substr);
    }

    // 100. Count the number of unique characters in a string
    public static int countUniqueCharacters(String str) {
        return (int) str.chars().distinct().count();
    }
}
