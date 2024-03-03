package me.renedo.naizfit.testers.domain;

public class Size {

    private final String value;

    public Size(String value) {
        this.value = value;
        verify();
    }

    public String getValue() {
        return value;
    }

    private void verify(){
        if(value == null || value.isEmpty()){
            throw new SizeEmptyException();
        }
    }
}
