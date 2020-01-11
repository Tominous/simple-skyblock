package holiday.garet.skyblock.leveling;

import org.bukkit.configuration.ConfigurationSection;

import holiday.garet.skyblock.island.SkyblockPlayer;

public class Achievement {
	ConfigurationSection achievements;
	String achievementID;
	SkyblockPlayer player;
	
	public Achievement(ConfigurationSection _achievements, String _achievementID, SkyblockPlayer _player) {
		achievements = _achievements;
		achievementID = _achievementID;
		player = _player;
	}
}
