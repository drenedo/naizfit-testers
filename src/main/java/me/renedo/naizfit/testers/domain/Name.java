package me.renedo.naizfit.testers.domain;

public class Name {

    private final String value;

    public Name(String value) {
        this.value = value;
        verify();
    }

    public String getValue() {
        return value;
    }

    private void verify(){
        if(value == null || value.isEmpty()){
            throw new NameEmptyException();
        }
    }
}
