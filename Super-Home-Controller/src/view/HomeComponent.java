package view;

import controller.SwitchObservable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicReference;

public class HomeComponent extends JFrame {
    private JLabel titleLabel;
    private SwitchObservable switchObserverble;
    private DefaultListModel<String> l1;
    private JList<String> list;
    private String listValue;
    private int ListIndex;

    public HomeComponent(SwitchObservable switchObserverble) {

        this.switchObserverble = switchObserverble;

        setTitle("Controller");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setLocation(85, 190);

        titleLabel = new JLabel("Home Component");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, 400, 60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);

        l1 = new DefaultListModel<>();
        l1.addElement("TV | Living Room");
        l1.addElement("Speaker | Living Room");
        l1.addElement("Light | Living Room");
        l1.addElement("Window | Living Room");

        list = new JList<>();
        list.setFont(new Font("", Font.PLAIN, 20));
        list.setBounds(20, 70, 340, 150);
        list.setModel(l1);
        list.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !list.isSelectionEmpty()) {
                listValue = list.getSelectedValue();
                ListIndex = list.getSelectedIndex();
                switchObserverble.getIndexForNotify(ListIndex);
                //switchObserverble.getIndexForNotify(ListIndex);
                new SetTimeComponent(listValue, switchObserverble);


            }
        });




        add(list);
        add(titleLabel);
    }


}
