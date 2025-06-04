# Caesar Cipher Encryption Tool

A simple Java application that encrypts and decrypts text using the classic Caesar cipher technique. Built in Eclipse, this tool shifts each letter in the input by a user-defined key to produce ciphered text (and can reverse the process for decryption). It’s intended as an educational demonstration of basic cryptographic principles and string manipulation in Java.

---

## Table of Contents

1. [Project Overview](#project-overview)  
2. [Features](#features)  
3. [Prerequisites](#prerequisites)  
4. [Installation & Setup](#installation--setup)  
5. [Usage](#usage)  
   - [Command-Line Version](#command-line-version)  
   - [Optional GUI Version](#optional-gui-version)  
6. [Configuration](#configuration)  
7. [Project Structure](#project-structure)  
8. [How It Works (Implementation Details)](#how-it-works-implementation-details)  
9. [Learning Outcomes](#learning-outcomes)  
10. [Contributing](#contributing)  
11. [License](#license)

---

## Project Overview

The Caesar Cipher Encryption Tool lets you:
- **Encrypt** plaintext by shifting each alphabetical character by a specified number of positions (the “key”).  
- **Decrypt** ciphertext by reversing the shift using the same key.  

Example (using a key of 3):
- Plaintext: `HELLO WORLD`
- Encrypted: `KHOOR ZRUOG`
- Decrypted (with key = 3): `HELLO WORLD`

This project was developed in Java using Eclipse. It was created to help learners:
- Understand fundamental cryptography concepts (substitution ciphers).  
- Practice string manipulation and character arithmetic in Java.  
- Get hands-on experience with Java I/O (console or simple GUI).  

---

## Features

- **Encrypt Text**: Input any English letters (A–Z, a–z) and shift them by a user-defined key (1–25).  
- **Decrypt Text**: Reverse the encryption by applying the negative of the same shift key.  
- **Case Preservation**: Uppercase letters remain uppercase, lowercase remain lowercase.  
- **Non-Letter Handling**: Digits, punctuation, and whitespace are not altered (they pass through unchanged).  
- **Command-Line Interface** (default): Enter plaintext/ciphertext and key; receive output directly in the console.  
- **Optional GUI (Swing/JavaFX)**: A simple window with text fields for input, key selection, and buttons to encrypt/decrypt.

---

## Prerequisites

1. **Java Development Kit (JDK) 8 or higher**  
   - Ensure `java` and `javac` are available on your PATH.  
2. **Eclipse IDE for Java Developers** (any recent version)  
   - Alternatively, you can use IntelliJ IDEA or a different Java IDE, but instructions below assume Eclipse.  
3. **(Optional) Git**  
   - If you wish to clone the repository instead of downloading ZIP.

---

## Installation & Setup

1. **Clone or Download Repository**  
   - **Via Git**:  
     ```bash
     git clone https://github.com/your-username/caesar-cipher-tool.git
     ```  
   - **Or** download the ZIP from GitHub and extract it to a folder of your choice.

2. **Import into Eclipse**  
   1. Open Eclipse.  
   2. Go to **File → Import…**  
   3. Choose **Existing Projects into Workspace** under the “General” category.  
   4. Click **Next**, then **Browse…** to the project root folder (where you see `src/`, `README.md`, etc.).  
   5. Ensure the project name (“CaesarCipherTool” or similar) is checked, then click **Finish**.

3. **Verify JDK Settings**  
   - Right-click the project in Eclipse → **Properties → Java Build Path → Libraries**.  
   - Confirm that a valid JRE System Library (matching JDK 8+) is listed.

---

## Usage

### Command-Line Version

1. In Eclipse, locate the main class `CaesarCipherMain.java` under `src/` (or similar).  
2. Right-click `CaesarCipherMain.java` → **Run As → Java Application**.  
3. The console window will prompt you to:
   1. Enter operation (`E` for encrypt, `D` for decrypt).  
   2. Enter the key (an integer between 1 and 25).  
   3. Enter the text (plaintext or ciphertext).  
4. After entering all inputs, press **Enter**. The tool will display the resulting text.

#### Example Session (Console)
Welcome to the Caesar Cipher Encryption Tool!
Select operation: [E]ncrypt or [D]ecrypt: E
Enter key (1-25): 5
Enter text: Hello, Java!
Ciphertext: Mjqqt, Ofaf!

css
Copy
Edit

To decrypt:
Select operation: [E]ncrypt or [D]ecrypt: D
Enter key (1-25): 5
Enter text: Mjqqt, Ofaf!
Plaintext: Hello, Java!

markdown
Copy
Edit

### Optional GUI Version

If the project includes a GUI implementation (e.g., `CipherGUI.java`):
1. Right-click `CipherGUI.java` → **Run As → Java Application**.  
2. A window appears with:
   - **Input Text Field** (for plaintext or ciphertext).  
   - **Key Selector** (dropdown or spinner for choosing shift between 1–25).  
   - **Encrypt Button**.  
   - **Decrypt Button**.  
   - **Output Text Area** (displays result).  

3. Enter the text, select the key, and click **Encrypt** or **Decrypt**. The result shows in the output area.

---

## Configuration

- **Key Range**: The tool enforces keys between 1 and 25. Entering a value outside this range will cause an error prompt.  
- **Character Support**:  
  - **Letters (A–Z, a–z)**: shifted by the key.  
  - **Non-letters** (e.g., digits, spaces, punctuation): remain unchanged.  

To modify or extend behavior (e.g., support for accented characters), update the `CipherUtils.java` helper class (handling the core shift logic).

---

## Project Structure

CaesarCipherTool/
├── src/
│ ├── com.yourname.cipher/
│ │ ├── CaesarCipher.java # Core encryption/decryption logic
│ │ ├── CipherUtils.java # Helper methods (e.g., shifting, validation)
│ │ ├── CaesarCipherMain.java # Main entry point (command-line interface)
│ │ └── CipherGUI.java # (Optional) Swing/JavaFX GUI implementation
│ └── ...
├── README.md # Project documentation (this file)
└── LICENSE # License (e.g., MIT)

arduino
Copy
Edit

- **`CaesarCipher.java`**  
  Contains two public methods:  
  ```java
  public static String encrypt(String plaintext, int shift);
  public static String decrypt(String ciphertext, int shift);
Both methods delegate to CipherUtils.shiftText(...).

CipherUtils.java
Implements the low-level logic for shifting characters:

Checks if a character is uppercase or lowercase.

Computes (char - base + shift) % 26 + base for letters.

Leaves non-letter characters untouched.

CaesarCipherMain.java
Handles user prompts in the console, reads input via Scanner, calls CaesarCipher.encrypt() or .decrypt(), and prints results.

CipherGUI.java (Optional)
Uses Swing (or JavaFX) to build a simple window. Contains text fields, buttons, and event listeners that call CaesarCipher.encrypt() / .decrypt() and display output.

How It Works (Implementation Details)
Reading User Input

The CaesarCipherMain class uses a Scanner object (System.in) to read:

Operation choice (E or D).

Numeric key (validate between 1 and 25).

Text line (plaintext or ciphertext).

Validating the Key

If the key is not an integer between 1 and 25, the program prints an error and prompts again.

Shifting Characters

In CipherUtils.shiftText(String text, int shift, boolean encrypt):

For each character c in text:

If c is uppercase ('A'..'Z'), compute:

java
Copy
Edit
char base = 'A';
char shifted = (char) (((c - base + (encrypt ? shift : 26 - shift)) % 26) + base);
If c is lowercase ('a'..'z'), similar logic with base = 'a'.

Otherwise, leave c unchanged (digits, punctuation, spaces).

Encryption vs. Decryption

Encryption calls shiftText(plaintext, shift, true).

Decryption calls shiftText(ciphertext, shift, false).

Decryption uses 26 - shift to reverse the shift.

Output

The resulting string is printed to the console (or GUI output area).

Learning Outcomes
By completing this project, you will demonstrate and practice:

Basic Cryptography Concepts

Understanding substitution ciphers (Caesar cipher).

Recognizing the importance and limitations of simple encryption algorithms.

Java Programming Skills

String manipulation, character arithmetic, and modulo operations.

Console I/O (using Scanner and System.out).

Designing a clear class structure (CaesarCipher, CipherUtils, Main).

Optional GUI Development

Building a small Swing (or JavaFX) interface.

Handling events and updating UI components based on user actions.

Project Organization

Structuring source files and separating concerns (core logic vs. UI vs. I/O).

Writing clean, documented code that can be extended or modified.

Security Awareness

Recognizing that the Caesar cipher is easily broken, prompting discussion about stronger encryption methods.

Learning why cryptographic libraries and more robust algorithms (e.g., AES) are needed in real-world applications.

Contributing
This project is intended for individual practice. However, if you would like to suggest improvements (e.g., add new cipher algorithms, internationalization, or advanced GUI features), feel free to fork the repository and submit a pull request. Please follow these guidelines:

Fork the main repository on GitHub.

Create a new branch for your feature/fix:

bash
Copy
Edit
git checkout -b feature/your-feature-name
Commit your changes with clear messages.

Push your branch to your fork:

bash
Copy
Edit
git push origin feature/your-feature-name
Open a pull request, describing your changes and why they’re beneficial.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Thank you for using the Caesar Cipher Encryption Tool! If you have any questions or run into issues, please open an issue in the repository or contact the project maintainer. Happy coding
