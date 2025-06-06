package com.scrub.pro.scrubPro.DTOs;

import com.scrub.pro.scrubPro.Models.Board;
public class ApiResponseDTO<T> {
    private final boolean success;
    private final String Message;
    private final T data;

    public ApiResponseDTO(boolean success, String message, T data) {
        this.success = success;
        Message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return Message;
    }

    public T getData() {
        return data;
    }
}
