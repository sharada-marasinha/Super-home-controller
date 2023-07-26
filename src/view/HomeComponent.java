package view;

import controller.SwitchObservable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeComponent extends JFrame {


    private final JList<String> list;
    private String listValue;
    private int ListIndex;

    private static HomeComponent instance = null;

    private JButton addComp;
    public DefaultListModel<String> l1;

    private HomeComponent() {
        SwitchObservable switchObservable = SwitchObservable.getInstance();

        setTitle("Controller");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setLocation(85, 190);

        final JLabel titleLabel = new JLabel("Home Component");
        titleLabel.setFont(new Font("", Font.BOLD, 35));
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
        list.setBounds(20, 70, 340, 170);
        list.setModel(l1);
        list.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !list.isSelectionEmpty()) {
                listValue = list.getSelectedValue();
                ListIndex = list.getSelectedIndex();
                switchObservable.getIndexForNotify(ListIndex);
                new SetTimeComponent(listValue);



            }
        });
        addComp = new JButton();
        addComp.setFocusable(false);
        addComp.setText("Add Component");
        addComp.setFont(new Font("", Font.BOLD, 15));
        addComp.setBounds(220, 260, 150, 30);
        addComp.addActionListener(e -> {
            //JOptionPane.showMessageDialog(this,  "This Function is Available in Soon..");
            new AddComponent(this).setVisible(true);
        });


        add(list);
        add(titleLabel);
        add(addComp);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle window close event
                saveChanges();
                dispose();
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // Handle window open event
                restoreChanges();
            }
        });
    }

    public static void getInstanceHomeComp() {
        if (instance == null) {
            instance = new HomeComponent();
        }
    }

    private void saveChanges() {
        // Save any changes made to the application state
        // This can include storing data, settings, etc.
        System.out.println("Saving changes...");
        instance = null;
    }

    private void restoreChanges() {
        // Restore the previous state of the application
        // This can include loading data, settings, etc.
        System.out.println("Restoring changes...");
    }


}
