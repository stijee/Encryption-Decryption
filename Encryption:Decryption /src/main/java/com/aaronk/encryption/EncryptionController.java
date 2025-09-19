package src.main.java.com.aaronk.encryption;
import java.io.*;

public class EncryptionController {
    private EncryptionModel encryptionModel;
    private EncryptionView encryptionView;

/**
 * 
 * EncryptionController.java - Written by Aaron Kiah - Last Updated Nov. 11, 2024
 * 
 * Constructs an EncryptionController, initializes the model and view,
 * and sets up event listeners for encryption and decryption actions.
 *
 * @param model The EncryptionModel instance for handling encryption and decryption logic.
 */

    public EncryptionController(EncryptionModel model) {
        this.encryptionModel = model;
        this.encryptionView = new EncryptionView();

        encryptionView.getEncryptButton().addActionListener(e -> encryptFile());
        encryptionView.getDecryptButton().addActionListener(e -> decryptFile());

        encryptionView.setVisible(true);
    }

/**
 * Handles the encryption action by retrieving the file path, performing encryption, and displaying the result.
 */

    private void encryptFile() {
        String filePath = encryptionView.getFilePathField().getText();
        if (filePath.isEmpty()) {
            encryptionView.showStatus("Please select a file to encrypt.");
            return;
        }
        try {
            File inputFile = new File(filePath);
            File outputFile = encryptionModel.encryptDecryptFile(inputFile, true);
            encryptionView.showStatus("File encrypted successfully!\nOutput Path: " + outputFile.getAbsolutePath() + "\n---");
        } catch (Exception ex) {
            encryptionView.showStatus("Error encrypting file: " + ex.getMessage() + "\n---");
        }
    }
 
/**
 * Handles the decryption action by retrieving the file path, performing decryption, and displaying the result.
 */

    private void decryptFile() {
        String filePath = encryptionView.getFilePathField().getText();
        if (filePath.isEmpty()) {
            encryptionView.showStatus("Please select a file to decrypt.");
            return;
        }
        try {
            File inputFile = new File(filePath);
            File outputFile = encryptionModel.encryptDecryptFile(inputFile, false);
            encryptionView.showStatus("File decrypted successfully!\nAbsolute Path: " + outputFile.getAbsolutePath() + "\n---");
        } catch (Exception ex) {
            encryptionView.showStatus("Error decrypting file: " + ex.getMessage() + "\n---");
        }
    }
}
