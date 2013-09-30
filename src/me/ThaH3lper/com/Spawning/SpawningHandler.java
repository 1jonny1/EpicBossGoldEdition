package me.ThaH3lper.com.Spawning;

import me.ThaH3lper.com.EpicBoss;
import me.ThaH3lper.com.Mobs.MobHandler;

import org.bukkit.entity.Animals;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;

public class SpawningHandler {
	
	public static boolean Spawn(LivingEntity l)
	{
		String type = "";
		if(l instanceof Monster) type = "Monster";
		else if(l instanceof Animals) type = "Animal";
		
		for(EpicSpawning es : EpicBoss.plugin.listSpawning)
		{
			boolean b = cheack(l, es, type);
			if(b) return true;
		}
		return false;
	}
	
	public static boolean cheack(LivingEntity l, EpicSpawning es, String type)
	{
		if(!es.worlds.contains(l.getWorld()))
			return false;
		if(!getType(es.em.Mobtype).equals(type))
			return false;
		if(es.chance >= EpicBoss.r.nextFloat())
		{
			MobHandler.SpawnMob(es.em.cmdName, l.getLocation());
			return true;
		}
		return false;
		
			
	}
	public static String getType(String name)
	{
		//Monsters
		if(name.equals("zombie") || name.equals("babyzombie") || name.equals("villagezombie") || name.equals("babyvillagezombie") || name.equals("silverfish"))
			return "Monster";
		else if(name.equals("wither") || name.equals("witch") || name.equals("spider") || name.equals("skeleton") || name.equals("witherskeleton"))
			return "Monster";
		else if(name.equals("pigzombie") || name.equals("angrypigzombie") || name.equals("babypigzombie") || name.equals("angrybabypigzombie"))
			return "Monster";
		else if(name.equals("giant") || name.equals("enderman") || name.equals("creeper") || name.equals("poweredcreeper"))
			return "Monster";
		else if(name.equals("cavespider") || name.equals("blaze"))
			return "Monster";
		
		//Passive/Animal
		else if(name.equals("wolf") || name.equals("babywolf") || name.equals("angrywolf") || name.equals("angrybabywolf"))
			return "Animal";
		else if(name.equals("sheep") || name.equals("babysheep") || name.equals("pig") || name.equals("babypig"))
			return "Animal";
		else if(name.equals("ocelot") || name.equals("babyocelot") || name.equals("mushroomcow") || name.equals("babymushroomcow"))
			return "Animal";
		else if(name.equals("horse") || name.equals("babyhorse") || name.equals("cow") || name.equals("babycow"))
			return "Animal";
		else if(name.equals("chicken") || name.equals("babychicken"))
			return "Animal";
		
		return "None";
	}
}