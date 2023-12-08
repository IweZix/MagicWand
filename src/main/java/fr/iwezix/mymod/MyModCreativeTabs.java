package fr.iwezix.mymod;

import fr.iwezix.mymod.block.MyBlock;
import fr.iwezix.mymod.block.custom.MyBlockBlock;
import fr.iwezix.mymod.item.MyModItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MyModCreativeTabs {
    public static final CreativeModeTab MY_MOD_TAB = new CreativeModeTab("mytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MyBlock.MY_BLOCK.get());
        }
    };

    public static final CreativeModeTab STICK_TAB = new CreativeModeTab("stickTab") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(MyModItem.STICK_OF_GOD.get());}
    };

    public static final CreativeModeTab SIGNALISATION_TAB = new CreativeModeTab("signalisationTab") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(MyBlock.MY_BLOCK.get());}
    };
}
