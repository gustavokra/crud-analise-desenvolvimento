package org.acme.domain.utils.exception;

import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.utils.StringUtil;

public class CrudException extends RuntimeException {
    
    private String errorCode = "-1";

    public CrudException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CrudException(EnumErrorCode error) {
        super(error.getErro());
        this.errorCode = error.getKey();
    }

    public CrudException(EnumErrorCode error, Object... args) {
        super(StringUtil.stringPatternFormat(error.getErro(), args));
        this.errorCode = error.getKey();
    }

    public String getErrorCode() {
        return errorCode;
    }

}
