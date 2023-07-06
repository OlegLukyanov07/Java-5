/**
 * Урок 5. Хранение и обработка данных ч2: множество коллекций Map
 * Задание
 *
 * Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны. 
 */
 
 public class task1 {
      
    private static void task1() {
        Directory directory = new Directory();
        
        directory.add("Антонов", "8999123321");
        directory.add("Антонов", "8912155326");
        directory.add("Бобров", "8917155552");
        directory.add("Бобров", "8913455672");
        directory.add("Антонов", "899999999");
        directory.add("Петров", "899111111");
        directory.add("Бобров", "89923231999");
        directory.add("Соломович", "8888123113");
        directory.add("Петров", "8324325234");

        System.out.println(directory.get("Антонов"));
        System.out.println(directory.get("Петров"));
        System.out.println(directory.get("Бобров"));
        System.out.println(directory.get("Соломович"));
    }
}

class Directory {
    private Map<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}