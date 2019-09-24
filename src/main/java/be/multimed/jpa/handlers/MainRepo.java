package be.multimed.jpa.handlers;

public interface MainRepo {
    <T> void save(T t);
    <T> T find(Class<T> aClass, long id);
}
