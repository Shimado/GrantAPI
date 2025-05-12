package com.github.Shimado.instances;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class GrantGroup {

    private String groupName;                                          // Название роли, если игрок имеет ее, то может пользоваться ей
    private int cooldown;                                              // Какой кулдаун будет, если игрок выдаст грант
    private int howMuch;                                               // Сколько игрок может выдать грантов, прежде чем не иметь возможности выдать
    private boolean canGiveSameDuringCooldown = false;                 // Может ли игрок выдавать этот же тип еще
    private boolean canGiveAnotherDuringCooldown = false;              // Может ли игрок выдавать этот же тип или другие еще
    private boolean canBeCancelled = false;                            // Может ли быть роль, которая активна отменена
    private boolean canGiveToAllPlayers = false;                       // Может ли быть выдана всем онлайн игрокам
    private boolean canPlayerWhoReceivedGroupGiveToOthers = false;     // Если игроку выдали роль, то не может выдавать грант. Будет использоваться грант по оригинальной роли
    private boolean canReplaceHigherOne = false;                       // Может ли заменить текущую более высокую роль менее приоритетной
    private Map<Integer, Duration> durations = new HashMap<>();        // Временные интервалы, доступные для выбора


    public GrantGroup(String groupName, int cooldown, int howMuch, boolean canGiveSameDuringCooldown, boolean canGiveAnotherDuringCooldown, boolean canPlayerWhoReceivedGroupGiveToOthers, boolean canGiveToAllPlayers){
        this.groupName = groupName;
        this.cooldown = cooldown;
        this.howMuch = howMuch;
        this.canGiveSameDuringCooldown = canGiveSameDuringCooldown;
        this.canGiveAnotherDuringCooldown = canGiveAnotherDuringCooldown;
        this.canPlayerWhoReceivedGroupGiveToOthers = canPlayerWhoReceivedGroupGiveToOthers;
        this.canGiveToAllPlayers = canGiveToAllPlayers;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public int getCooldown(){
        return this.cooldown;
    }

    public int getHowMuch(){
        return this.howMuch;
    }

    public boolean isCanGiveSameDuringCooldown(){
        return this.canGiveSameDuringCooldown;
    }

    public boolean isCanGiveAnotherDuringCooldown(){
        return this.canGiveAnotherDuringCooldown;
    }

    public boolean isCanBeCancelled(){
        return this.canBeCancelled;
    }

    public void setCanBeCancelled(boolean canBeCancelled){
        this.canBeCancelled = canBeCancelled;
    }

    public boolean isCanGiveToAllPlayers(){
        return this.canGiveToAllPlayers;
    }

    public void setCanGiveToAllPlayers(boolean canGiveToAllPlayers){
        this.canGiveToAllPlayers = canGiveToAllPlayers;
    }

    public boolean isCanPlayerWhoReceivedGroupGiveToOthers(){
        return this.canPlayerWhoReceivedGroupGiveToOthers;
    }

    public boolean isCanReplaceHigherOne(){
        return this.canReplaceHigherOne;
    }

    public void setCanReplaceHigherOne(boolean canReplaceHigherOne){
        this.canReplaceHigherOne = canReplaceHigherOne;
    }

    public Map<Integer, Duration> getDurations(){
        return this.durations;
    }

    public void setDurations(Map<Integer, Duration> durations){
        this.durations = durations;
    }


    public static class Duration {

        private int duration;            // Время действия роли
        private int slot;                // Слот на котором будет располагаться иконка
        private ItemStack icon;          // Сама иконка

        public Duration(int duration, int slot, ItemStack icon){
            this.duration = duration;
            this.slot = slot;
            this.icon = icon;
        }


        public int getDuration(){
            return this.duration;
        }

        public int getSlot(){
            return this.slot;
        }

        public ItemStack getIcon(){
            return this.icon;
        }

    }

}
