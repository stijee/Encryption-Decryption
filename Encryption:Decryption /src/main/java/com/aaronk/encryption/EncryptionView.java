package src.main.java.com.aaronk.encryption;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 
 * EncryptionView.java - Written by Aaron Kiah - Last Updated Nov. 11, 2024
 * 
 * The EncryptionView class is responsible for creating the user interface
 * for the encryption and decryption application.
 * It provides components for selecting files to encrypt or decrypt and an Info button for general program information.
 */

public class EncryptionView extends JFrame {

    private JButton encryptButton;
    private JButton decryptButton;
    private JButton infoButton;
    private JButton browseButton; 
    private JTextField filePathField;
    private JTextArea outputArea;

/**
 * Constructs the EncryptionView and sets up the UI components.
 */

    public EncryptionView() {
        setTitle("Encryption/Decryption Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input Panel with GridBagLayout for better control over component sizes
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        filePathField = new JTextField(30); 
        browseButton = new JButton("Browse..."); 

        // Label constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(new JLabel("File Path: "), gbc);

        // File path field constraints
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(filePathField, gbc);

        // Browse button constraints
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(browseButton, gbc);

        // Button Panel for Encrypt, Decrypt, and Info buttons
        JPanel buttonPanel = new JPanel();
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
        infoButton = new JButton("Info");

        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        buttonPanel.add(infoButton);

        // Output Area for displaying results or messages
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add panels to the frame layout
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        // Set up action for Info button
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInfoDialog();
            }
        });

        // Set up action for Browse button
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFile();
            }
        });
    }

/**
 * Opens a file chooser dialog to allow the user to select a file, 
 * and sets the selected file path in the filePathField.
 */

    private void selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }

/**
 * Displays the program information in a dialog box, including details about the files used.
 */

    private void showInfoDialog() {
        String message = """
                Encryption/Decryption Application - Written by Aaron Kiah
                Last Update: Nov. 11, 2024

                This application encrypts and decrypts files using a dynamic key 
                sequence derived from Pi's digits.
                
                Files Used in the Program:
                - pi_digits.txt: Contains the digits of Pi used as the encryption key sequence.
                - Romans12.txt: Sample file containing text from Romans 12.
                - KnockDrawRelease.txt: Sample file containing lyrics.
                - CloseToYou.txt: Sample file containing lyrics.
                
                To use the application:
                1. Use the 'Browse' button to select a file to encrypt or decrypt.
                2. Press 'Encrypt' to encrypt or 'Decrypt' to decrypt the selected file.
                """;
        JOptionPane.showMessageDialog(this, message, "Program Information", JOptionPane.INFORMATION_MESSAGE);
    }

/**
 * Displays a status message in the output area.
 * 
 * @param message The message to display.
 */

    public void showStatus(String message) {
        outputArea.append(message + "\n");
    }

/**
 * Returns the Encrypt button for attaching an ActionListener in the controller.
 *
 * @return the Encrypt button
 */

    public JButton getEncryptButton() {
        return encryptButton;
    }

/**
 * Returns the Decrypt button for attaching an ActionListener in the controller.
 *
 * @return the Decrypt button
 */

    public JButton getDecryptButton() {
        return decryptButton;
    }

/**
 * Returns the file path text field for getting the path input from the user.
 *
 * @return the file path text field
 */

    public JTextField getFilePathField() {
        return filePathField;
    }

/**
 * Returns the output area for displaying status messages or results.
 *
 * @return the output text area
 */

    public JTextArea getOutputArea() {
        return outputArea;
    }
}
