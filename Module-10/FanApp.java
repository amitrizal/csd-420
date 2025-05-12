// Author: Amit Rizal
// Date: 05/11/2025
// Assignment: Module 10 - Fan Database Manager
// Purpose: This program provides a GUI to view and update fan records.

import javax.swing.*;

public class FanApp {
    private JFrame frame;
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private DatabaseManager dbManager = new DatabaseManager();

    public FanApp() {
        frame = new JFrame("Fan Manager");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels and Fields
        addLabelAndField("ID:", 20, idField = new JTextField());
        addLabelAndField("First Name:", 50, firstNameField = new JTextField());
        addLabelAndField("Last Name:", 80, lastNameField = new JTextField());
        addLabelAndField("Favorite Team:", 110, favoriteTeamField = new JTextField());

        // Buttons
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(40, 150, 100, 30);
        frame.add(displayButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(160, 150, 100, 30);
        frame.add(updateButton);

        displayButton.addActionListener(e -> displayFan());
        updateButton.addActionListener(e -> updateFan());

        frame.setVisible(true);
    }

    private void addLabelAndField(String labelText, int y, JTextField field) {
        JLabel label = new JLabel(labelText);
        label.setBounds(20, y, 100, 25);
        frame.add(label);

        field.setBounds(120, y, 150, 25);
        frame.add(field);
    }

    private void displayFan() {
        try {
            int id = Integer.parseInt(idField.getText());
            Fan fan = dbManager.getFanById(id);
            if (fan != null) {
                firstNameField.setText(fan.getFirstName());
                lastNameField.setText(fan.getLastName());
                favoriteTeamField.setText(fan.getFavoriteTeam());
            } else {
                JOptionPane.showMessageDialog(frame, "Fan not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid ID.");
        }
    }

    private void updateFan() {
        try {
            int id = Integer.parseInt(idField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String team = favoriteTeamField.getText();

            Fan fan = new Fan(id, firstName, lastName, team);
            if (dbManager.updateFan(fan)) {
                JOptionPane.showMessageDialog(frame, "Fan updated successfully.");
            } else {
                JOptionPane.showMessageDialog(frame, "Update failed.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid ID.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FanApp::new);
    }
}
