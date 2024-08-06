package com.powerfunction;

import javax.swing.*;
import java.awt.*;
import javax.swing.WindowConstants;

public class PowerFunctionGUI {

    private final PowerFunction powerFunction = new PowerFunction();
    JPanel panel;

    public void createAndShowGUI() {
        // Create the frame
        JFrame frame = new JFrame("Power Function Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create the panel and layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10)); // Added padding

        // Create the components
        JLabel xLabel = new JLabel("Base (x):");
        xLabel.getAccessibleContext().setAccessibleName("Base label");
        xLabel.getAccessibleContext().setAccessibleDescription("Label for base value input field");

        JTextField xField = new JTextField();
        xField.getAccessibleContext().setAccessibleName("Base input field");
        xField.getAccessibleContext().setAccessibleDescription("Enter the base value here");

        JLabel yLabel = new JLabel("Exponent (y):");
        yLabel.getAccessibleContext().setAccessibleName("Exponent label");
        yLabel.getAccessibleContext().setAccessibleDescription("Label for exponent value input field");

        JTextField yField = new JTextField();
        yField.getAccessibleContext().setAccessibleName("Exponent input field");
        yField.getAccessibleContext().setAccessibleDescription("Enter the exponent value here");

        JButton calculateButton = new JButton("Calculate");
        calculateButton.getAccessibleContext().setAccessibleName("Calculate button");
        calculateButton.getAccessibleContext().setAccessibleDescription("Button to calculate the power function");

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.getAccessibleContext().setAccessibleName("Result label");
        resultLabel.getAccessibleContext().setAccessibleDescription("Label for the result output field");

        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultField.getAccessibleContext().setAccessibleName("Result output field");
        resultField.getAccessibleContext().setAccessibleDescription("Displays the result of the power calculation");

        // Add components to the panel
        panel.add(xLabel);
        panel.add(xField);
        panel.add(yLabel);
        panel.add(yField);
        panel.add(calculateButton);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(resultLabel);
        panel.add(resultField);

        // Add action listener to the button using a lambda expression
        calculateButton.addActionListener(e -> {
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
        });

        // Add panel to the frame
        frame.getContentPane().add(panel);
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // Display the frame
        frame.setVisible(true);
    }
}