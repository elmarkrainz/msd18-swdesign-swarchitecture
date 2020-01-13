package at.fhj.msd.swdesign.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class User extends JFrame implements ActionListener {

    private final String dataFile = "userdata.txt";
    private String name;

    public User() {

        name = readFromFile();
        createUI();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User: name=" + name;
    }

    private JLabel lblUsername = new JLabel("Username: ");
    private JTextField txtUsername = new JTextField(10);
    private JButton jButton = new JButton("change & save");
    private JLabel txtResult = new JLabel();


    private void createUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setBounds(200, 200, 600, 100);

        this.add(lblUsername);
        this.add(txtUsername);
        this.add(txtResult);
        this.add(jButton);
        this.add(txtResult);

        txtUsername.setText(name);
        txtResult.setText(this.toString());

        jButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setName(txtUsername.getText());
        txtResult.setText(this.toString());
        writeToFile(getName());
    }


    private void writeToFile(String str) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(dataFile));
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    private String readFromFile() {

        String data = null;

        try {
            File file = new File(dataFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader((dataFile)));

            data = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data == null) {
            data = "new user";
        }
        return data;
    }

    public static void main(String[] args) {

        User u = new User();
        u.setVisible(true);

    }
}
