package com.custom.eaii.training.util.notification.email;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);
    public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);
    public static final Pattern SPECIAL_CHARACTERS_NOT_ALLOWED = Pattern.compile("^[a-zA-Z0-9 ]+$", 2);
    public static final Pattern STRING_WHITESPACE_NOT_ALLOWED = Pattern.compile("^\\S+(\\s+\\S+)*$", 2);
    public static final Pattern INTEGER_WHITESPACE_NOT_ALLOWED = Pattern.compile("^\\S+(\\s+\\S+)*$", 2);

    public Validator() {
    }

    public static boolean stringIsNull(String value) {
        return value == null || value == "";
    }

    public static boolean statusChecker(String value) {
        return !String.valueOf(value).equals("ACTIVE") && !String.valueOf(value).equals("INACTIVE");
    }

    public static boolean UUIDIsNull(UUID value) {
        return value == null;
    }

    public static boolean isCriteriaTrue(String value) {
        boolean b = String.valueOf(value).equals("Active");
        return !String.valueOf(value).equals("Active") && !String.valueOf(value).equals("Inactive") && !String.valueOf(value).equals("Pending");
    }

    public static boolean integerIsNull(Integer value) {
        return value == 0;
    }

    public static boolean floatIsNull(Float value) {
        return (double)value == 0.0;
    }

    public static boolean floatHasWhiteSpace(Float value) {
        Matcher matcher = STRING_WHITESPACE_NOT_ALLOWED.matcher(String.valueOf(value));
        return !matcher.matches();
    }

    public static boolean stringHasWhiteSpace(String value) {
        Matcher matcher = STRING_WHITESPACE_NOT_ALLOWED.matcher(value);
        return !matcher.matches();
    }

    public static boolean objectWhiteSpace(Object obj) {
        Matcher matcher = STRING_WHITESPACE_NOT_ALLOWED.matcher(obj.toString());
        return !matcher.matches();
    }

    public static boolean integerHasWhiteSpace(Integer value) {
        Matcher matcher = INTEGER_WHITESPACE_NOT_ALLOWED.matcher(String.valueOf(value));
        return !matcher.matches();
    }

    public static boolean validSpecialCharactersNotAllowed(String value) {
        Matcher matcher = SPECIAL_CHARACTERS_NOT_ALLOWED.matcher(value);
        return !matcher.matches();
    }

    public static boolean validEmail(String value) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);
        return matcher.matches();
    }

    public static boolean validDateFormat(String value, Pattern pattern) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean validPhoneNumber(String value) {
        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(value);
        return matcher.matches();
    }

    public static boolean hasContainsElement(List lists, String element) {
        return lists.contains(element);
    }

    public static boolean fileIsNull(MultipartFile file) {
        return file == null;
    }
}
