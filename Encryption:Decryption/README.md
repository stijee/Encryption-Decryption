Encryption/Decryption Application

This is a  Java program that encrypts and decrypts files using a dynamic key sequence derived from the digits of Pi.

-=- Table of Contents -=-

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Sample Files](#sample-files)
- [Technical Details](#technical-details)
- [Author](#author)

🔍 Overview

This application provides a user-friendly graphical interface for encrypting and decrypting text files using a unique encryption algorithm based on the mathematical constant Pi (π). The encryption process uses the digits of Pi as a dynamic key sequence, making it both mathematically interesting and secure.

✨ Features

- **Graphical User Interface**: Clean and intuitive Swing-based GUI
- **Pi-based Encryption**: Uses digits of Pi as encryption keys
- **File Status Tracking**: Automatically marks encrypted/decrypted files
- **Error Handling**: Comprehensive error handling and user feedback
- **Cross-platform**: Runs on any system with Java support

🔧 Prerequisites

- Java 8 or higher
- No additional dependencies

🚀 Installation

1. Clone this repository:
   git clone <your-repository-url>
   cd Encryption:Decryption


2. Ensure you have Java installed:

   java -version


-=- Usage -=-

-=- Running the Application -=- 

1. Compile with this bash command:

   javac -d build src/main/java/com/aaronk/encryption/*.java
   

2. Run the application:

   java -cp build com.aaronk.encryption.EncryptionApp

-=- Using the GUI -=- 

1. **Select a File**: Click the "Browse..." button to select a text file to encrypt or decrypt
2. **Encrypt**: Click "Encrypt" to encrypt the selected file
3. **Decrypt**: Click "Decrypt" to decrypt the selected file
4. **View Results**: Check the output area for status messages and file paths
5. **Get Help**: Click "Info" for detailed program information

-=- Command Line Usage -=-

The application can also be run from the command line, but the GUI provides the best user experience.

📁 Project Structure

Encryption:Decryption/
├── README.md                          # This file
├── .gitignore                         # Git ignore rules
├── src/                               # Source code
│   └── main/
│       └── java/
│           └── com/
│               └── aaronk/
│                   └── encryption/    # Main package
│                       ├── EncryptionApp.java      # Application entry point
│                       ├── EncryptionController.java # Business logic controller
│                       ├── EncryptionModel.java    # Encryption/decryption logic
│                       └── EncryptionView.java     # GUI components
├── resources/     # Application resources
│   ├── pi_digits.txt  # Pi digits for encryption keys
│   └── sample_files/  # Sample files for testing (Feel Free to add your own!)
│       ├── Romans12.txt
│       ├── KnockDrawRelease.txt
│       └── CloseToYou.txt
└── build/                             # Compiled classes (auto-generated)
```

## 🏗️ Architecture

This application follows the **Model-View-Controller (MVC)** design pattern:

- **Model** (`EncryptionModel`): Handles the core encryption/decryption logic
- **View** (`EncryptionView`): Manages the graphical user interface
- **Controller** (`EncryptionController`): Coordinates between Model and View
- **App** (`EncryptionApp`): Application entry point and initialization

📄 Sample Files

The project includes several sample files for testing:

- **Romans12.txt**: Biblical text from Romans chapter 12
- **KnockDrawRelease.txt**: Song lyrics
- **CloseToYou.txt**: Song lyrics
- **pi_digits.txt**: Contains the digits of Pi used for encryption

🔐 Technical Details

-=- Encryption Algorithm -=-

1. **Key Generation**: Uses digits from `pi_digits.txt` as encryption keys
2. **Encryption Process**: 
   - Each byte is modified using the formula: `(original_byte + pi_digit) % 256`
   - Keys cycle through the Pi digits sequence
3. **File Marking**: Encrypted files are marked with a status header
4. **Decryption**: Reverses the encryption process using subtraction

-=- File Handling -=-

- **Input**: Accepts any text file
- **Output**: Creates new files with `encrypted_` or `decrypted_` prefixes
- **Status Tracking**: Files are marked with encryption/decryption status
- **Error Handling**: Comprehensive error messages for file operations

👨‍💻 Author

**Aaron Kiah**  
*Last Updated: November 11, 2024*

---

📝 License

This project is created for educational purposes. Feel free to use and modify as needed.

🤝 Contributing

This is a lab project, but suggestions and improvements are welcome!

📞 Support

If you encounter any issues or have questions, please check the error messages in the application's output area or review the code documentation.
