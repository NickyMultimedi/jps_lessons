package be.multimed.jpa.menus;

import be.multimed.jpa.menus.ingredients.Ingredient;

import java.util.ArrayList;
import java.util.Collection;

public class MenuMainApp {
    public static void main(String[] args) {
        MenuRepo repo = new MenuRepoImpl();

        Collection<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(2, "Koreander"));
        ingredients.add(new Ingredient(3, "zout"));

        Menu menu = new Menu(
                "Herbalism",
                ingredients
        );

        repo.save(menu);

        System.out.println(repo.find(1));
    }
}
