package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeryImportantCompanyApp {
    private JPanel panel1;
    private JRadioButton receptionToRoomRadioButton;
    private JRadioButton entryRadioButton;
    private JLabel doorStatus;
    private JComboBox entryStatus;
    private JRadioButton window1Button;
    private JRadioButton window2Button;
    private JComboBox window1State;
    private JComboBox window2State;
    private JLabel doorLabel;
    private JLabel windowStatus;
    private JLabel windowLabel;
    private JButton updateButton;
    private JComboBox recToRoomStatus;

    private VeryImportantCompany client;

    private String selectedDoorStatus;
    private int selectedDoorId;
    private String selectedWindowStatus;
    private int selectedWindowId;
    private String[] doorStates, windowStates;

    public VeryImportantCompanyApp() {
        try { this.client = new VeryImportantCompany(); }
        catch(Exception e){
            System.out.println("Couldn't connect");
        }

        entryRadioButton.setSelected(true);
        window1Button.setSelected(true);
        doorStatus.setText("Door is open");
        windowStatus.setText("Window is open");
        selectedWindowId = 0;
        selectedDoorId = 0;
        selectedDoorStatus = "open";
        selectedWindowStatus = "open";

        windowStates = new String[2];
        doorStates = new String[2];

        for(int i = 0; i < 2; i++){
            windowStates[i] = "open";
            doorStates[i] = "open";
        }


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.updateData(doorStates, windowStates);
                doorStatus.setText(client.getDoorData(selectedDoorId));
                windowStatus.setText(client.getWindowData(selectedWindowId));
            }
        });

        entryRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = client.getDoorData(0);
                doorStatus.setText(data);
                selectedDoorStatus = doorStates[0];
                selectedDoorId = 0;
            }
        });
        receptionToRoomRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = client.getDoorData(1);
                doorStatus.setText(data);
                selectedDoorStatus = doorStates[1];
                selectedDoorId = 1;
            }
        });
        window1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = client.getWindowData(0);
                windowStatus.setText(data);
                selectedWindowStatus = windowStates[0];
                selectedWindowId = 0;
            }
        });
        window2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = client.getWindowData(1);
                windowStatus.setText(data);
                selectedWindowStatus = windowStates[1];
                selectedWindowId = 1;
            }
        });
        entryStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doorStates[0] = entryStatus.getSelectedItem().toString();
            }
        });
        recToRoomStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doorStates[1] = recToRoomStatus.getSelectedItem().toString();
                System.out.println(doorStates[1]);
            }
        });
        window1State.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowStates[0] = window1State.getSelectedItem().toString();
                System.out.println( windowStates[0]);
            }
        });
        window2State.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowStates[1] = window2State.getSelectedItem().toString();
                System.out.println( windowStates[1]);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("VeryImportantCompanyApp");
        //client = new VeryImportantCompany();
        frame.setContentPane(new VeryImportantCompanyApp().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
