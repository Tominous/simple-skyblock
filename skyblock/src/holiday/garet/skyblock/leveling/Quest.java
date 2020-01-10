package holiday.garet.skyblock.leveling;

import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import holiday.garet.skyblock.XMaterial;
import holiday.garet.skyblock.island.Island;
import holiday.garet.skyblock.island.SkyblockPlayer;

public class Quest {
	ConfigurationSection quests;
	Island island;
	String questID;
	SkyblockPlayer player;
	
	public Quest(ConfigurationSection _quests, Island _island, String _questID, SkyblockPlayer _player) {
		quests = _quests;
		island = _island;
		questID = _questID;
		player = _player;
	}
	
	public boolean testRequirements() {
		Player p = player.getPlayer();
		if (p != null && !island.hasAchieved(this)) {
			PlayerInventory pinv = p.getInventory();
			List<String> reqs = quests.getStringList(questID + ".requirements");
			boolean meetsReqs = true;
			for (int i = 0; i < reqs.size(); i++) {
				ItemStack req = new ItemStack(XMaterial.matchXMaterial(reqs.get(i).split(":")[0]).get().parseMaterial(), Integer.valueOf(reqs.get(i).split(":")[1]));
				if (!pinv.contains(req)) {
					meetsReqs = false;
				}
			}
			return meetsReqs;
		}
		return false;
	}
	
	public void achieve() {
		if (testRequirements()) {
			Player p = player.getPlayer();
			if (p != null) {
				// remove items
				PlayerInventory pinv = p.getInventory();
				List<String> reqs = quests.getStringList(questID + ".requirements");
				List<String> rews = quests.getStringList(questID + ".rewards");
				for (int i = 0; i < reqs.size(); i++) {
					ItemStack req = new ItemStack(XMaterial.matchXMaterial(reqs.get(i).split(":")[0]).get().parseMaterial(), Integer.valueOf(reqs.get(i).split(":")[1]));
					pinv.remove(req);
				}
				// add rewards
				for (int i = 0; i < rews.size(); i++) {
					ItemStack req = new ItemStack(XMaterial.matchXMaterial(rews.get(i).split(":")[0]).get().parseMaterial(), Integer.valueOf(rews.get(i).split(":")[1]));
					pinv.addItem(req);
				}
				// add to island achieved quests
				island.achieve(this);
			}
		}
	}
	
	public String getID() {
		return questID;
	}
}
