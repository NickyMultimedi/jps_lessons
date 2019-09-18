package be.multimed.jpa.visitors;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class GetVisitor {
    public static void main(String[] args) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            
        }
    }
}
