import arbitraryarithmetic.Ainteger;
import arbitraryarithmetic.Afloat;

public class MyInfArith {
    public static void main(String[] args) {
        String type = args[0];
        String operation = args[1];
        String operand1 = args[2];
        String operand2 = args[3];
        String operation_lower = operation.toLowerCase();

        if (type.equals("int")) {
            if (!(Ainteger.valid_check(operand1) && Ainteger.valid_check(operand2))) {
                throw new IllegalArgumentException("Invalid argument");
            }
            Ainteger a1 = Ainteger.parse(operand1);
            Ainteger a2 = Ainteger.parse(operand2);
            String result = null;
            switch (operation_lower) {
                case "add":
                    result = a1.addition(a2);
                    break;
                case "sub":
                    result = a1.subtract(a2);
                    break;
                case "mul":
                    result = a1.multiply(a2);
                    break;
                case "div":
                    result = a1.divide(a2);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    return;
            }
            System.out.println("Result: " + result);
        } else if (type.equals("float")) {
            if (!(Afloat.valid_check(operand1) && Afloat.valid_check(operand2))) {
                throw new IllegalArgumentException("Invalid argument");
            }
            Afloat f1 = Afloat.parse(operand1);
            Afloat f2 = Afloat.parse(operand2);
            String result = null;
            switch (operation_lower) {
                case "add":
                    result = f1.addition(f2);
                    break;
                case "sub":
                    result = f1.subtract(f2);
                    break;
                case "mul":
                    result = f1.multiply(f2);
                    break;
                case "div":
                    result = f1.divide(f2);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    return;
            }
            System.out.println("Result: " + result);
        }
    }
}
