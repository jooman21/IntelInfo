package com.custom.eaii.training.exceptions;

import com.custom.eaii.training.api.error.ValidationError;
import com.custom.eaii.training.constant.ErrorCodes;
import com.custom.eaii.training.util.Validator;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class ValidationErrorFactory {
    public ValidationErrorFactory() {
    }

    private static ValidationError validationError(String code, String message, String field) {
        ValidationError validationError = new ValidationError();
        validationError.setCode(code);
        validationError.setMessage(message);
        validationError.setField(field);
        return validationError;
    }

    public static void validateStringIsNull(String value, String fieldName, List<ValidationError> errors) {
        if (Validator.stringIsNull(value)) {
            ValidationError validationError = validationError(ErrorCodes.INPUT_NOT_NULL.getCode(), ErrorCodes.INPUT_NOT_NULL.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateStatusChecker(String value, String fieldName, List<ValidationError> errors) {
        if (Validator.statusChecker(value)) {
            ValidationError validationError = validationError(ErrorCodes.IS_NOT_ALLOWED_STATUS_TYPE.getCode(), ErrorCodes.IS_NOT_ALLOWED_STATUS_TYPE.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateIntegerIsNull(Integer value, String fieldName, List<ValidationError> errors) {
        if (Validator.integerIsNull(value)) {
            ValidationError validationError = validationError(ErrorCodes.INPUT_NOT_NULL.getCode(), ErrorCodes.INPUT_NOT_NULL.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateEmail(String value, String fieldName, List<ValidationError> errors) {
        boolean check = Validator.validEmail(value);
        if (!Validator.validEmail(value)) {
            ValidationError validationError = validationError(ErrorCodes.EMAIL_NOT_VALID.getCode(), ErrorCodes.EMAIL_NOT_VALID.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateStringHasWhiteSpace(String value, String fieldName, List<ValidationError> errors) {
        if (Validator.stringHasWhiteSpace(value)) {
            ValidationError validationError = validationError(ErrorCodes.STRING_WHITESPACE_NOT_ALLOWED.getCode(), ErrorCodes.STRING_WHITESPACE_NOT_ALLOWED.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateObjectHasWhiteSpace(Object obj, String fieldName, List<ValidationError> errors) {
        if (Validator.objectWhiteSpace(obj)) {
            ValidationError validationError = validationError(ErrorCodes.STRING_WHITESPACE_NOT_ALLOWED.getCode(), ErrorCodes.STRING_WHITESPACE_NOT_ALLOWED.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateIntegerHasWhiteSpace(Integer value, String fieldName, List<ValidationError> errors) {
        if (Validator.integerHasWhiteSpace(value)) {
            ValidationError validationError = validationError(ErrorCodes.INTEGER_WHITESPACE_NOT_ALLOWED.getCode(), ErrorCodes.INTEGER_WHITESPACE_NOT_ALLOWED.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validatePhoneNumber(String value, String fieldName, List<ValidationError> errors) {
        if (Validator.validPhoneNumber(value)) {
            ValidationError validationError = validationError(ErrorCodes.INPUT_NOT_NULL.getCode(), ErrorCodes.INPUT_NOT_NULL.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateUUIDIsNull(UUID value, String fieldName, List<ValidationError> errors) {
        if (Validator.UUIDIsNull(value)) {
            ValidationError validationError = validationError(ErrorCodes.UUID_NOT_NULL.getCode(), ErrorCodes.UUID_NOT_NULL.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateSpecialCharacterNotAllowed(String value, String fieldName, List<ValidationError> errors) {
        if (Validator.validSpecialCharactersNotAllowed(value)) {
            ValidationError validationError = validationError(ErrorCodes.SPECIAL_CHARACTERS_NOT_ALLOWED.getCode(), ErrorCodes.SPECIAL_CHARACTERS_NOT_ALLOWED.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validFloatIsNull(Float value, String fieldName, List<ValidationError> errors) {
        if (Validator.floatIsNull(value)) {
            ValidationError validationError = validationError(ErrorCodes.INPUT_NOT_NULL.getCode(), ErrorCodes.INPUT_NOT_NULL.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateFloatHasWhiteSpace(Float value, String fieldName, List<ValidationError> errors) {
        if (Validator.floatHasWhiteSpace(value)) {
            ValidationError validationError = validationError(ErrorCodes.STRING_WHITESPACE_NOT_ALLOWED.getCode(), ErrorCodes.STRING_WHITESPACE_NOT_ALLOWED.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateIsCriteriaTrue(String value, String fieldName, List<ValidationError> errors) {
        if (Validator.isCriteriaTrue(value)) {
            ValidationError validationError = validationError(ErrorCodes.IS_CRITERIA_VALID.getCode(), ErrorCodes.IS_CRITERIA_VALID.getMessage(), fieldName);
            errors.add(validationError);
        }

    }

    public static void validateDate(String value, Pattern pattern, String fieldName, List<ValidationError> errors) {
        if (!Validator.validDateFormat(value, pattern)) {
            ValidationError validationError = validationError(ErrorCodes.DATE_NOT_VALID.getCode(), ErrorCodes.DATE_NOT_VALID.getMessage(), fieldName);
            errors.add(validationError);
        }

    }
}
