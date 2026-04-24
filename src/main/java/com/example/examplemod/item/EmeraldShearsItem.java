package com.example.examplemod.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.enchantment.Enchantments;

public class EmeraldShearsItem extends ShearsItem
{
    public EmeraldShearsItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public ItemStack getDefaultInstance()
    {
        ItemStack stack = new ItemStack(this);
        stack.enchant(Enchantments.BLOCK_FORTUNE, 1);
        return stack;
    }
}