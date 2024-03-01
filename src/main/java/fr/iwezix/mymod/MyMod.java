package fr.iwezix.mymod;

import com.mojang.logging.LogUtils;
import fr.iwezix.mymod.block.MyBlock;
import fr.iwezix.mymod.item.MyModItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(MyMod.MODID)
public class MyMod {

  public static final String MODID = "mymod";
  private static final Logger LOGGER = LogUtils.getLogger();

  public MyMod() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    LOGGER.info("MyMod starting...");

    MyModItem.register(modEventBus);
    MyBlock.register(modEventBus);

    MinecraftForge.EVENT_BUS.register(this);
  }
}
