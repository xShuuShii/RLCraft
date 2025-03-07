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
package me.val_mobile.dragons;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
/**
 * DragonFightEvents is a class containing listener methods
 * that activate special dragon attacks based on each dragon's breed
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class DragonFightEvents implements Listener {

    /**
     * Drops Ice and Fire loot upon dragon, elder guardian, and wither death
     * @param event The event called when an entity dies
     * @see Dragon
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // if the entity that died was a dragon
        if (event.getEntity() instanceof Dragon) {
            Dragon dragon = (Dragon) event.getEntity();
            Location loc = dragon.getBukkitEntity().getLocation();
            World world = dragon.getBukkitEntity().getWorld();

            dragon.generateLoot();

            for (ItemStack loot: dragon.getLoot()) {
                world.dropItemNaturally(loc, loot);
            }
        }
    }
}