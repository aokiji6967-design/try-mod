package xyz.lyki.friendguard;

import java.util.ArrayList;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FriendGuard implements ModInitializer {
   public static final String MOD_ID = "FriendGuard";
   public static final Logger LOGGER = LogManager.getLogger("FriendGuard");
   public static ArrayList<String> ProtectedPlayers = new ArrayList<>();

   public void onInitialize() {
      LOGGER.info("No Friendly Fire by lykiaofficial (https://lyki.dev)");
   }
}
