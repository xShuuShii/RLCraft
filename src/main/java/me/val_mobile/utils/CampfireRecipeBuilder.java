/*
    Copyright (C) 2021  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.utils;

import me.val_mobile.rlcraft.RLCraftPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

import java.util.Objects;

public class CampfireRecipeBuilder extends CampfireRecipe {

    public CampfireRecipeBuilder(FileConfiguration config, int index, RLCraftPlugin instance) {
        super(new NamespacedKey(instance, config.getString(index + ".Key")),
                Objects.equals(config.getString(index + ".Result.Item"), config.getString(index + ".Result.Item").toUpperCase())
                        ? new ItemStack(Material.valueOf(config.getString(index + ".Result.Item")), config.getInt(index + ".Result.Amount")) :
                        ItemBuilder.getItem(ItemBuilder.getItemMap().get(config.getString(index + ".Result.Item"))).resize(config.getInt(index + ".Result.Amount")),
                Objects.equals(config.getString(index + ".Input"), config.getString(index + ".Input").toUpperCase())
                        ? (Utils.getTags().containsKey(config.getString(index + ".Input")) ? new RecipeChoice.MaterialChoice(Utils.getTags().get(config.getString(index + ".Input"))) : new RecipeChoice.MaterialChoice(Material.valueOf(config.getString(index + ".Input"))))
                        : new RecipeChoice.ExactChoice(ItemBuilder.getItem(ItemBuilder.getItemMap().get(config.getString(index + ".Input")))),
                (float) config.getDouble(index + ".Experience"),
                config.getInt(index + ".CookingTime"));
    }
}
