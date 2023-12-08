package fr.iwezix.mymod.item;

import fr.iwezix.mymod.MyMod;
import fr.iwezix.mymod.MyModCreativeTabs;
import fr.iwezix.mymod.item.custom.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MyModItem {
    public final static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MODID);

    // list of items
    public final static RegistryObject<Item> MY_ITEM =
            ITEMS.register("my_item", () ->
                    new Item(new Item.Properties().tab(MyModCreativeTabs.MY_MOD_TAB)
                            .stacksTo(64)));

    public final static RegistryObject<Item> HEAL_STICK =
            ITEMS.register("heal_stick", () ->
                    new HealStickItem(new Item.Properties().tab(MyModCreativeTabs.STICK_TAB)
                            .durability(10).rarity(Rarity.RARE)));

    public final static RegistryObject<Item> SPEED_STICK =
            ITEMS.register("speed_stick", () ->
                    new SpeedStickItem(new Item.Properties().tab(MyModCreativeTabs.STICK_TAB)
                            .durability(10).rarity(Rarity.RARE)));

    public final static RegistryObject<Item> STRONG_STICK =
            ITEMS.register("strong_stick", () ->
                    new StrongStickItem(new Item.Properties().tab(MyModCreativeTabs.STICK_TAB)
                            .durability(10).rarity(Rarity.RARE)));

    public final static RegistryObject<Item> JUMP_STICK =
            ITEMS.register("jump_stick", () ->
                    new JumpStickItem(new Item.Properties().tab(MyModCreativeTabs.STICK_TAB)
                            .durability(10).rarity(Rarity.RARE)));

    public final static RegistryObject<Item> STICK_OF_GOD =
            ITEMS.register("stick_of_god", () ->
                    new StickOfGodItem(new Item.Properties().tab(MyModCreativeTabs.STICK_TAB)
                            .durability(5).rarity(Rarity.EPIC)));

    public final static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
