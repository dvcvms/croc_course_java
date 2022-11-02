package ru.croc.task5;

public class Annotation {

    private String signature = "";

    public void setSignature(String signature) {
        this.signature = signature;
    }

    protected String getSignature() {
        return this.signature;
    }

    @Override
    public String toString() {
        return "";
    }
}
