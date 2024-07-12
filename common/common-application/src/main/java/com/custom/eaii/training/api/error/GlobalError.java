package com.custom.eaii.training.api.error;

public class GlobalError {
    private String code;
    private String displayCode;
    private String message;

    GlobalError(String code, String displayCode, String message) {
        this.code = code;
        this.displayCode = displayCode;
        this.message = message;
    }

    public static GlobalErrorBuilder builder() {
        return new GlobalErrorBuilder();
    }

    public String getCode() {
        return this.code;
    }

    public String getDisplayCode() {
        return this.displayCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class GlobalErrorBuilder {
        private String code;
        private String displayCode;
        private String message;

        GlobalErrorBuilder() {
        }

        public GlobalErrorBuilder code(String code) {
            this.code = code;
            return this;
        }

        public GlobalErrorBuilder displayCode(String displayCode) {
            this.displayCode = displayCode;
            return this;
        }

        public GlobalErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public GlobalError build() {
            return new GlobalError(this.code, this.displayCode, this.message);
        }

        public String toString() {
            return "GlobalError.GlobalErrorBuilder(code=" + this.code + ", displayCode=" + this.displayCode + ", message=" + this.message + ")";
        }
    }
}
