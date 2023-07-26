package view;

import controller.SwitchObservable;

import model.TimeCompModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SetTimeComponent extends JFrame {
    private final JSpinner startHourSpinner;
    private final JSpinner startMinuteSpinner;
    private final JSpinner endHourSpinner;
    private final JSpinner endMinuteSpinner;
    private TimeCompModel timeOb;
    private JButton btnSet;

    public SetTimeComponent(String title) {

        SwitchObservable switchObservable = SwitchObservable.getInstance();

        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setLocation(880, 190);

        final JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("", Font.BOLD, 35));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, 400, 60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);

        final JLabel lblHour = new JLabel("Start Hour :");
        lblHour.setBounds(20, 230, 65, 30);
        final JLabel lblMinute = new JLabel("Minute :");
        lblMinute.setBounds(160, 230, 50, 30);

        final JLabel endTLblHour = new JLabel("End Hour :");
        endTLblHour.setBounds(20, 270, 65, 30);
        final JLabel endTimeLblMinute = new JLabel("Minute :");
        endTimeLblMinute.setBounds(160, 270, 50, 30);


        final SpinnerModel StartHours = new SpinnerNumberModel(0, 0, 24, 1);
        startHourSpinner = new JSpinner(StartHours);
        startHourSpinner.setBounds(90, 230, 50, 30);
        JComponent startHourEditor = new JSpinner.NumberEditor(startHourSpinner, "00");
        startHourSpinner.setEditor(startHourEditor);

        final SpinnerModel startMinute = new SpinnerNumberModel(0, 0, 59, 1);
        startMinuteSpinner = new JSpinner(startMinute);
        startMinuteSpinner.setBounds(210, 230, 50, 30);
        JComponent startMinuteEditor = new JSpinner.NumberEditor(startMinuteSpinner, "00");
        startMinuteSpinner.setEditor(startMinuteEditor);


        final SpinnerModel endHours = new SpinnerNumberModel(0, 0, 24, 1);
        endHourSpinner = new JSpinner(endHours);
        endHourSpinner.setBounds(90, 270, 50, 30);
        JComponent endHourEditor = new JSpinner.NumberEditor(endHourSpinner, "00");
        endHourSpinner.setEditor(endHourEditor);


        final SpinnerModel endMinute = new SpinnerNumberModel(0, 0, 60, 1);
        endMinuteSpinner = new JSpinner(endMinute);
        endMinuteSpinner.setBounds(210, 270, 50, 30);
        JComponent endMinuteEditor = new JSpinner.NumberEditor(endMinuteSpinner, "00");
        endMinuteSpinner.setEditor(endMinuteEditor);

        final DefaultListModel<TimeCompModel> l1 = new DefaultListModel<>();
        final JList<TimeCompModel> list = new JList<>();
        list.setFont(new Font("", Font.PLAIN, 20));
        list.setBounds(20, 70, 340, 150);
        list.setModel(l1);
        l1.addElement(new TimeCompModel("10", "35", "01", "15"));
        list.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !list.isSelectionEmpty()) {
                timeOb = list.getSelectedValue();
                System.out.println(timeOb.getStartHour());
                startHourSpinner.setValue(Integer.parseInt(timeOb.getStartHour()));
                startMinuteSpinner.setValue(Integer.parseInt(timeOb.getStartMinute()));
                endHourSpinner.setValue(Integer.parseInt(timeOb.getEndHour()));
                endMinuteSpinner.setValue(Integer.parseInt(timeOb.getEndMinute()));
                btnSet.setText("Update");

            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle window close event
                saveChanges();


            }

            @Override
            public void windowOpened(WindowEvent e) {
                // Handle window open event
                restoreChanges();
            }
        });

        btnSet = new JButton();
        btnSet.setFocusable(false);
        btnSet.setText("Set");
        btnSet.setFont(new Font("", Font.BOLD, 15));
        btnSet.setBounds(275, 240, 100, 50);
        btnSet.addActionListener((ActionEvent evt) -> {
            btnSet.setText("Set");
            String startHour = String.valueOf(startHourSpinner.getValue());
            String vStartMinute = String.valueOf(startMinuteSpinner.getValue());


            String endHour = String.valueOf(endHourSpinner.getValue());
            String vEndMinute = String.valueOf(endMinuteSpinner.getValue());

            l1.addElement(new TimeCompModel(startHour, vStartMinute, endHour, vEndMinute));
            switchObservable.setTime(startHour, vStartMinute, endHour, vEndMinute);

        });

        add(titleLabel);
        add(list);
        add(startHourSpinner);
        add(startMinuteSpinner);
        add(endHourSpinner);
        add(endMinuteSpinner);
        add(lblHour);
        add(lblMinute);
        add(endTLblHour);
        add(endTimeLblMinute);
        add(btnSet);
        setVisible(true);

    }

    private void saveChanges() {
        // Save any changes made to the application state
        // This can include storing data, settings, etc.
        System.out.println("Saving changes...");
    }

    private void restoreChanges() {
        // Restore the previous state of the application
        // This can include loading data, settings, etc.
        System.out.println("Restoring changes...");
    }


}
