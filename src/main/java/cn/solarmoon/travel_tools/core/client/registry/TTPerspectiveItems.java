package cn.solarmoon.travel_tools.core.client.registry;

import cn.solarmoon.solarmoon_core.core.client.event.PerspectiveItemRegister;
import cn.solarmoon.travel_tools.core.common.registry.TTItems;

public class TTPerspectiveItems {

    public static void register() {
        PerspectiveItemRegister.put(TTItems.TREKKING_POLE::get);
    }

}
