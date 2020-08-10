package com.github.dsfb.app31576623.view;

public interface TextView {

    public void setText(String text);
    public String getText();
    public void addTextViewObserver(TextViewObserver observer);
    public void removeTextViewObserver(TextViewObserver observer);

}