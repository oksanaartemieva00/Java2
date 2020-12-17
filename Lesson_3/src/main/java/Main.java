import java.util.*;

public class Main {
    //задача №1
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(Arrays.asList("красный","оранжевый","желтый","зеленый","красный",
                "синий","красный","черный","белый","зеленый"));
        Set<String> unique=new HashSet<String>(list);
        System.out.println("Уникальные слова: "+unique.toString());
        for(String key:unique){
            System.out.println("Слово ("+key + ") встречается " +
                    Collections.frequency(list, key)+" раз");
        }
        System.out.println("Задача №2");
        Notebook book=new Notebook();
        book.addContact("Иванова","+7(901)459-73-64");
        book.addContact("Бобров","+7(974)157-80-08");
        book.addContact("Сидоров","+7(942)567-52-37");
        book.addContact("Иванова","+7(956)856-54-56");
        book.addContact("Николаев","+7(999)999-99-99");

        book.print("Иванова");
        book.print("Бобров");
    }
}
