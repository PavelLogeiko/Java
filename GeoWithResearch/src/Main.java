import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nЗадача: Вывести информацию на экран обо всех детях определенного человека (родителя).");
        // родители
        Person irina = new Person("Ирина");
        Person vasya = new Person("Вася");
        // дети
        Person masha = new Person("Маша");
        Person grisha = new Person("Гриша");
        Person petr = new Person("Петр");
        Person karina = new Person("Карина");

        GeoTree gt = new GeoTree();
        gt.append(irina, masha);
        gt.append(irina, grisha);
        gt.append(vasya, petr);
        gt.append(vasya, karina);

        System.out.println("\nСейчас имеется информация о следующих родителях и их детях:");
        System.out.println("Родитель Ирина, дети: " + new Reserch(gt).spend(irina,
                Relationship.parent));
        System.out.println("Родитель Вася, дети: " + new Reserch(gt).spend(vasya,
                Relationship.parent));
        System.out.println("\nУ Ирины и Васи родились еще по одному ребенку, введите пож-та их в базу данных (укажите любое имя для примера).");

        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя нового ребенка Ирины, это девочка: ");
        String irinaNewChildren = in.nextLine();
        System.out.println("Введите имя нового ребенка Васи, это мальчик: ");
        String vasyaNewChildren = in.nextLine();
        in.close();

        Person vasyaNew = new Person(vasyaNewChildren);
        Person irinaNew = new Person(irinaNewChildren);

        gt.append(irina, irinaNew);
        gt.append(vasya, vasyaNew);

        System.out.println("\nПосле обновления базы данных новая информация о следующих родителях и их детях:");
        System.out.println("Родитель Ирина, дети: " + new Reserch(gt).spend(irina,
                Relationship.parent));
        System.out.println("Родитель Вася, дети: " + new Reserch(gt).spend(vasya,
                Relationship.parent));
    }
}
