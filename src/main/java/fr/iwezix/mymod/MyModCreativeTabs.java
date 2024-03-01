package fr.iwezix.mymod;

import fr.iwezix.mymod.block.MyBlock;
import fr.iwezix.mymod.block.custom.MyBlockBlock;
import fr.iwezix.mymod.item.MyModItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * This class is used to create custom creative tabs for the mod.
 */
public class MyModCreativeTabs {

  /**
   * The custom creative tab mytab.
   */
  public static final CreativeModeTab MY_MOD_TAB = new CreativeModeTab("mytab") {

    /**
     * Set the icon of the creative tab.
     * @return the icon of the creative tab.
     */
    @Override
    public @NotNull ItemStack makeIcon() {
      return new ItemStack(MyBlock.MY_BLOCK.get());
    }
  };

  /**
   * The custom creative tab stickTab.
   */
  public static final CreativeModeTab STICK_TAB = new CreativeModeTab("stickTab") {

    /**
     * Set the icon of the creative tab.
     * @return the icon of the creative tab.
     */
    @Override
    public @NotNull ItemStack makeIcon() {
      return new ItemStack(MyModItem.STICK_OF_GOD.get());
    }
  };

  /**
   * The custom creative tab signalisationTab.
   */
  public static final CreativeModeTab SIGNALISATION_TAB = new CreativeModeTab("signalisationTab") {

    /**
     * Set the icon of the creative tab.
     * @return the icon of the creative tab.
     */
    @Override
    public @NotNull ItemStack makeIcon() {
      return new ItemStack(MyBlock.MY_BLOCK.get());
    }
  };
}
