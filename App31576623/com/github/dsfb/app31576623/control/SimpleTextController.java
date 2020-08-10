package com.github.dsfb.app31576623.control;

import com.github.dsfb.app31576623.model.TextModel;
import com.github.dsfb.app31576623.view.TextView;
import com.github.dsfb.app31576623.view.TextViewObserver;
import java.util.Objects;

public class SimpleTextController implements TextViewController, TextViewObserver {

    private TextView view;
    private TextModel model;

    public SimpleTextController(TextView view, TextModel model) {
        this.view = Objects.requireNonNull(view, "TextView can not null");
        this.model = Objects.requireNonNull(model, "TextModel can not be null");
        view.addTextViewObserver(this);
    }

    @Override
    public TextView getTextView() {
        return view;
    }

    @Override
    public TextModel getTextModel() {
        return model;
    }

    @Override
    public void textWasChanged(TextView view) {
        getTextModel().setText(view.getText());
    }
}