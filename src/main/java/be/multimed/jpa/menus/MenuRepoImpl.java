package be.multimed.jpa.menus;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;
import org.w3c.dom.Entity;

public class MenuRepoImpl implements MenuRepo {
    @Override
    public void save(Menu menu) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            handler.merge(menu);

            handler.commitTransaction();
        }
    }

    @Override
    public Menu find(long menuId) {
        Menu menu;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            menu = handler.find(Menu.class, menuId);

            handler.commitTransaction();
        }

        return menu;
    }
}
