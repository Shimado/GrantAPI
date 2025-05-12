package com.github.Shimado;

import org.bukkit.inventory.ItemStack;
import com.github.Shimado.instances.GrantGroup;

import java.util.List;
import java.util.UUID;

public interface GrantAPI {

    /**
     * Gives items to the player, taking into account cooldown and history.
     * @param playerWhoGaveUUID - The player initiating the command.
     * @param playerToGiveUUIDs - UUID of the players who will be given the grant. If there are more than 1 players, it will be considered a mass issue.
     * @param grandInstanceID - ID of the grant. Needs to check if already has cooldown with this name. Can be any value.
     * @param itemsDrop - List of items that will be given to the player.
     * @param itemsDropAsStringList - List of items in text format. As you specify them, so they will be indicated in the GUI.
     * @param grantGroup - Cooldown data set. Specifies the cooldown, how long it can be used, etc.
     * @param servers - IP of servers where it will be issued. If the list is empty, then only on this one.
     * **/

    boolean giveGrantItem(UUID playerWhoGaveUUID, List<UUID> playerToGiveUUIDs, String grandInstanceID, List<ItemStack> itemsDrop, List<String> itemsDropAsStringList, GrantGroup grantGroup, List<String> servers);


    /**
     * Dispatch commands to the player, taking into account cooldown and history.
     * @param playerWhoGaveUUID - The player initiating the command.
     * @param playerToGiveUUIDs - UUID of the players who will be given the grant. If there are more than 1 players, it will be considered a mass issue.
     * @param grandInstanceID - ID of the grant. Needs to check if already has cooldown with this name. Can be any value.
     * @param commands - List of commands that will be given to the player. In raw format. Example: eco give %player% 100
     * @param commandsToCancel - List of commands that will be given to the player. In raw format. Example: eco take %player% 100. Needed to cancel the command. Can be an empty list []
     * @param grantGroup - Cooldown data set. Specifies the cooldown, how long it can be used, etc.
     * @param servers - IP of servers where it will be issued. If the list is empty, then only on this one.
     * **/

    boolean giveGrantCommand(UUID playerWhoGaveUUID, List<UUID> playerToGiveUUIDs, String grandInstanceID, List<String> commands, List<String> commandsToCancel, GrantGroup grantGroup, List<String> servers);


    /**
     * Give group to the player, taking into account cooldown and history.
     * @param playerWhoGaveUUID - The player initiating the command.
     * @param playerToGiveUUIDs - UUID of the players who will be given the grant. If there are more than 1 players, it will be considered a mass issue.
     * @param grandInstanceID - ID of the grant. Needs to check if already has cooldown with this name. Can be any value.
     * @param group - The group that will be given to the player.
     * @param commands - List of commands that will be given to the player. In raw format. Example: lp user %player% parent addtemp 3d
     * @param commandsToCancel - List of commands that will be given to the player. In raw format. Example: eco take %player% 100. Needed to cancel the command. Can be an empty list []
     * @param isHasTimer - If command has deactivation timer.
     * @param isHasDataBase - If the plugin command has a database connection. Specify true to avoid double deletion.
     * @param grantGroup - Cooldown data set. Specifies the cooldown, how long it can be used, etc.
     * @param duration - For how many seconds the group will be given. -1 for infinity.
     * @param servers - IP of servers where it will be issued. If the list is empty, then only on this one.
     * **/

    boolean giveGrantPrivilege(UUID playerWhoGaveUUID, List<UUID> playerToGiveUUIDs, String grandInstanceID, String group, List<String> commands, List<String> commandsToCancel, boolean isHasTimer, boolean isHasDataBase, GrantGroup grantGroup, int duration, List<String> servers);


    /**
     * Revokes an active group that was granted by this plugin.
     * @param playerWhoGaveUUID - The player initiating the command.
     * @param historyUUID - UUID of the history.
     * **/

    boolean cancelGrantPrivilege(UUID playerWhoGaveUUID, UUID historyUUID);


    /**
     * Give the player a primary group that will be returned to him if all existing privileges are cancelled.
     * @param playerUUID - UUID of the player you want to check.
     * **/

    String getPrimaryGroup(UUID playerUUID);


    /**
     * Returns the player's group when it was obtained by this plugin.
     * @param playerUUID - UUID of the player you want to check.
     * **/

    String getTemporaryGroup(UUID playerUUID);


    /**
     * Returns the player's current group according primary and temporary groups.
     * @param playerUUID - UUID of the player you want to check.
     * **/

    String getCurrentGroup(UUID playerUUID);

}
