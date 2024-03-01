package fr.iwezix.mymod.block;

import fr.iwezix.mymod.MyMod;
import fr.iwezix.mymod.MyModCreativeTabs;
import fr.iwezix.mymod.block.custom.*;
import fr.iwezix.mymod.item.MyModItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * This class is used to register all the blocks of the mod.
 */
public class MyBlock {

  public final static DeferredRegister<Block> BLOCKS = DeferredRegister.create(
      ForgeRegistries.BLOCKS, MyMod.MODID);

  /**
   * Register the block in the game. Type : Block Name : my_block
   */
  public static final RegistryObject<Block> MY_BLOCK =
      registerBlock("my_block", () ->
          new MyBlockBlock(
              // give properties to the block
              BlockBehaviour.Properties
                  // Set the material of the block to METAL
                  .of(Material.METAL)
                  // Set the sound of the block to METAL
                  .sound(SoundType.METAL)
              // Set the light level of the block to 15
          ), MyModCreativeTabs.MY_MOD_TAB
      );

  public static final RegistryObject<Block> CIRCULATION_INTERDITE =
      registerBlock("circulation_interdite", () ->
          new SignalisationInterditeBlock(
              BlockBehaviour.Properties
                  .of(Material.STONE)
                  .noOcclusion()
          ), MyModCreativeTabs.SIGNALISATION_TAB
      );

  public static final RegistryObject<Block> POTEAU =
      registerBlock("poteau", () ->
          new SignalisationPoteauBlock(
              BlockBehaviour.Properties
                  .of(Material.STONE)
                  .noOcclusion()
          ), MyModCreativeTabs.SIGNALISATION_TAB
      );

  public static final RegistryObject<Block> CIRCULATION_STOP =
      registerBlock("circulation_stop", () ->
          new SignalisationStopBlock(
              BlockBehaviour.Properties
                  .of(Material.STONE)
                  .noOcclusion()
          ), MyModCreativeTabs.SIGNALISATION_TAB
      );

  public static final RegistryObject<Block> CIRCULATION_CEDER_LE_PASSAGE =
      registerBlock("circulation_ceder_le_passage", () ->
          new SignalisationCederLePassageBlock(
              BlockBehaviour.Properties
                  .of(Material.STONE)
                  .noOcclusion()
          ), MyModCreativeTabs.SIGNALISATION_TAB
      );

  public static final RegistryObject<Block> CIRCULATION_SENS_INTERDIT =
      registerBlock("circulation_sens_interdit", () ->
          new SignalisationSensInterditBlock(
              BlockBehaviour.Properties
                  .of(Material.STONE)
                  .noOcclusion()
          ), MyModCreativeTabs.SIGNALISATION_TAB
      );

  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
      CreativeModeTab tab) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn, tab);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
      RegistryObject<T> block, CreativeModeTab tab) {
    return MyModItem.ITEMS.register(name,
        () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
  }

  public final static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
