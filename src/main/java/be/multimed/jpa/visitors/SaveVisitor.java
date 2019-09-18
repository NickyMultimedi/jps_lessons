package be.multimed.jpa.visitors;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class SaveVisitor {
    public static void main(String[] args) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            Visitor visitor = new Visitor();
            visitor.setFirstName("Nicky");
            visitor.setLastName("Bauters");
            visitor.setAge(28);

            handler.persist(visitor);
            handler.commitTransaction();
        }
    }
}
