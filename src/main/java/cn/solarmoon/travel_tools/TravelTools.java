package cn.solarmoon.travel_tools;

import cn.solarmoon.solarmoon_core.api.ObjectRegistry;
import cn.solarmoon.solarmoon_core.api.SolarMoonBase;
import cn.solarmoon.solarmoon_core.api.util.static_utor.Translator;
import cn.solarmoon.travel_tools.core.client.registry.TTPerspectiveItems;
import cn.solarmoon.travel_tools.core.common.registry.TTCreativeTabs;
import cn.solarmoon.travel_tools.core.common.registry.TTItems;
import net.minecraftforge.fml.common.Mod;

@Mod(TravelTools.MOD_ID)
public class TravelTools extends SolarMoonBase {

    public static final String MOD_ID = "travel_tools";
    public static final ObjectRegistry REGISTRY = ObjectRegistry.create(MOD_ID);
    public static final Translator TRANSLATOR = Translator.create(MOD_ID);

    @Override
    public void objectsClientOnly() {

    }

    @Override
    public void objects() {
        TTItems.register();
        TTCreativeTabs.register();
    }

    @Override
    public void eventObjectsClientOnly() {
        TTPerspectiveItems.register();
    }

    @Override
    public void eventObjects() {

    }

    @Override
    public void xData() {

    }

    @Override
    public void compats() {

    }

}
