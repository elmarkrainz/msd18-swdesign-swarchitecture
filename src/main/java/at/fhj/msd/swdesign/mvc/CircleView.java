package at.fhj.msd.swdesign.mvc;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CircleView extends JFrame {

    private JLabel lblRadius = new JLabel("Radius: ");
    private JTextField txtRadius = new JTextField(3);
    private JButton cmdCalc = new JButton("calculate Circle");
    private JLabel txtResult = new JLabel();

    public CircleView() {
        super("Calculate Circle");
        initForm();
    }

    private void initForm() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setBounds(200, 200, 500, 100);

        this.add(lblRadius);
        this.add(txtRadius);
        this.add(txtResult);
        this.add(cmdCalc);
        this.add(txtResult);

    }

    public String getRadius() {
        return this.txtRadius.getText();
    }

    public void setResult(String t) {
        this.txtResult.setText(t);
    }


    public void setCalcListener(ActionListener l) {
        this.cmdCalc.addActionListener(l);
    }
}
