package utils;

import java.util.ArrayList;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandParser {
	public CommandContainer parse(String rw, MessageReceivedEvent e) {

		ArrayList<String> split = new ArrayList<String>();
		String raw = rw;
		String beheaded = raw.replaceFirst("*", "");
		String[] splitBeheaded = beheaded.split(" ");
		for (String s : splitBeheaded) {
			split.add(s);
		}
		String invoke = split.get(0);
		String[] args = new String[split.size() - 1];
		split.subList(1, split.size()).toArray(args);

		return new CommandContainer(invoke, invoke, args, invoke, args, e);
	}

	public class CommandContainer {
		public String beheaded;
		public String[] splitBeheaded;
		public String[] args;
		public MessageReceivedEvent event;
		public String invoke;
		public String raw;

		public CommandContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args,
				MessageReceivedEvent e) {
			this.raw = rw;
			this.beheaded = beheaded;
			this.splitBeheaded = splitBeheaded;
			this.invoke = invoke;
			this.args = args;
			this.event = e;
		}
	}
}
