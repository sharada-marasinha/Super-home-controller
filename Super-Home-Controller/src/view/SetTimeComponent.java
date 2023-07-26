package view;

import controller.SwitchObservable;

import model.TimeCompModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SetTimeComponent extends JFrame {
    private JLabel titleLabel, lblHour, elblMinute, lblMinute, elblHour;
    private JButton btnSet;
    private SwitchObservable switchObserverble;
    private SpinnerModel StartHours, startMinute, endHours, endMinute;
    private JSpinner startHourSpinner, startMinuteSpinner, endHourSpinner, endMinuteSpinner;
    private DefaultListModel<TimeCompModel> l1;
    private JList<TimeCompModel> list;

    private TimeCompModel timeOb;
    public SetTimeComponent(String title, SwitchObservable switchObserverble) {

        this.switchObserverble = switchObserverble;

        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setLocation(880, 190);

        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, 400, 60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);

        lblHour = new JLabel("Start Hour :");
        lblHour.setBounds(20, 230, 65, 30);
        lblMinute = new JLabel("Minute :");
        lblMinute.setBounds(160, 230, 50, 30);

        elblHour = new JLabel("End Hour :");
        elblHour.setBounds(20, 270, 65, 30);
        elblMinute = new JLabel("Minute :");
        elblMinute.setBounds(160, 270, 50, 30);


        StartHours = new SpinnerNumberModel(0, 0, 24, 1);
        startHourSpinner = new JSpinner(StartHours);
        startHourSpinner.setBounds(90, 230, 50, 30);
        JComponent startHourEditor=new JSpinner.NumberEditor(startHourSpinner,"00");
        startHourSpinner.setEditor(startHourEditor);

        startMinute = new SpinnerNumberModel(0, 0, 60, 1);
        startMinuteSpinner = new JSpinner(startMinute);
        startMinuteSpinner.setBounds(210, 230, 50, 30);
        JComponent startMinuteEditor=new JSpinner.NumberEditor(startMinuteSpinner,"00");
        startMinuteSpinner.setEditor(startMinuteEditor);


        endHours = new SpinnerNumberModel(0, 0, 24, 1);
        endHourSpinner = new JSpinner(endHours);
        endHourSpinner.setBounds(90, 270, 50, 30);
        JComponent endHourEditor=new JSpinner.NumberEditor(endHourSpinner,"00");
        endHourSpinner.setEditor(endHourEditor);


        endMinute = new SpinnerNumberModel(0, 0, 60, 1);
        endMinuteSpinner = new JSpinner(endMinute);
        endMinuteSpinner.setBounds(210, 270, 50, 30);
        JComponent endMinuteEditor=new JSpinner.NumberEditor(endMinuteSpinner,"00");
        endMinuteSpinner.setEditor(endMinuteEditor);

        l1 = new DefaultListModel<>();
        list = new JList<>();
        list.setFont(new Font("", Font.PLAIN, 20));
        list.setBounds(20, 70, 340, 150);
        list.setModel(l1);
        l1.addElement(new TimeCompModel("10", "35", "01", "15"));
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && !list.isSelectionEmpty()) {
                    int index=list.getSelectedIndex();
                    timeOb=list.getSelectedValue();
                    System.out.println(timeOb.getStartHour());
                    startHourSpinner.setValue(Integer.parseInt(timeOb.getStartHour()));
                    startMinuteSpinner.setValue(Integer.parseInt(timeOb.getStartMinute()));
                    endHourSpinner.setValue(Integer.parseInt(timeOb.getEndHour()));
                    endMinuteSpinner.setValue(Integer.parseInt(timeOb.getEndMinute()));
                    btnSet.setText("Update");

                }
            }
        });
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

        btnSet = new JButton();
        btnSet.setFocusable(false);
        btnSet.setText("Set");
        btnSet.setFont(new Font("", 1, 15));
        btnSet.setBounds(275, 240, 100, 50);
        btnSet.addActionListener(evt -> {
            btnSet.setText("Set");
            String startHour = "" + startHourSpinner.getValue();
            String startMinut = "" + startMinuteSpinner.getValue();


            String endHour = "" + endHourSpinner.getValue();
            String endMinut = "" + endMinuteSpinner.getValue();

            l1.addElement(new TimeCompModel(startHour, startMinut, endHour, endMinut));
            switchObserverble.setTime(startHour, startMinut, endHour, endMinut);

        });

        add(titleLabel);
        add(list);
        add(startHourSpinner);
        add(startMinuteSpinner);
        add(endHourSpinner);
        add(endMinuteSpinner);
        add(lblHour);
        add(lblMinute);
        add(elblHour);
        add(elblMinute);
        add(btnSet);
        setVisible(true);

    }
    private void saveChanges(){
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
