package me.renedo.naizfit.testers.domain;

public class Email {

    private final static String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    private final String value;


    public Email(String value) {
        this.value = value;
        verify();
    }

    public String getValue() {
        return value;
    }

    private void verify(){
        if(value == null || value.isEmpty()){
            throw new EmailEmptyException();
        }
        if(!value.matches(EMAIL_REGEX)){
            throw new EmailInvalidException();
        }
    }
}
