package be.multimed.jpa.menus;

public interface MenuRepo {
    void save(Menu menu);
    Menu find(long id);
}
