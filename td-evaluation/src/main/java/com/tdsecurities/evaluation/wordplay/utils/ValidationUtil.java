package com.tdsecurities.evaluation.wordplay.utils;

/**
 * Created by Raja on 11/10/2015.
 */
public final class ValidationUtil {

    public static final void illegalArgumentIfNull(final String label, final String value){

        if(value == null || value.trim().length() ==0){
            throw new IllegalArgumentException(label + " cannot be null or blank");
        }
    }
}
