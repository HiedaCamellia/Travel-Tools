package cn.solarmoon.travel_tools.core.common.registry;

import cn.solarmoon.solarmoon_core.api.common.registry.CreativeTabEntry;
import cn.solarmoon.travel_tools.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

public class TTCreativeTabs {
    public static void register() {}

    public static final CreativeTabEntry MAIN = TravelTools.REGISTRY.creativeTab()
            .id(TravelTools.MOD_ID)
            .builder(CreativeModeTab.builder()
                    .title(TravelTools.TRANSLATOR.set("creative_mode_tab", "main"))
                    .icon(() -> new ItemStack(TTItems.TREKKING_POLE.get()))
                    .displayItems((params, output) ->
                            TravelTools.REGISTRY.itemRegister.getEntries().stream()
                                    .map(RegistryObject::get)
                                    .toList()
                                    .forEach(output::accept)
                    ))
            .build();

}
