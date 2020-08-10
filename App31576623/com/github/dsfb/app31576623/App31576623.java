package com.github.dsfb.app31576623;

import com.github.dsfb.app31576623.view.TextViewPane;
import com.github.dsfb.app31576623.model.TextModel;
import com.github.dsfb.app31576623.model.SimpleTextModel;
import com.github.dsfb.app31576623.control.TextViewController;
import com.github.dsfb.app31576623.control.SimpleTextController;

import javax.swing.JFrame;

// Based on: https://stackoverflow.com/questions/31576623/how-mvc-work-with-java-swing-gui
public class App31576623 {
  
  public static void main(String[] args) {
    TextViewPane view = new TextViewPane();
    TextModel model = new SimpleTextModel();
    TextViewController controller = new SimpleTextController(view, model);

    JFrame frame = new JFrame("Testing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(view);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
