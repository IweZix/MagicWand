package fr.iwezix.mymod.item;

import fr.iwezix.mymod.MyMod;
import fr.iwezix.mymod.MyModCreativeTabs;
import fr.iwezix.mymod.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * This class is used to register all the items of the mod.
 */
public class MyModItem {

  public final static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
      MyMod.MODID);

  /**
   * Register the item in the game. Type : Item Name : my_item
   */
  public final static RegistryObject<Item> MY_ITEM =
      ITEMS.register("my_item", () ->
          new Item(
              // give properties to the item
              new Item.Properties()
                  // Add the item to the custom creative tab
                  .tab(MyModCreativeTabs.MY_MOD_TAB)
                  // Set the max stack size to 64
                  .stacksTo(64)
                  // Set the rarity to rare
                  .rarity(Rarity.EPIC)
                  // Set the durability to 10 uses
                  .durability(10)
                  // Set the item to be unbreakable
                  .setNoRepair()
          )
      );

  public final static RegistryObject<Item> HEAL_STICK =
      ITEMS.register("heal_stick", () ->
          new HealStickItem(
              new Item.Properties()
                  .tab(MyModCreativeTabs.STICK_TAB)
                  .durability(10)
                  .rarity(Rarity.RARE)
          )
      );

  public final static RegistryObject<Item> SPEED_STICK =
      ITEMS.register("speed_stick", () ->
          new SpeedStickItem(
              new Item.Properties()
                  .tab(MyModCreativeTabs.STICK_TAB)
                  .durability(10)
                  .rarity(Rarity.RARE)
          )
      );

  public final static RegistryObject<Item> STRONG_STICK =
      ITEMS.register("strong_stick", () ->
          new StrongStickItem(
              new Item.Properties()
                  .tab(MyModCreativeTabs.STICK_TAB)
                  .durability(10)
                  .rarity(Rarity.RARE)
          )
      );

  public final static RegistryObject<Item> JUMP_STICK =
      ITEMS.register("jump_stick", () ->
          new JumpStickItem(
              new Item.Properties().
                  tab(MyModCreativeTabs.STICK_TAB)
                  .durability(10)
                  .rarity(Rarity.RARE)
          )
      );

  public final static RegistryObject<Item> STICK_OF_GOD =
      ITEMS.register("stick_of_god", () ->
          new StickOfGodItem(
              new Item.Properties()
                  .tab(MyModCreativeTabs.STICK_TAB)
                  .durability(5)
                  .rarity(Rarity.EPIC)
          )
      );

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
