package com.wizz.sentencelib.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape=JsonFormat.Shape.OBJECT)
public enum CommonResponse {
    SUCCESS("200", "success"),
    REPEAT("403", "sentence collected"),
    NOTFIND("404", "sentence non-exist");

    String responseCode, message;

    CommonResponse(String responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }
}
