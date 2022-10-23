package ru.croc.task4;

public class Comment {
    private String str;
    private int lengthStr;

    private String newStr;
    public int i;
    public boolean flag;

    public StringBuilder builder;

    public Comment() {
        this.newStr = "";
        this.builder = new StringBuilder();
        this.i = 0;
        this.lengthStr = 0;
        this.flag = true;
    }

    public void setStr(String str) {
        this.str = str;
        this.lengthStr = str.length();
    }

    public int getLengthStr() {
        return lengthStr;
    }

    public char getCharAtStr(int index) {
        return this.str.charAt(index);
    }

    public void setNewStr(StringBuilder builder) {
        this.newStr = builder.toString();
    }

    public String getNewStr() {
        return newStr;
    }
}