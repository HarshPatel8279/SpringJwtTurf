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

    public static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
