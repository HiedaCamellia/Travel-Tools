package cn.solarmoon.travel_tools.core.common.registry;

import cn.solarmoon.solarmoon_core.api.common.registry.ItemEntry;
import cn.solarmoon.travel_tools.core.common.item.TrekkingPoleItem;
import cn.solarmoon.travel_tools.*;

public class TTItems {
    public static void register() {}

    public static final ItemEntry<TrekkingPoleItem> TREKKING_POLE = TravelTools.REGISTRY.item()
            .id("trekking_pole")
            .bound(TrekkingPoleItem::new)
            .build();

}
