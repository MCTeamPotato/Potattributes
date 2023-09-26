package com.teampotato.potattributes.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.teampotato.potattributes.Potattributes;
import net.minecraftforge.fml.loading.FMLLoader;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class AttributeConfig {
    public double initialCriticalAttackChance;
    public double maxCriticalAttackChance;
    public double maxCriticalAttackDamageBonus;
    public double maxDamageReduction;
    public boolean disableVanillaCriticalAttack;

    public AttributeConfig() {
        File config = new File(FMLLoader.getGamePath().toFile(), "config");
        if (!config.exists()) {
            config.mkdirs();
        }
        File configFile = new File(config, Potattributes.MOD_ID + ".json");
        if (!configFile.exists()) {
            try {
                FileWriter writer = writeFile(configFile);
                writer.close();
            } catch (Exception e) {
                return;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            JsonObject configObj = JsonParser.parseReader(reader).getAsJsonObject();
            initialCriticalAttackChance = configObj.get("initialCriticalAttackChance").getAsDouble();
            maxCriticalAttackChance = configObj.get("maxCriticalAttackChance").getAsDouble();
            maxCriticalAttackDamageBonus = configObj.get("maxCriticalAttackDamageBonus").getAsDouble();
            maxDamageReduction = configObj.get("maxDamageReduction").getAsDouble();
            disableVanillaCriticalAttack = configObj.get("disableVanillaCriticalAttack").getAsBoolean();
        } catch (Throwable e) {
            throw new RuntimeException();
        }
    }

    @NotNull
    private static FileWriter writeFile(File configFile) throws IOException {
        JsonObject defaultConfig = new JsonObject();
        defaultConfig.addProperty("initialCriticalAttackChance", 0.25D);
        defaultConfig.addProperty("maxCriticalAttackChance", 0.60D);
        defaultConfig.addProperty("maxCriticalAttackDamageBonus", 0.40D);
        defaultConfig.addProperty("maxDamageReduction", 0.30D);
        defaultConfig.addProperty("disableVanillaCriticalAttack", true);
        FileWriter writer = new FileWriter(configFile);
        writer.write(defaultConfig.toString());
        return writer;
    }
}
