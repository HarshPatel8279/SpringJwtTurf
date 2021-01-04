package com.SpringJwtTurf.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtilities {
    public final static String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    //if given username is Email or PhoneNumber
    public static String findEmailIdOrPhoneValidator(String username){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        if(matcher.matches()){
            return "email";
        }
        else{
            return "phone";
        }

    }

}
