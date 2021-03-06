package com.bartz24.skyresources.plugin;

import java.util.ArrayList;

import com.bartz24.skyresources.plugin.actuallyadditions.ActAddPlugin;
import com.bartz24.skyresources.plugin.ae2.AE2Plugin;
import com.bartz24.skyresources.plugin.armorplus.ArmorPlusPlugin;
import com.bartz24.skyresources.plugin.ctweaker.CraftTweakerPlugin;
import com.bartz24.skyresources.plugin.dracevo.DEPlugin;
import com.bartz24.skyresources.plugin.embers.EmbersPlugin;
import com.bartz24.skyresources.plugin.extremereactors.ExtremeReactorsPlugin;
import com.bartz24.skyresources.plugin.forestry.ForestryPlugin;
import com.bartz24.skyresources.plugin.integdyn.IntegratedDynamicsPlugin;
import com.bartz24.skyresources.plugin.tconstruct.TConPlugin;
import com.bartz24.skyresources.plugin.techreborn.TechRebornPlugin;
import com.bartz24.skyresources.plugin.theoneprobe.TOPPlugin;
import com.bartz24.skyresources.plugin.thermal.ThermalPlugin;

import net.minecraftforge.fml.common.Loader;

public class ModPlugins
{
	public static ArrayList<IModPlugin> plugins = new ArrayList<IModPlugin>();

	public static void preInit()
	{
		if (Loader.isModLoaded("theoneprobe"))
			plugins.add(new TOPPlugin());
		if (Loader.isModLoaded("thermalfoundation"))
			plugins.add(new ThermalPlugin());
		if (Loader.isModLoaded("forestry"))
			plugins.add(new ForestryPlugin());
		if (Loader.isModLoaded("tconstruct"))
			plugins.add(new TConPlugin());
		if (Loader.isModLoaded("techreborn"))
			plugins.add(new TechRebornPlugin());
		// if (Loader.isModLoaded("environmentaltech"))
		// plugins.add(new EnvTechPlugin());
		if (Loader.isModLoaded("armorplus"))
			plugins.add(new ArmorPlusPlugin());
		if (Loader.isModLoaded("integrateddynamics"))
			plugins.add(new IntegratedDynamicsPlugin());
		if (Loader.isModLoaded("bigreactors"))
			plugins.add(new ExtremeReactorsPlugin());
		if (Loader.isModLoaded("actuallyadditions"))
			plugins.add(new ActAddPlugin());
		if (Loader.isModLoaded("embers"))
			plugins.add(new EmbersPlugin());
		if (Loader.isModLoaded("appliedenergistics2"))
			plugins.add(new AE2Plugin());
		if (Loader.isModLoaded("draconicevolution"))
			plugins.add(new DEPlugin());
		if (Loader.isModLoaded("crafttweaker"))
			plugins.add(new CraftTweakerPlugin());
		if (Loader.isModLoaded("theoneprobe"))
			plugins.add(new TOPPlugin());

		for (IModPlugin p : plugins)
		{
			p.preInit();
		}

		/*
		 * if (Loader.isModLoaded("EnderIO")) EnderIOPlugin.preInit(); if
		 * (Loader.isModLoaded("quantumflux")) QFluxPlugin.preInit();
		 */
	}

	public static void init()
	{
		for (IModPlugin p : plugins)
		{
			p.init();
		}
	}

	public static void postInit()
	{
		for (IModPlugin p : plugins)
		{
			p.postInit();
		}
	}

	public static void initRenderers()
	{
		for (IModPlugin p : plugins)
		{
			p.initRenderers();
		}
	}
}
