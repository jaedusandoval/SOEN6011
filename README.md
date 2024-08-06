# Power Function Calculator

This project is a Java application that calculates the power of a base number raised to an exponent. It provides a graphical user interface (GUI) to input the base and exponent values and displays the result.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Code Overview](#code-overview)
    - [Main Class](#main-class)
    - [PowerFunctionGUI Class](#powerfunctiongui-class)
    - [PowerFunction Class](#powerfunction-class)
- [License](#license)

## Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/jaedusandoval/SOEN6011.git
   cd SOEN6011
   
2. **Open the project in IntelliJ IDEA**:

* Open IntelliJ IDEA.
* Select File > Open... and navigate to the cloned repository folder.
* Click OK to open the project.

3. **Build the project**:

* Ensure that your project SDK is set up correctly.
* Go to Build > Build Project to compile the code.

## Usage

1. **Run the application**:

* In IntelliJ IDEA, navigate to the Main class.
* Right-click on the Main class and select Run 'Main.main()'.

2. **Use the GUI**:

* Enter the base value in the "Base (x)" input field.
* Enter the exponent value in the "Exponent (y)" input field.
* Click the "Calculate" button to compute the power.
* The result will be displayed in the "Result" field.

## Code Overview

**Main Class**
* This is the entry point of the application. It sets up the GUI on the Event Dispatch Thread (EDT).

**PowerFunctionGUI Class**
* This class creates and manages the graphical user interface. It includes input fields for the base and exponent, a button to perform the calculation, and a field to display the result.

**PowerFunction Class**
* This class contains the logic for calculating the power function. It handles both integer and fractional exponents.

## License
* This project is licensed under the MIT License - see the LICENSE file for details.

