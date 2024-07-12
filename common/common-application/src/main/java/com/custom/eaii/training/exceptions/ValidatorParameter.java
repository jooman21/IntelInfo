package com.custom.eaii.training.exceptions;

import com.custom.eaii.training.constant.ErrorCodes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.regex.Pattern;

public class ValidatorParameter {
    private String field;
    private String value;
    private MultipartFile file;
    private ErrorCodes errorCodes;
    private List list;
    private Pattern pattern;

    ValidatorParameter(String field, String value, MultipartFile file, ErrorCodes errorCodes, List list, Pattern pattern) {
        this.field = field;
        this.value = value;
        this.file = file;
        this.errorCodes = errorCodes;
        this.list = list;
        this.pattern = pattern;
    }

    public static ValidatorParameterBuilder builder() {
        return new ValidatorParameterBuilder();
    }

    public String getField() {
        return this.field;
    }

    public String getValue() {
        return this.value;
    }

    public MultipartFile getFile() {
        return this.file;
    }

    public ErrorCodes getErrorCodes() {
        return this.errorCodes;
    }

    public List getList() {
        return this.list;
    }

    public Pattern getPattern() {
        return this.pattern;
    }

    public static class ValidatorParameterBuilder {
        private String field;
        private String value;
        private MultipartFile file;
        private ErrorCodes errorCodes;
        private List list;
        private Pattern pattern;

        ValidatorParameterBuilder() {
        }

        public ValidatorParameterBuilder field(String field) {
            this.field = field;
            return this;
        }

        public ValidatorParameterBuilder value(String value) {
            this.value = value;
            return this;
        }

        public ValidatorParameterBuilder file(MultipartFile file) {
            this.file = file;
            return this;
        }

        public ValidatorParameterBuilder errorCodes(ErrorCodes errorCodes) {
            this.errorCodes = errorCodes;
            return this;
        }

        public ValidatorParameterBuilder list(List list) {
            this.list = list;
            return this;
        }

        public ValidatorParameterBuilder pattern(Pattern pattern) {
            this.pattern = pattern;
            return this;
        }

        public ValidatorParameter build() {
            return new ValidatorParameter(this.field, this.value, this.file, this.errorCodes, this.list, this.pattern);
        }

        public String toString() {
            return "ValidatorParameter.ValidatorParameterBuilder(field=" + this.field + ", value=" + this.value + ", file=" + this.file + ", errorCodes=" + this.errorCodes + ", list=" + this.list + ", pattern=" + this.pattern + ")";
        }
    }
}
