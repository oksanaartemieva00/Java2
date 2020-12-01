package Lesson2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String cellCalue, int rowNumber, int columnNumber){
        super("Нужен другой формат переменных");
    }
}
