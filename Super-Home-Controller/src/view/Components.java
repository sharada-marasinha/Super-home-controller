package view;

import controller.SwitchObserver;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Components extends JFrame implements SwitchObserver {
    private JLabel lightLbl, startTimeLbl, endTimeLbl;
    private int startHour, startMinute, endHour, endMinute;
    private Timer timer;
    private LocalTime currentTime;
    private String startTime,endTime;
    public Components(String title, int x, int y) {
        setSize(250, 150);
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setLocation(x, y);

        lightLbl = new JLabel();
        lightLbl.setText("OFF");
        lightLbl.setFont(new Font("MV Boli", Font.PLAIN, 60));
        lightLbl.setBounds(0, 12, 200, 100);
        lightLbl.setVerticalAlignment(JLabel.CENTER);
        lightLbl.setHorizontalAlignment(JLabel.CENTER);

        startTimeLbl = new JLabel();
        startTimeLbl.setText("Start LBL");
        startTimeLbl.setFont(new Font("", Font.PLAIN, 20));
        startTimeLbl.setBounds(0, 0, 120, 30);
        startTimeLbl.setVerticalAlignment(JLabel.CENTER);
        startTimeLbl.setHorizontalAlignment(JLabel.CENTER);
        startTimeLbl.setBackground(new Color(47, 79, 79));
        startTimeLbl.setForeground(Color.white);
        startTimeLbl.setOpaque(true);

        endTimeLbl = new JLabel();
        endTimeLbl.setText("End LBL");
        endTimeLbl.setFont(new Font("", Font.PLAIN, 20));
        endTimeLbl.setBounds(120, 0, 120, 30);
        endTimeLbl.setVerticalAlignment(JLabel.CENTER);
        endTimeLbl.setHorizontalAlignment(JLabel.CENTER);

        endTimeLbl.setBackground(new Color(47, 79, 79));
        endTimeLbl.setForeground(Color.white);
        endTimeLbl.setOpaque(true);

        add(lightLbl);
        add(startTimeLbl);
        add(endTimeLbl);
        setVisible(true);
    }

    @Override
    public void update(int condition) {
        lightLbl.setText(condition == 0 ? "OFF" : "ON");
    }
    @Override
    public void updateTime(String startHour, String startMinute, String endHour, String endMinute) {
        this.startHour = Integer.parseInt(startHour);
        this.startMinute = Integer.parseInt(startMinute);
        this.endHour = Integer.parseInt(endHour);
        this.endMinute = Integer.parseInt(endMinute);

        startTimeLbl.setText(String.format("%02d:%02d:00", this.startHour, this.startMinute));
        startTimeLbl.setBackground(Color.green);
        endTimeLbl.setText(String.format("%02d:%02d:00", this.endHour, this.endMinute));
        endTimeLbl.setBackground(Color.red);

        timer = new Timer(1000, e -> {
            checkTime();
        });
        timer.start();
    }
    private void checkTime() {
        currentTime = LocalTime.now();
        startTime = startTimeLbl.getText();
        endTime = endTimeLbl.getText();

        if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(startTime)) {
            lightLbl.setText("ON");
            JOptionPane.showMessageDialog(this, "Light ON !");

        } else if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(endTime)) {
            lightLbl.setText("OFF");
            JOptionPane.showMessageDialog(this, "Light OFF !");

        }

    }


}
