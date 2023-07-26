package view;

import controller.SwitchObservable;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JLabel.*;

public class MainSwitchWindow extends JFrame {
    private final JToggleButton tBtnCondition;

    public MainSwitchWindow() {

        SwitchObservable switchObservable = SwitchObservable.getInstance();

        setTitle("Main Switch");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        final JLabel titleLabel = new JLabel("Main Switch");
        titleLabel.setFont(new Font("", Font.BOLD, 35));
        titleLabel.setVerticalAlignment(CENTER);
        titleLabel.setHorizontalAlignment(CENTER);
        titleLabel.setBounds(0, 0, 400, 60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);

        tBtnCondition = new JToggleButton();
        tBtnCondition.setFocusable(false);
        tBtnCondition.setText("OFF");
        tBtnCondition.setFont(new Font("", Font.BOLD, 15));
        tBtnCondition.setBounds(90, 100, 200, 40);
        tBtnCondition.addActionListener(evt -> {
            if (tBtnCondition.isSelected()) {
                tBtnCondition.setText("ON");
                switchObservable.setCondition(1);
            } else {
                tBtnCondition.setText("OFF");
                switchObservable.setCondition(0);
            }

        });

        final JButton btnSettings = new JButton();
        btnSettings.setFocusable(false);
        btnSettings.setText("Settings");
        btnSettings.setFont(new Font("", Font.BOLD, 15));
        btnSettings.setBounds(90, 170, 200, 40);
        btnSettings.setBorder(BorderFactory.createEtchedBorder());

        btnSettings.addActionListener(evt -> HomeComponent.getInstanceHomeComp());

        final JLabel lblCopyRight = new JLabel("@sharadamrasinha@gmail.com");
        lblCopyRight.setBounds(115, 250, 200, 30);
        lblCopyRight.setFont(new Font("", Font.BOLD, 10));

        add(titleLabel);
        add(tBtnCondition);
        add(btnSettings);
        add(lblCopyRight);
        setVisible(true);
    }

}
