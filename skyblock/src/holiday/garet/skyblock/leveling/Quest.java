package holiday.garet.skyblock.leveling;

import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import holiday.garet.skyblock.XMaterial;
import holiday.garet.skyblock.economy.Economy;
import holiday.garet.skyblock.island.Island;
import holiday.garet.skyblock.island.SkyblockPlayer;

public class Quest {
	ConfigurationSection quests;
	Island island;
	String questID;
	SkyblockPlayer player;
	Economy playerEcon;
	
	public Quest(ConfigurationSection _quests, String _questID, SkyblockPlayer _player, Economy _playerEcon) {
		quests = _quests;
		island = _player.getIsland();
		questID = _questID;
		player = _player;
		playerEcon = _playerEcon;
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
					String matName = rews.get(i).split(":")[0];
					int matAmnt = Integer.valueOf(rews.get(i).split(":")[1]);
					if (matName == "money") {
						if (playerEcon != null) {
							playerEcon.deposit(matAmnt);
						} else {
							
						}
					} else {
						ItemStack req = new ItemStack(XMaterial.matchXMaterial(matName).get().parseMaterial(), matAmnt);
						pinv.addItem(req);
					}
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
