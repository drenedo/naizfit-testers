package me.renedo.naizfit.testers.domain;

public class SKU {

    private final String value;

    public SKU(String value) {
        this.value = value;
        verify();
    }

    public String getValue() {
        return value;
    }

    private void verify(){
        if(value == null || value.isEmpty()){
            throw new SKUEmptyException();
        }
    }
}
