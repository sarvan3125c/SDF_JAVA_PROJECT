# Custom Arbitrary-Precision Calculator
## introduction
- The main objective of this library is the Implementation of Infinite/arbitraty-Precision Calculator
- It allows for handling large numbers with arbitrary precision, which are beyond the capabilities of standard data types.
- The library includes support for basic arithmetic operations such as addition, subtraction, multiplication, and division, with accurate results even for very large or small numbers.

## File Structure
- it has a package called arbitraryarithmetic with contains `Ainteger.java` and `Afloat.java`
- `Ainteger.java`: Contains the implementation for arbitrary-precision integer arithmetic.
- `Afloat.java`: Contains the implementation for arbitrary-precision floating-point arithmetic.
- `MyInfArith.java`: The main class that integrates and provides the interface for performing arbitrary-precision arithmetic operations.

## why this
| Data Type   | Minimum Value                      | Maximum Value                        |
|-------------|------------------------------------|--------------------------------------|
| `int`       | -2^31 (-2,147,483,648)             | 2^31 - 1 (2,147,483,647)             |
| `long`      | -2^63 (-9,223,372,036,854,775,808) | 2^63 - 1 (9,223,372,036,854,775,807) |
| `float`     | -3.4028235e^38                     | 3.4028235e^38                        |
| `double`    | -1.7976931348623157e^308           | 1.7976931348623157e^308              |
- This library can handle numbers which exceed the range of these standard types.

### Features:
- Handles arbitrary-precision integers.
- Supports addition, subtraction, multiplication, and division.
- Can handle negative numbers.
- String-based implementation, ensuring large numbers are accurately represented.
- Provides basic utility methods for comparison, copying, and parsing.

## AInteger.java(Integer class)
- The `Ainteger` class handles operations for arbitrarily large integers, including support for negative values. It supports basic arithmetic operations such as addition, subtraction, multiplication, and division, using string-based representations for the numbers. This class also ensures that no precision is lost, even with very large numbers.
- This class file belongs to arbitraryarithmetic package
### member variables
- it has a protected member `num` of type String
### Constructors
1. **Default Constructor**:
   - **`public Ainteger()`**: Initializes the `num` member variable to the string `"0"`, representing the integer value 0.
   
2. **Parameterized Constructor**:
   - **`public Ainteger(String s)`**: Initializes the `num` member variable with the value provided in the string `s`.

### Key Methods:
- `copy()`: Returns a new Ainteger object initialized with current `num` value.
- **`addition(Ainteger a)`**:  
  Calls the `add(Ainteger a)` method to add the current `Ainteger` with another `Ainteger`. It then trims the output of the `add` method to ensure the result is correctly formatted.
- **`subtract(Ainteger a)`**:  
  Calls the `sub(Ainteger a)` method to subtract another `Ainteger` from the current `Ainteger`. It then trims the output of the `sub` method.
- **`multiply(Ainteger a)`**:  
  Calls the `mult(Ainteger a)` method to multiply the current `Ainteger` with another `Ainteger`. It then trims the output of the `mult` method.
- **`divide(Ainteger a)`**:  
  Calls the `division(Ainteger)` where Divides the current `Ainteger` by another `Ainteger` and returns the List of quotient and remainder. it  returns the Quotient from the output of `division` method
- `compareTo(Ainteger a)`: Compares two `Ainteger` objects.
- `remove_zeroes(String s)`: Removes leading or trailing zeros from a string representation of a number.
- `parse(String s)`: Parses a string into an `Ainteger` object.
- `valid_check(String s)`: Checks if a string is a valid integer.

## Afloat.java(float class)
- This class file belongs to arbitraryarithmetic package
- The `Afloat` class handles arbitrary-precision floating-point numbers, offering support for both integer and decimal parts. Like the `Ainteger` class, `Afloat` uses string-based representations to store numbers and ensures no precision loss for large numbers. This class supports operations like addition, subtraction, multiplication, and division on floating-point numbers.

### member variables
- `num`: stores the number as a string.
- `intpart`: it stores the integer part of the number.
- `decimalpart`: it stores the decimal part of the number.
- `no_decimal_num`: stores the number string without the decimal.
### Constructors
- `Afloat()`: Initializes an `Afloat` object with a default value of `0.0`.
- `Afloat(String inp)`: Initializes an `Afloat` object with a given string input representing a floating-point number.
  - If the input does not contain a decimal point, it appends `.0` to treat it as a floating-point number.
  - Splits the input into two parts:
    - `intpart`: The part before the decimal.
    - `decimalpart`: The part after the decimal.
  - Concatenates `intpart` and `decimalpart` to get `no_decimal_num`, which is used for internal arithmetic operations.
### Key Methods:
- `copy()`: Returns a new Afloat object initialized with current `num` value.
- **`addition(Afloat a)`**:  
  Calls the `add(Afloat a)` method to add the current `Afloat` with another `Afloat`. It then trims the output of the `add` method to ensure the result is correctly formatted.
- **`subtract(Afloat a)`**:  
  Calls the `sub(Ainteger a)` method to subtract another `Afloat` from the current `Afloat`. It then trims the output of the `sub` method.
- **`multiply(Afloat a)`**:  
  Calls the `mult(Ainteger a)` method to multiply the current `Afloat` with another `Afloat`. It then trims the output of the `mult` method.
- **`divide(Afloat a)`**:  
  Calls the `division(Afloat a)` where Divides the current `Afloat` by another `Afloat`. It then trims the output of the `division` method.
- `compareTo(Afloat a)`: Compares two `Afloat` objects.
- `remove_zeroes(String s)`: Removes leading or trailing zeros from a string representation of a number.
- `parse(String s)`: Parses a string into an `Afloat` object.
- `valid_check(String s)`: Checks if a string is a valid float.
## Installation

Simply download or clone this repository and add the `Ainteger` and `Afloat` classes to your Java project. There's no additional installation required.

## Usage Example

```java
public class Main {
    public static void main(String[] args) {
        Ainteger num1 = new Ainteger("123456789012345678901234567890");
        Ainteger num2 = new Ainteger("987654321098765432109876543210");
        
        Ainteger sum = new Ainteger(num1.add(num2).toString());
        System.out.println("Sum: " + sum.get());
        
        Afloat num3 = new Afloat("12345.67890");
        Afloat num4 = new Afloat("98765.43210");
        
        Afloat result = num3.add(num4);
        System.out.println("Sum (Afloat): " + result.get());
    }
}
