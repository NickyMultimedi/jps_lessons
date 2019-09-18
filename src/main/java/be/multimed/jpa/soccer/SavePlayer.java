package be.multimed.jpa.soccer;

import be.multimed.jpa.handlers.EntityHandlerImpl;

public class SavePlayer {
    public static void main(String[] args) {
        try (EntityHandlerImpl handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            Player player = new Player();
            player.setNumber(2);
            player.setClub("LA Galaxy");
            player.setName("Markske");

            handler.persist(player);
            handler.commitTransaction();

            System.out.println("Player Saved");
        }
    }
}
