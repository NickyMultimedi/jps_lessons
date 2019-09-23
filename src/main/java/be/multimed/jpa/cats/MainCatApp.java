package be.multimed.jpa.cats;

import java.time.LocalDate;

public class MainCatApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat(
                "Siamees",
                "Lupin Hervo",
                "Lupy",
                "Nick",
                "Mariakerke",
                LocalDate.of(1991, 03, 16)
        );

        CatRepo repo = new CatRepoImpl();
        CatPK pk = repo.save(cat1);
        Cat cat2 = repo.find(pk);

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat1 == cat2);
        System.out.println(cat1.equals(cat2));
    }
}
