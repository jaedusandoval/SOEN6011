package com.powerfunction;

import javax.swing.SwingUtilities;

/**
 * The Main class is the entry point of the PowerFunction application.
 * It initializes the graphical user interface (GUI) by invoking the
 * PowerFunctionGUI class.
 */
public class Main {

    /**
     * The main method serves as the entry point of the application.
     * It schedules a job for the event-dispatching thread to create
     * and show the application's GUI.
     *
     * @param args command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Start the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(() -> new PowerFunctionGUI().createAndShowGUI());
    }
}
