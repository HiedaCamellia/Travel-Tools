package cn.solarmoon.travel_tools.core.common.item;

import cn.solarmoon.solarmoon_core.api.util.UUIDGetter;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class TrekkingPoleItem extends Item {

    private final Multimap<Attribute, AttributeModifier> mainHandModifiers;
    private final Multimap<Attribute, AttributeModifier> offHandModifiers;

    public TrekkingPoleItem() {
        super(new Properties().stacksTo(1).durability(250));
        mainHandModifiers = warpAttributeModifier(EquipmentSlot.MAINHAND);
        offHandModifiers = warpAttributeModifier(EquipmentSlot.OFFHAND);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> origin = super.getAttributeModifiers(slot, stack);
        if (slot == EquipmentSlot.MAINHAND) return mainHandModifiers;
        if (slot == EquipmentSlot.OFFHAND) return offHandModifiers;
        return origin;
    }

    public static Multimap<Attribute, AttributeModifier> warpAttributeModifier(EquipmentSlot hand) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = getStepUUIDbyHand(hand);
        builder.put(ForgeMod.STEP_HEIGHT_ADDITION.get(), new AttributeModifier(uuid, "Tool Modifier", 1.5, AttributeModifier.Operation.ADDITION));
        return builder.build();
    }

    private static UUID getStepUUIDbyHand(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) return UUID.fromString("0687B232-ECE0-9405-DEFF-2FB3D0D22801");
        else if (slot == EquipmentSlot.OFFHAND) return UUID.fromString("E79ED0BC-A3CF-144D-DC1E-AA4181FB4566");
        return UUID.randomUUID();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotIndex, boolean isHeld) {
        if (entity instanceof LivingEntity living) {
            EquipmentSlot slot = LivingEntity.getEquipmentSlotForItem(stack);
            boolean flag = slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND;
            if (flag && living.getRandom().nextFloat() < 0.005 && !living.isFallFlying() && !living.isSwimming()) {
                BlockPos currentPos = living.blockPosition();
                BlockPos lastPos = BlockPos.of(living.getPersistentData().getLong("LastPos"));
                if (!currentPos.equals(lastPos)) {
                    stack.hurtAndBreak(1, living, e -> e.broadcastBreakEvent(LivingEntity.getEquipmentSlotForItem(stack)));
                }
                living.getPersistentData().putLong("LastPos", currentPos.asLong());
            }
        }
        super.inventoryTick(stack, level, entity, slotIndex, isHeld);
    }
}
