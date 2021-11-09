package project;

import javax.swing.*;

public class VeryImportantCompanyApp {
    private JPanel panel1;
    private JRadioButton receptionToRoomRadioButton;
    private JRadioButton entryRadioButton;
    private JLabel windowStatus;
    static private VeryImportantCompany client;

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("VeryImportantCompanyApp");
        client = new VeryImportantCompany();
        frame.setContentPane(new VeryImportantCompanyApp().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
