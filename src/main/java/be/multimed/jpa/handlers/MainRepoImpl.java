package be.multimed.jpa.handlers;

public abstract class MainRepoImpl implements MainRepo {
    @Override
    public <T> void save(T t) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            handler.merge(t);

            handler.commitTransaction();
        }
    }

    @Override
    public <T> T find(Class<T> aClass, long id) {
        T t;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            t = handler.find(aClass, id);

            handler.commitTransaction();
        }

        return t;
    }
}
