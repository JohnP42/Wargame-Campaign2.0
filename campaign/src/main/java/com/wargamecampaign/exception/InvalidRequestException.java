package com.wargamecampaign.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 3/9/20にjohnpolhilによって作成されました。
 */
@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {
    private Object model;
    private String modelName;
    private String view;

    public InvalidRequestException(String message, String view, Object model) {
        super(message);
        this.model = model;
        this.view = view;
        setModelName();
    }

    private void setModelName() {
        char c[] = model.getClass().getSimpleName().toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        modelName = new String(c);
    }

}
