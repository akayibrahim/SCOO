package com.iakay.scoo.exception;

/**
 * Created by iakay on 2020-01-18.
 */
public enum ExceptionType {
    ADD_PICTURE_INPUT_STREAM_ERROR(1L, "Resim ekleme sırasında hata oluştu. Detay: %s");

    private long errorCode;
    private String errorMessage;

    ExceptionType(long errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String toString(String... errorMessage) {
        return String.format(this.errorMessage, errorMessage);
    }

    public String toString(Exception ex) {
        return String.format(this.errorMessage, ex.getMessage());
    }
}
