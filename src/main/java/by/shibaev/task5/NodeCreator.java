package by.shibaev.task5;

import javafx.beans.binding.ObjectExpression;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;

public class NodeCreator {
    public static Button createButton(int x,int y,int height,int width, String text){
        Button button = new Button(text);
        button.setSize(width,height);
        button.setLocation(x,y);
        return button;
    }

    public static List createList(String...nodes) {
        List list = new List();
        for (int i = 0; i < nodes.length; i++) {
            list.addItem(nodes[i]);
        }
        return list;
    }
}
