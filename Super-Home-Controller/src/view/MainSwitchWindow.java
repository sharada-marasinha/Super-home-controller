package view;

import controller.SwitchObservable;

import javax.swing.*;
import java.awt.*;

public class MainSwitchWindow extends JFrame {
    private JToggleButton tBtnCondition;
    private JButton btnSettings;
    private JLabel lblMinute, lblHour;
    private JLabel titleLabel;
    private SwitchObservable switchObserverble;
    private JSpinner hourSpinner, minuteSpinner;
    private SpinnerModel hours, minute;
    public MainSwitchWindow(SwitchObservable switchObserverble) {

        this.switchObserverble = switchObserverble;
        setTitle("Main Switch");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        titleLabel = new JLabel("Main Switch");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, 400, 60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);

        tBtnCondition = new JToggleButton();
        tBtnCondition.setFocusable(false);
        tBtnCondition.setText("OFF");
        tBtnCondition.setFont(new Font("", 1, 15));
        tBtnCondition.setBounds(90, 100, 200, 40);
        tBtnCondition.addActionListener(evt -> {
            if (tBtnCondition.isSelected()) {
                tBtnCondition.setText("ON");
                switchObserverble.setCondition(1);
            } else {
                tBtnCondition.setText("OFF");
                switchObserverble.setCondition(0);
            }

        });

        btnSettings = new JButton();
        btnSettings.setFocusable(false);
        btnSettings.setText("Settings");
        btnSettings.setFont(new Font("", 1, 15));
        btnSettings.setBounds(90, 170, 200, 40);
        btnSettings.setBorder(BorderFactory.createEtchedBorder());
        btnSettings.addActionListener(evt -> {

                new HomeComponent(switchObserverble);


        });

        lblHour = new JLabel("@Sharadamarasinha");
        lblHour.setBounds(135, 250, 150, 30);
        lblHour.setFont(new Font("", 1, 10));

        lblMinute = new JLabel("Minute :");
        lblMinute.setBounds(200, 250, 50, 30);

        hours = new SpinnerNumberModel(1,  1, 24, 1);
        hourSpinner = new JSpinner(hours);
        hourSpinner.setBounds(100, 250, 50, 30);
        hourSpinner.addChangeListener(e ->{
            String hour = "" + hourSpinner.getValue();
        });

        minute = new SpinnerNumberModel(1,   1, 60, 1);
        minuteSpinner = new JSpinner(minute);
        minuteSpinner.setBounds(250, 250, 50, 30);
        minuteSpinner.addChangeListener(e -> {
            String minute = "" + minuteSpinner.getValue();
            System.out.println(minute);
        });

        add(titleLabel);
        add(tBtnCondition);
        add(btnSettings);
       add(lblHour);
       // add(lblMinute);
    //    add(hourSpinner);
      //  add(minuteSpinner);
        setVisible(true);
    }

}
