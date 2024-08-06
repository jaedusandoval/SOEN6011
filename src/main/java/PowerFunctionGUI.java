import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerFunctionGUI {

    private PowerFunction powerFunction = new PowerFunction();

    public void createAndShowGUI() {
        // Create the frame
        JFrame frame = new JFrame("Power Function Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create the panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Create the components
        JLabel xLabel = new JLabel("Base (x):");
        JTextField xField = new JTextField();
        JLabel yLabel = new JLabel("Exponent (y):");
        JTextField yField = new JTextField();
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        // Add components to the panel
        panel.add(xLabel);
        panel.add(xField);
        panel.add(yLabel);
        panel.add(yField);
        panel.add(calculateButton);
        panel.add(new JLabel()); // Empty cell
        panel.add(resultLabel);
        panel.add(resultField);

        // Add panel to the frame
        frame.getContentPane().add(panel);

        // Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(xField.getText());
                    double y = Double.parseDouble(yField.getText());
                    double result = powerFunction.computePower(x, y);
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for x and y.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

}
