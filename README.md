# Hospital Inspection Management App

## Overview
This is a simple Java Swing application designed to manage hospital inspection details. The application allows users to enter information such as the hospital name, location, and the number of years since the last inspection. Users can save the details, view them in a formatted list, and clear the input fields.

The application has a fixed window size and supports a maximum of five inspection records. It provides a clean, user-friendly graphical interface, following good Java programming practices and maintaining a consistent Allman code style for readability.

## Features
- **Graphical User Interface (GUI)**: Built using Java Swing, the application offers an intuitive and straightforward interface.
- **Fixed Window Size**: The window is set to 600x400 pixels and is not resizable to maintain consistency in appearance and functionality.
- **Input Fields**:
  - Hospital Name
  - Hospital Location
  - Years Since Last Inspection (via a dropdown menu for selecting values between 1-5 years)
- **Multiline Display**: Displays the formatted hospital inspection details in a `JTextArea`.
- **Menu and Buttons**:
  - Save, Print, and Clear buttons for interacting with the hospital data.
  - A simple menu bar with File and Tools options for additional functionality like Exit, Save, Print, and Clear.
- **Input Validation**: Ensures that all fields are filled and restricts the number of saved records to a maximum of five.
- **Error Handling**: Displays appropriate error messages when users exceed the input limit or fail to provide all required information.

## How to Use

1. **Add Hospital Details**: Enter the hospital name, location, and select the number of years since the last inspection from the dropdown.
2. **Save Details**: Click the **Save** button to store the hospital inspection details.
3. **Print Saved Records**: Click the **Print** button to display all saved hospital records in the text area.
4. **Clear Input Fields**: Click the **Clear** button to reset the input fields and clear the displayed records.
5. **Menu Options**:
    - **File → Exit**: Closes the application.
    - **Tools → Save**: Saves the current inspection details (similar to the Save button).
    - **Tools → Print**: Prints the saved records (similar to the Print button).
    - **Tools → Clear**: Clears the input fields and text area (similar to the Clear button).

## Installation and Setup

### Prerequisites
- Ensure you have **Java Development Kit (JDK)** installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Installation Steps

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/HChristopherNaoyuki/hospital-inspection-app.git
    cd HospitalInspectionApp
    ```

2. **Compile the Java Source**:
    Navigate to the `src` folder and compile the Java file:
    ```bash
    cd src
    javac HospitalInspectionApp.java
    ```

3. **Run the Application**:
    After compiling, run the application:
    ```bash
    java HospitalInspectionApp
    ```

## Project Structure
```plaintext
HospitalInspectionApp/
│
├── src/
│   └── HospitalInspectionApp.java
├── LICENSE
└── README.md
```

## LICENSE

This project is licensed under the MIT license - see the [LICENSE](LICENSE) file for details.
