//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.custom.eaii.training.api;

import com.custom.eaii.training.api.error.GlobalError;
import com.custom.eaii.training.api.error.ValidationError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import et.gov.customs.application.api.error.GlobalError;
//import et.gov.customs.application.api.error.ValidationError;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class Response<T> {
    protected T data;
    protected GlobalError error;
    protected List<ValidationError> validationErrors;
    protected String correlationId;
    protected String message;

    public Response() {
    }

    public Response(String correlationId) {
        this.correlationId = correlationId;
    }

    public Response(T data) {
        this.data = data;
    }

    public Response(T data, String correlationId, String message) {
        this(data);
        this.correlationId = correlationId;
        this.message = message;
    }

    public Response(GlobalError globalError, String correlationId, String message) {
        this(globalError, (List)null, correlationId, message);
    }

    public Response(List<ValidationError> validationErrors, String correlationId, String message) {
        this((GlobalError)null, validationErrors, correlationId, message);
    }

    public Response(GlobalError globalError, List<ValidationError> validationErrors, String correlationId, String message) {
        this((T)null, globalError, validationErrors, correlationId, message);
    }

    public static <T> ResponseBuilder<T> builder() {
        return new ResponseBuilder();
    }

    public T getData() {
        return this.data;
    }

    public GlobalError getError() {
        return this.error;
    }

    public List<ValidationError> getValidationErrors() {
        return this.validationErrors;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setError(GlobalError error) {
        this.error = error;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response(T data, GlobalError error, List<ValidationError> validationErrors, String correlationId, String message) {
        this.data = data;
        this.error = error;
        this.validationErrors = validationErrors;
        this.correlationId = correlationId;
        this.message = message;
    }

    public static class ResponseBuilder<T> {
        private T data;
        private GlobalError error;
        private List<ValidationError> validationErrors;
        private String correlationId;
        private String message;

        ResponseBuilder() {
        }

        public ResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseBuilder<T> error(GlobalError error) {
            this.error = error;
            return this;
        }

        public ResponseBuilder<T> validationErrors(List<ValidationError> validationErrors) {
            this.validationErrors = validationErrors;
            return this;
        }

        public ResponseBuilder<T> correlationId(String correlationId) {
            this.correlationId = correlationId;
            return this;
        }

        public ResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Response<T> build() {
            return new Response(this.data, this.error, this.validationErrors, this.correlationId, this.message);
        }

        public String toString() {
            return "Response.ResponseBuilder(data=" + this.data + ", error=" + this.error + ", validationErrors=" + this.validationErrors + ", correlationId=" + this.correlationId + ", message=" + this.message + ")";
        }
    }
}
