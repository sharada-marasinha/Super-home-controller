package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeWindow extends JFrame {
    private final JLabel timeLbl;


    private DateTimeFormatter timeFormatter;
    private LocalTime currentTime;
    private String formattedTime;

    public LocalTimeWindow() {
        setSize(350, 150);
        setTitle("Local Time and Date");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setLocation(505, 15);

        final LocalDate currentDate = LocalDate.now();
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final String formattedDate = currentDate.format(dateFormatter);

        timeLbl = new JLabel();
        timeLbl.setFont(new Font("", Font.PLAIN, 30));
        timeLbl.setBounds(40, 10, 250, 50);
        timeLbl.setVerticalAlignment(JLabel.CENTER);
        timeLbl.setHorizontalAlignment(JLabel.CENTER);
        timeLbl.setBackground(new Color(47, 79, 79));
        timeLbl.setForeground(Color.white);
        timeLbl.setOpaque(true);
        final Timer timer = new Timer(1000, e -> {
            currentTime = LocalTime.now();
            timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            formattedTime = currentTime.format(timeFormatter);
            timeLbl.setText("Time : " + formattedTime);
        });
        timer.start();

        final JLabel dateLbl = new JLabel();
        dateLbl.setText("Date : " + formattedDate);
        dateLbl.setFont(new Font("", Font.PLAIN, 20));
        dateLbl.setBounds(40, 60, 250, 50);
        dateLbl.setVerticalAlignment(JLabel.CENTER);
        dateLbl.setHorizontalAlignment(JLabel.CENTER);


        add(timeLbl);
        add(dateLbl);
        setVisible(true);
    }
}
