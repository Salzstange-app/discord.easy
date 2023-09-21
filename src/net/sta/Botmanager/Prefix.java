package net.sta.Botmanager;

import managers.BotManager;

public class Prefix {

	public static String getPrefix() {
		return BotManager.Prefix == null ? "!" : BotManager.Prefix;
	}

	public static boolean hasPrefix() {
		return BotManager.Prefix == null ? false : true;
	}

}
