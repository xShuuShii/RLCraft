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
package me.val_mobile.sea_serpents;

import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SeaSerpentGearAbilities {

    public static void TideGuardianArmorAbility(Player player, int pieces) {

        int waterBreathingAmplifier = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.WaterBreathing.Amplifier");
        int waterBreathingDuration = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.WaterBreathing.Duration");

        int strengthAmplifier = pieces - 1 + CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.Strength.AmplifierPerArmorPiece");
        int strengthDuration = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.Strength.Duration");

        PotionEffect waterBreathing = new PotionEffect(PotionEffectType.WATER_BREATHING, waterBreathingDuration, waterBreathingAmplifier);
        if (player.isInWater()) {
            PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strengthDuration, strengthAmplifier);
            Utils.smartAddPotionEffect(strength, player);
        }
        Utils.smartAddPotionEffect(waterBreathing, player);
    }
}