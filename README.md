# Spreadsheet
Java Spreadsheet
This is a Java-based spreadsheet program that allows you to input, edit, and manipulate data using a grid-like interface. It includes various types of cells, including integer, double, string, and date cells.

Classes
Cell (abstract)
This is the abstract superclass for all cell types. It defines the basic functionality and properties that are common to all cell types.

IntegerCell
This is a subclass of Cell that represents integer values.

DoubleCell
This is a subclass of Cell that represents double values.

StringCell
This is a subclass of Cell that represents string values.

DateCell
This is a subclass of Cell that represents date values.

Spreadsheet
This class represents the entire spreadsheet and contains the grid of cells. It includes various methods for inputting, manipulating, and displaying data in the grid.

Tests
ManualTests
This is a manual test suite that allows you to test the functionality of the spreadsheet program by entering data into the grid and verifying the results. It includes tests for basic mathematical operations, custom formulas, and cell references.

Getting Started
To use the Java Spreadsheet, follow these steps:

Clone the repository to your local machine
Open the project in your Java IDE of choice
Run the ManualTests class to test the functionality of the program
Customizing
If you want to customize the Java Spreadsheet, you can modify the existing classes or create new subclasses of Cell to represent additional data types. You can also create additional test classes to test the functionality of your modifications.

Requirements
Java 8 or higher

Contributing
If you would like to contribute to the Java Spreadsheet project, please fork the repository and submit a pull request with your changes. We welcome contributions of all types, including bug fixes, new features, and improvements to the documentation.
