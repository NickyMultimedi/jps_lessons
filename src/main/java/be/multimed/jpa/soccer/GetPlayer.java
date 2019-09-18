package be.multimed.jpa.soccer;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class GetPlayer {
    public static void main(String[] args) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            PlayerPK primaryKeyForPlayer = new PlayerPK();
            primaryKeyForPlayer.setNumber(1);
            primaryKeyForPlayer.setClub("LA Galaxy");

            Player player = handler.getManager().find(Player.class, primaryKeyForPlayer);

            handler.commitTransaction();
            System.out.println(player.getName());
        }
    }
}
