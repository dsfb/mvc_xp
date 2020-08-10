package com.github.dsfb.app31576623.model;

public class SimpleTextModel implements TextModel {

    private String text = "This is some text";

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

}