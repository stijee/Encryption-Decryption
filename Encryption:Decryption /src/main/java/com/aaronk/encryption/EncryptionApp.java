package src.main.java.com.aaronk.encryption;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 * 
 * EncryptionApp.java - Written by Aaron Kiah - Last Updated Nov. 11, 2024
 * 
 * The EncryptionApp class serves as the entry point for the encryption and decryption application.
 * It initializes the model with the Pi digits file and starts the controller.
 */
public class EncryptionApp {

/**
 * The main method initializes the EncryptionModel using pi_digits.txt as the encryption key source
 * and starts the EncryptionController to manage encryption and decryption operations.
 * 
 * @param args Command-line arguments (not used in this application).
*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                File piFile = new File("pi_digits.txt");
                EncryptionModel model = new EncryptionModel(piFile);
                new EncryptionController(model);  // This will create and show the GUI
            } catch (IOException e) {
                System.err.println("Error initializing the application: " + e.getMessage());
            }
        });
    }
}
