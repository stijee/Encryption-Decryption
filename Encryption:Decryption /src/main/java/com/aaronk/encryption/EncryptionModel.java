package src.main.java.com.aaronk.encryption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * EncryptionModel.java - Written by Aaron Kiah - Last Updated Nov. 11, 2024
 * 
 * The EncryptionModel class provides functionality for encrypting and decrypting files.
 * It uses the digits of Pi from a specified file (pi_digits.txt) as a dynamic key sequence
 * for encryption and decryption, adding a status message to indicate the file's state.
 */
public class EncryptionModel {
    
    
    private static final String ENCRYPTION_MARK = "---This file has been ENCRYPTED---\n";
    private static final String DECRYPTION_MARK = "---This file has been DECRYPTED---\n";
    private List<Integer> piDigits;

/**
* 
* Constructs an EncryptionModel instance and loads the Pi digits from the specified file.
* 
* @param piFile The file containing Pi digits to be used as the encryption key sequence.
* @throws IOException If an error occurs while reading the Pi digits file.
*/

    public EncryptionModel(File piFile) throws IOException {
        piDigits = loadPiDigits(piFile);
    }

/**
* Encrypts or decrypts a file based on the mode provided, saving the output file
* in the same directory with a prefix indicating the action.
* If encrypting, the file will be marked with {@link #ENCRYPTION_MARK}.
* If decrypting, any existing {@link #ENCRYPTION_MARK} will be removed and
* {@link #DECRYPTION_MARK} will be added at the beginning of the file.
* 
* @param inputFile The file to be encrypted or decrypted.
* @param isEncryptMode True for encryption, false for decryption.
* @return The newly created output file with the appropriate prefix.
* @throws IOException If an error occurs during file reading or writing.
*/

    public File encryptDecryptFile(File inputFile, boolean isEncryptMode) throws IOException {
        String outputFileName = generateOutputFileName(inputFile, isEncryptMode);
        File outputFile = new File(inputFile.getParent(), outputFileName);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            if (isEncryptMode) {
                fos.write(ENCRYPTION_MARK.getBytes());
            } else {
                removeStatusMarkAndAddDecryption(fis, fos);
            }

            int data;
            int piIndex = 0;

            while ((data = fis.read()) != -1) {
                int key = piDigits.get(piIndex);
                if (isEncryptMode) {
                    data = (data + key) % 256;
                } else {
                    data = (data - key + 256) % 256;
                }
                fos.write(data);
                piIndex = (piIndex + 1) % piDigits.size();
            }
        }

        return outputFile;
    }

/**
* Generates an output file name with "encrypted_" or "decrypted_" as a prefix
* based on the encryption mode, removing any existing status prefix.
* 
* @param inputFile The original file.
* @param isEncryptMode True if encrypting, false if decrypting.
* @return The generated output file name with the appropriate prefix.
*/

    private String generateOutputFileName(File inputFile, boolean isEncryptMode) {
        String fileName = inputFile.getName();
        String prefix = isEncryptMode ? "encrypted_" : "decrypted_";

        if (fileName.startsWith("encrypted_")) {
            fileName = fileName.substring("encrypted_".length());
        } else if (fileName.startsWith("decrypted_")) {
            fileName = fileName.substring("decrypted_".length());
        }

        return prefix + fileName;
    }

/**
* Skips the status mark line if it exists at the beginning of the file and adds the decryption mark.
* Reads bytes up to the first newline and compares them to the status mark.
* 
* @param fis The FileInputStream for reading the input file.
* @param fos The FileOutputStream for writing to the output file.
* @throws IOException If an error occurs during reading or writing.
*/

    private void removeStatusMarkAndAddDecryption(FileInputStream fis, FileOutputStream fos) throws IOException {
        StringBuilder firstLine = new StringBuilder();
        int character;

        while ((character = fis.read()) != -1 && character != '\n') {
            firstLine.append((char) character);
        }

        String firstLineStr = firstLine.toString();
        if (!firstLineStr.equals(ENCRYPTION_MARK.trim())) {
            fos.write((firstLineStr + "\n").getBytes());
        }

        fos.write(DECRYPTION_MARK.getBytes());
    }

/**
* Loads the digits of Pi from a file. Each digit is stored as an integer in a list.
* 
* @param piFile The file containing digits of Pi.
* @return A list of integers representing each digit of Pi.
* @throws IOException If an error occurs while reading the file.
*/

    private List<Integer> loadPiDigits(File piFile) throws IOException {
        List<Integer> digits = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(piFile))) {
            int character;
            while ((character = reader.read()) != -1) {
                if (Character.isDigit(character)) {
                    digits.add(Character.getNumericValue(character));
                }
            }
        }
        return digits;
    }
}
