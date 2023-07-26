package view;

import controller.SwitchObservable;

import javax.swing.*;

public class AddComponent extends JFrame {

    private JTextField txtX;
    private JTextField txtY;

    private JTextField txtCompName;

    private JButton addBtn;

    private JLabel lblComName, lblX, lblY;

    AddComponent(HomeComponent homeComponent) {
        SwitchObservable switchObservable=SwitchObservable.getInstance();
        setSize(350, 170);
        setTitle("Add Component");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setLocation(510, 550);

        lblComName = new JLabel("Component Name : ");
        lblComName.setBounds(30, 15, 150, 30);

        lblX = new JLabel(" X ");
        lblX.setBounds(200, 15, 20, 30);

        lblY = new JLabel(" Y ");
        lblY.setBounds(270, 15, 20, 30);

        txtX = new JTextField();
        txtX.setBounds(180, 40, 50, 30);

        txtY = new JTextField();
        txtY.setBounds(250, 40, 50, 30);

        txtCompName = new JTextField();
        txtCompName.setBounds(30, 40, 120, 30);

        addBtn = new JButton();
        addBtn.setBounds(100, 90, 150, 30);
        addBtn.setText("ADD Component");
        addBtn.addActionListener(e->{
            switchObservable.addSwitchObserver(new Components(txtCompName.getText(),Integer.parseInt(txtX.getText()),Integer.parseInt(txtY.getText())));
            homeComponent.l1.addElement(txtCompName.getText());
        });
        add(lblComName);
        add(lblX);
        add(lblY);
        add(txtX);
        add(txtY);
        add(txtCompName);
        add(addBtn);

    }

}
