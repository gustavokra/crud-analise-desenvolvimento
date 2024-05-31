package org.acme.domain.utils;

import java.util.UUID;

import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.utils.exception.CrudException;

public class Utils {
    
        @SuppressWarnings("unchecked")
    public static <T> T nvl(Object arg0, T arg1) {
        if (arg0 instanceof String) {
            String a = (String) arg0;
            if (a.trim().isEmpty()) {
                return arg1;
            }
        }
        return (T) ((arg0 == null) ? arg1 : arg0);
    }

    public static UUID getUUIDfromStr(String str) {
        try {
            return UUID.fromString(str);
        } catch (Exception e) {
            throw new CrudException(EnumErrorCode.CAMPO_INVALIDO, "UUID");
        }
    }

}
