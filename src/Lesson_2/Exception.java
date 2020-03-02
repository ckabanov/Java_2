package Lesson_2;

public class Exception {

    private static final int REQUIRED_ARRAY_SIZE = 4;

    private static final String[][] ArrayCorrect = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"},
    };

    private static final String[][] ArrayIncorrectSize = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7"},
            {"8", "9", "10", "11"},
            {"13", "14", "15", "16"},
    };


        private static final String[][] ArrayIncorrectValue = new String[][]{
            {"1", "2", "З", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"},
    };


    public static void main(String[] args) {
        try {
            System.out.println("Сумма  первого массива " + sumArray(ArrayCorrect) );
            System.out.println();
            System.out.println("Сумма массива 2" + sumArray(ArrayIncorrectSize) );


        } catch (MyArraySizeException e) {
            System.out.println("Некорректный размер массива");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                System.out.println("Сумма массива 3" + sumArray(ArrayIncorrectValue));
            }
            catch (MyArrayDataException e) {
                System.out.println();
                System.out.println("Некорректные данные в массиве");
                System.out.println(e.getMessage());
            }
        }
    }

    private static int sumArray(String[][] data) {
        checkSizeArray(data);

        int sumResult = 0;

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String value = row[colIndex];
                try {
                    sumResult += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(value, rowIndex, colIndex);
                }
            }
        }

        return sumResult;
    }

    private static void checkSizeArray(String[][] data) {
        if (data.length != REQUIRED_ARRAY_SIZE) {
            throw new MyArraySizeException();
        }

        for (String[] row : data) {
            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
    }

}
