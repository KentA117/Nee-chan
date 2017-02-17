package utils;

import java.util.HashMap;
import javax.security.auth.login.LoginException;
import command.PingCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import utils.BotListener;
import utils.Command;

public class Bot {

	private static JDA jda;

	public static final String BOT_TOKEN = "MjgyMDg2NjI2NjczMjk1MzYw.C4hZRA.8vkBwfo_n8DojQ9j6EQIJLCFtvM";

	public static HashMap<String, Command> commands = new HashMap<String, Command>();

	public static final CommandParser parser = new CommandParser();

	public static void main(String[] args) {

		try {
			jda = new JDABuilder(AccountType.BOT).addListener(new BotListener()).setToken(BOT_TOKEN).buildBlocking();
			jda.setAutoReconnect(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		commands.put("ping", new PingCommand());
	}

	public static void handleCommand(CommandParser.CommandContainer cmd) {
		if (commands.containsKey(cmd.invoke)) {
			boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
			if (safe) {
				commands.get(cmd.invoke).action(cmd.args, cmd.event);
				commands.get(cmd.invoke).executed(safe, cmd.event);
			} else {
				commands.get(cmd.invoke).executed(safe, cmd.event);

			}
		}
	}

}
