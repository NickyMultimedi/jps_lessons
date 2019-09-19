package be.multimed.jpa.cats;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;
import org.w3c.dom.Entity;

public class CatRepoImpl implements CatRepo {
    @Override
    public Cat find(CatPK pk) {
        Cat cat;
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            cat = handler.find(Cat.class, pk);

            handler.commitTransaction();
        }

        return cat;
    }

    @Override
    public CatPK save(Cat cat) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            handler.persist(cat);

            handler.commitTransaction();
        }

        return getPrimaryKey(cat);
    }

    CatPK getPrimaryKey(Cat cat) {
        return new CatPK(
                cat.getNaam(),
                cat.getRas(),
                cat.getGeboorteDatum()
        );
    }
}
