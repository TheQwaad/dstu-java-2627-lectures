package lecture1;

/**
 * 1. Примитивные типы: byte, short, int, long, дополнительный код, переполнение; double, float, ieee-754; char; boolean и его размер
 * 2. Ветвления: if-else, switch-case (две версии)
 * 3. Циклы: for, while
 * 4. Функции: базовый синтаксис
 * 5. Массивы: создание, обход, ссылочность
 * 6. Строки: создание, обращение, сравнение (стринг-пул, equals)
 */

public class Main {

    public static String getWeekdayLiteral(int weekDay) {
        return switch(weekDay) {
            case 1 -> "Понедельник";
            case 2 -> "ВТОРНИК";
            case 3 -> "Среда";
            default -> "Любой другой день";
        };
    }
    // 0 1 1 2 3 5 8
    public static int fibonacci(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }

        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void update(int[] arr) {
        int[] localArr = new int[5];
        System.arraycopy(arr, 0, localArr, 0, 5);
        localArr[0] = 5;
    }

    public static void main(String[] args) {
        byte byteNumber = 6; // 1 byte, max_value: 2^7 - 1
        short shortNumber = 6; // 2 byte, max_value = 2^15 - 1
        int intNumber = 6; // 4 byte, max_value = 2^32 - 1; (~ 2 * 10^9)
        long longNumber = 7L; // 8 byte, max_value = 2^63 - 1; (~ 4 * 10^18)


        int a = 1000000000;
        int b = 1000000000;

        // overflow
        System.out.println(a * b);

        // cast to long
        // failed
        System.out.println((long) (a * b));
        // alright!
        System.out.println((long) a * b);

        // division
        // 5 / 2 = 2.5; 5 // 2 = 2
        System.out.println(5 / 2);

        // ================
        // IEEE-754 (32 bit): 1 bit - sign; 8 - exponent; 23 - mantissa
        // (-1) ^ sign * (mantissa) * (2 ^ exponent)
        float floatNumber = 2.5f;
        double doubleNumber = 2.5;

        System.out.println((double) intNumber / longNumber);

        // ============

        char charVar = 'C'; // 2 byte, 16 bit
        char numericCharVar = 123; // chr(..)
        System.out.println(charVar);
        System.out.println(numericCharVar);
        System.out.println('C' - ('A' - 1));

        // ============

        boolean someFlag = true; // or false


        // ========================
        int weekDay = 2;
        // > < >= <= != ==
        if (weekDay == 1) {
            System.out.println("Monday");
        } else if (weekDay == 2) {
            System.out.println("Tuesday");
            System.out.println("Вторник");
        } else if (weekDay == 3) {
            System.out.println("Wednesday");
        } else {
            System.out.println("Any other day");
        }

        switch (weekDay) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Any other day");
        }

        switch (weekDay) {
            case 1 -> System.out.println("Monday");
            case 2 -> {
                System.out.println("Tuesday");
                System.out.println("Вторник");
            }
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Any other day");
        }

        String message = switch(weekDay) {
            case 1 -> "Понедельник";
            case 2 -> "ВТОРНИК";
            case 3 -> "Среда";
            default -> "Любой другой день";
        };

        System.out.println(message);

        // =====================
        while (weekDay < 7) {
            System.out.println("-------");
            System.out.println(++weekDay);
            System.out.println(weekDay);
        }
        System.out.println("++++++++");
        for (int i = 0; i < 7; i++) {
            System.out.println(getWeekdayLiteral(i));
        }


        System.out.println(fibonacci(6));

        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = new int[5];

        for (int i = 0; i < array1.length; i++) { // for i in range(array1.length)
            System.out.println(array1[i]++ + " " + array1[i] + " " + array3[i]);
        }

        update(array3);
        System.out.println(array3[0]);
        System.out.println("----------");
        for (int i: array1) { // for i in array1
            System.out.println(i);
        }

        String stringOne = "Bla";
        String stringTwo = "Blo";

        System.out.println(stringOne + stringTwo);

        String stringThree = "Bla";
        String stringFour = new String("Bla");

        System.out.println(stringOne == stringThree); // true (string pool)
        System.out.println(stringOne == stringFour); // false
        System.out.println(stringOne.equals(stringFour)); // true

        System.out.println(stringTwo.charAt(2));
        System.out.println(stringTwo.charAt(2) == stringOne.charAt(2));
    }
}