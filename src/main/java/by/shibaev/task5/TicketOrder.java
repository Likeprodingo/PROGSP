package by.shibaev.task5;

import javax.swing.*;
import javax.swing.text.LabelView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketOrder extends JFrame implements ActionListener {
    TextField name;
    TextField surname;
    List list;
    JRadioButton female;
    JRadioButton male;
    ButtonGroup buttonGroup;
    Label result;

    public TicketOrder() {
        super("Заказ билета");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Label nameLabel = new Label("Name");
        nameLabel.setBounds(50, 20, 100, 20);
        name = new TextField();
        name.setBounds(50, 40, 200, 20);
        Label surnameLabel = new Label("Surname");
        surnameLabel.setBounds(50, 80, 100, 20);
        surname = new TextField();
        surname.setBounds(50, 100, 200, 20);
        male = new JRadioButton("Male");
        male.setBounds(50, 240, 100, 30);
        female = new JRadioButton("Female");
        female.setBounds(200, 240, 100, 30);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        Label aim = new Label("End county");
        aim.setBounds(50, 150, 100, 20);
        list = NodeCreator.createList("Minsk", "Moscow", "Kiev");
        list.setBounds(50, 180, 100, 50);
        Button button = NodeCreator.createButton(50, 280, 15, 100, "Get");
        result = new Label("");
        result.setBounds(50, 300, 500, 20);
        button.addActionListener(this::actionPerformed);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(nameLabel);
        panel.add(name);
        panel.add(surnameLabel);
        panel.add(surname);
        panel.add(male);
        panel.add(female);
        panel.add(nameLabel);
        panel.add(aim);
        panel.add(list);
        panel.add(button);
        panel.add(result);
        setContentPane(panel);
        setSize(700, 500);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        result.setText("Result: " +
                "Name: " + name.getText() + " " +
                " Surname: " + surname.getText() + " " +
                " Gender: " + (female.isSelected() ? "female" : "male") +
                " Aim:" + list.getSelectedItem());
    }
}
