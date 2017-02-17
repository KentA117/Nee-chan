package utils;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getMessage().getContent().startsWith("*")
				&& event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId()) {
			Bot.handleCommand(Bot.parser.parse(event.getMessage().getContent().toLowerCase(), event));
		}
	}

	@Override
	public void onReady(ReadyEvent e) {
		Bot.log("status", "Logged in as : " +
		e.getJDA().getSelfInfo().getUsername() );
	}

}