package command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.Command;

public class PingCommand implements Command {

	private final String HELP = "USAGE:~!ping";

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {

		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		event.getTextChannel().sendMessage("Pong");
	}

	@Override
	public String help() {

		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

		return;
	}

}