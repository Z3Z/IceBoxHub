package net.iceboxhub.main.handlers;

import net.iceboxhub.main.IceBoxHub;
import net.iceboxhub.main.utils.SimpleUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreBoardHandler implements Listener{
	
	private static IceBoxHub plugin;
	public ScoreBoardHandler(IceBoxHub listener) {
		ScoreBoardHandler.plugin = listener;
		boardUpdater();
	}
	
public static Scoreboard board;
public static Objective objective;
	
    public static void makeScoreBoard(final Player player){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        board = scoreboardManager.getNewScoreboard();
        objective = board.registerNewObjective("lobby","dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = objective.getScore(SimpleUtils.color("&a&lLevel"));
        score.setScore(14);
        Score score1 = objective.getScore(SimpleUtils.color(ChatColor.GREEN + "" + ChatColor.BOLD));
        score1.setScore(13);
        Score score2 = objective.getScore(SimpleUtils.color(" "));
        score2.setScore(12);
        Score score3 = objective.getScore(SimpleUtils.color("&e&lCoins"));
        score3.setScore(11);
        Score score4 = objective.getScore(SimpleUtils.color(ChatColor.YELLOW + "" + ChatColor.BOLD));
        score4.setScore(10);
        Score score5 = objective.getScore(SimpleUtils.color("  "));
        score5.setScore(9);
        Score score6 = objective.getScore(SimpleUtils.color("&5&lShards"));
        score6.setScore(8);
        Score score7 = objective.getScore(SimpleUtils.color(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD));
        score7.setScore(7);
        Score score8 = objective.getScore(SimpleUtils.color("   "));
        score8.setScore(6);
        Score score9 = objective.getScore(SimpleUtils.color("&b&lKills"));
        score9.setScore(5);
        Score score10 = objective.getScore(SimpleUtils.color(ChatColor.AQUA + "" + ChatColor.BOLD));
        score10.setScore(4);
        Score score11 = objective.getScore(SimpleUtils.color("    "));
        score11.setScore(3);
        Score score12 = objective.getScore(SimpleUtils.color("&c&lDeaths"));
        score12.setScore(2);
        Score score13 = objective.getScore(SimpleUtils.color(ChatColor.RED + "" + ChatColor.BOLD));
        score13.setScore(1);
        
        Team team1 = board.registerNewTeam("team1");
        team1.addEntry(ChatColor.GREEN + "" + ChatColor.BOLD);
        
        Team team2 = board.registerNewTeam("team2");
        team2.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD);

        Team team3 = board.registerNewTeam("team3");
        team3.addEntry(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD);
        
        Team team4 = board.registerNewTeam("team4");
        team4.addEntry(ChatColor.AQUA + "" + ChatColor.BOLD);
        
        Team team5 = board.registerNewTeam("team5");
        team5.addEntry(ChatColor.RED + "" + ChatColor.BOLD);
		player.setScoreboard(board);
    }
    
    public static void boardUpdater(){
    		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
        		public void run() {
        			for(final Player player : Bukkit.getOnlinePlayers()){
        			if(!(Bukkit.getOnlinePlayers().equals(0))){ 
        				
        			Team team1 = player.getScoreboard().getTeam("team1");
    				team1.setPrefix(SimpleUtils.color("&7&l" + "▶ "));
    				team1.setSuffix(SimpleUtils.color(""));
        			
    				Team team2 = player.getScoreboard().getTeam("team2"); 
    				team2.setPrefix(SimpleUtils.color("&7&l" + "▶ "));
    				team2.setSuffix(SimpleUtils.color(""));
    				
    				Team team3 = player.getScoreboard().getTeam("team3");
    				team3.setPrefix(SimpleUtils.color("&7&l" + "▶ "));
    				team3.setSuffix(SimpleUtils.color(""));
    				
    				Team team4 = player.getScoreboard().getTeam("team4");
    				team4.setPrefix(SimpleUtils.color("&7&l" + "▶ "));
    				team4.setSuffix(SimpleUtils.color(""));
    				
    				Team team5 = player.getScoreboard().getTeam("team5");
    				team5.setPrefix(SimpleUtils.color("&7&l" + "▶ "));
    				team5.setSuffix(SimpleUtils.color(""));
        			}else{
        				Bukkit.getScheduler().cancelTasks(plugin);
        			}
        			}
        			}
            	}, 0, 5);
    				
    				
    				//ScoreBoards DisplayName
    				Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin,new Runnable() {
						public void run() {
    				  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIceBox"));
						  }
					  }, 0);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&f&lI&b&lceBox"));
						  }
					  }, 3);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lI&f&lc&b&leBox"));
						  }
					  }, 6);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIc&f&le&b&lBox"));
						  }
					  }, 9);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIce&f&lB&b&lox"));
						  }
					  }, 12);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIceB&f&lo&b&lx"));
						  }
					  }, 15);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIceBo&f&lx"));
						  }
					  }, 18);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIceBox"));
						  }
					  }, 21);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&f&lIceBox"));
						  }
					  }, 24);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIceBox"));
						  }
					  }, 27);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&f&lIceBox"));
						  }
					  }, 30);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIceBox"));
						  }
					  }, 33);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&f&lIceBox"));
						  }
					  }, 36);
					  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
						  public void run() {
							  objective.setDisplayName(SimpleUtils.color("&b&lIceBox"));
						  }
					  }, 39);
				}
			}, 0, 42);
					//END OF SCOREBOARD DISPLAYNAME
    }
}