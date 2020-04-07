package br.com.qniversity.api.config.validation;

public class FormError {

    private String field;
    private String error;

    public FormError(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
