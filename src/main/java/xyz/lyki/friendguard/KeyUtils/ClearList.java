package xyz.lyki.friendguard.KeyUtils;

import java.util.ArrayList;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.EndTick;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.KeyBinding.Category;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Type;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import xyz.lyki.friendguard.FriendGuard;
import xyz.lyki.friendguard.FriendGuardClient;

public class ClearList {
   public static final String KEY_CLEARLIST = "Clear Protected List";
   public static KeyBinding clearlist;
   public static ArrayList<String> silineceklerlistesi = FriendGuard.ProtectedPlayers;
   public static boolean isModEnabled;

   public static void registerKeyInputs() {
      ClientTickEvents.END_CLIENT_TICK.register((EndTick)client -> {
         if (clearlist.wasPressed()) {
            if (isModEnabled) {
               if (silineceklerlistesi.isEmpty()) {
                  String message = FriendGuardClient.messages.get("listAlreadyEmpty");
                  client.inGameHud.getChatHud().addMessage(Text.literal(message).formatted(Formatting.RED));
               } else {
                  silineceklerlistesi.clear();
                  String message = FriendGuardClient.messages.get("listCleared");
                  client.inGameHud.getChatHud().addMessage(Text.literal(message).formatted(Formatting.GREEN));
               }
            } else {
               String errorMessage = FriendGuardClient.messages.get("FriendGuardDisabled");
               client.inGameHud.getChatHud().addMessage(Text.literal(errorMessage).formatted(Formatting.RED));
            }
         }
      });
   }

   public static void register() {
      clearlist = KeyBindingHelper.registerKeyBinding(new KeyBinding("Clear Protected List", Type.KEYSYM, InputUtil.UNKNOWN_KEY.getCode(), Category.MISC));
      registerKeyInputs();
   }
}
