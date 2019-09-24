package be.multimed.jpa.menus;

import be.multimed.jpa.menus.ingredients.Ingredient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Menu")
public class Menu implements Serializable {
    @Id @Column(name = "Id") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "Title") String title;
    @ElementCollection(fetch = FetchType.EAGER) Collection<Ingredient> ingredients = new ArrayList<>();

    public Menu() {
    }

    public Menu(String title, Collection<Ingredient> ingredients) {
        this.title = title;
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return getId() == menu.getId() &&
                Objects.equals(getTitle(), menu.getTitle()) &&
                Objects.equals(getIngredients(), menu.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getIngredients());
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
