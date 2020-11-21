public class Interpreter {

    public static String arabToRoman(int arab) {
        if (arab < 0) arab *= -1;
        String rom = "";
        int doz = arab / 10; // десяткеи
        int unit = arab % 10; // единицы

        // Запись римских десяток в строку
        if (doz < 4) {
            for (int i = 0; i < doz; i++) {
                rom += "X";
            }
        }
        else if (doz == 4) rom += "XL";
        else if (doz == 5) rom += "L";
        else if (doz > 5 && doz < 9) {
            rom += "L";
            for (int i = 5; i < doz; i++) {
                rom += "X";
            }
        }
        else if (doz == 9) rom += "XC";
        else if (doz == 10) rom += "C";

        // Запись римских единиц в строку
        if (unit < 4) {
            for (int i = 0; i < unit; i++) {
                rom += "I";
            }
        }
        else if (unit == 4) rom += "IV";
        else if (unit == 5) rom += "V";
        else if (unit > 5 && unit < 9) {
            rom += "V";
            for (int i = 5; i < unit; i++) {
                rom += "I";
            }
        }
        else if (unit == 9) rom += "IX";
        return rom;
    }

    public static int romanToArab (String rom) {
        int arab = 0;
        String[] roms = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < roms.length; i++) {
            if (roms[i].equals(rom)) {
                arab = i + 1;
                break;
            }
        }
        return arab;
    }
}
