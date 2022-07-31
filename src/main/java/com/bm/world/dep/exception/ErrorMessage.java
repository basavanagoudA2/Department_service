package com.bm.world.dep.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    String statusCode;
    String message;

    public ErrorMessage(String message) {
        this.message = message;
    }
}
