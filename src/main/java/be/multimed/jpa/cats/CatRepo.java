package be.multimed.jpa.cats;

public interface CatRepo {
    Cat find(CatPK pk);
    CatPK save(Cat cat);
}
