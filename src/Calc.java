import java.util.Scanner;

public class Calc {

    static Scanner scanner = new Scanner (System.in);

    static String[] input () {
        System.out.println("Input:");
        String str = scanner.nextLine();
        str = str.trim();
        str = str.replaceAll(" +", " ");
        str = str.toUpperCase();
        String[] exp = str.split(" ");
        if (exp.length > 3) throw new ArrayIndexOutOfBoundsException("Invalid expression " + str);
        return exp;
    }

    static int operation (int num1, String sym, int num2) {
        int res;
        if (num1 < 1 || num1 > 10) throw new IllegalStateException("Invalid value " + num1);
        if (num2 < 1 || num2 > 10) throw new IllegalStateException("Invalid value " + num2);
        switch (sym) {
            case "+": res = num1 + num2; break;
            case "-": res = num1 - num2; break;
            case "*": res = num1 * num2; break;
            case "/": res = num1 / num2; break;
            default: throw new IllegalStateException("Invalid operation " + sym);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] inp = input();
        try {
            int num1 = Interpreter.romanToArab(inp[0]);
            int num2 = Interpreter.romanToArab(inp[2]);
            int res = operation(num1, inp[1], num2);
            if (res < 0) System.out.printf("Output:\n-%s", Interpreter.arabToRoman(res));
            else if (res == 0) System.out.printf("Output:\n0");
            else System.out.printf("Output:\n%s", Interpreter.arabToRoman(res));
        } catch (IllegalStateException exception) {
            int num1 = Integer.parseInt(inp[0]);
            int num2 = Integer.parseInt(inp[2]);
            int res = operation(num1, inp[1], num2);
            System.out.printf("Output:\n%d", res);
        }
    }
}

