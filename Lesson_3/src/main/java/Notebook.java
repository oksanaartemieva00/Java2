import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Notebook {
    HashMap<String, HashSet<String>> phoneBook;

    public Notebook() {
        this.phoneBook = new HashMap<>();
    }

    public void addContact(String surname, String phone) {
        HashSet<String> book = phoneBook.getOrDefault(surname, new HashSet<>());
        book.add(phone);
        phoneBook.put(surname, book);
    }

    public void print(String surname){
        System.out.println("Фамилия: "+surname+". Номер телефона: "+phoneBook.getOrDefault(surname,new HashSet<>()));
    }
}
