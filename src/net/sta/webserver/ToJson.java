package net.sta.webserver;

import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.internal.entities.ReceivedMessage;
import net.sta.managers.BotManager;
import net.sta.webserver.web.modules.GetTickets;
import okhttp3.internal.concurrent.Task;

import static net.sta.managers.BotManager.jda;

public class ToJson {
	
	JDA jda;
	Collection<Member> list;

	
	public ToJson(JDA jda) {
		this.jda = jda;
		list = jda.getGuilds().get(0).getMembers();

	}


	//dort gette ich dich also username user id
	public String Member() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int x = 2;
		for(Member a : jda.getGuilds().get(0).getMembers()) {
			if (!a.getUser().isBot()) {
				if (x <= jda.getGuilds().get(0).getMembers().size() -1) {
					builder.append("{\"userId\": \"").append(a.getId()).append("\",").append("\"Member\": \"").append(a.getUser().getName()).append("\"},");
					x++;
				} else {
					builder.append("{\"userId\": \"").append(a.getId()).append("\",").append("\"Member\": \"").append(a.getUser().getName()).append("\"}");
					x = 0;
				}
			}

		}
		builder.append("]");
		return builder.toString();
	}
	
	// und hier dein avatar
	public String AvatarUrl() {

		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int x = 1;
		for(Member a : jda.getGuilds().get(0).getMembers()) {
			if (x+1 <= jda.getGuilds().get(0).getMembers().size()){
				builder.append("{\"userId\": \"").append(a.getId()).append("\",").append("\"Avatar\": \"").append(a.getUser().getAvatarUrl()).append("\"},");
				x++;
			}else {
				builder.append("{\"userId\": \"").append(a.getId()).append("\",").append("\"Avatar\": \"").append(a.getUser().getAvatarUrl()).append("\"}");
				x = 1;
			}
		}
		builder.append("]");
		return builder.toString();


	}


	static Integer OnlineMember = 0;
	static Integer OfflineMember = 0;
	static Integer IdleMember = 0;
	static Integer DoNotDisturbMember = 0;


	public String MemberOnlineStats() {
		StringBuilder builder = new StringBuilder();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {

				for (Member member : jda.getGuilds().get(0).getMembers()){
					if (!member.getUser().isBot()) {
						switch (member.getOnlineStatus()) {
							case ONLINE -> OnlineMember++;
							case OFFLINE -> OfflineMember++;
							case IDLE -> IdleMember++;
							case DO_NOT_DISTURB -> DoNotDisturbMember++;
						}
					}
				}
				System.out.println("Online Member " + OnlineMember);
				System.out.println("Offline Member " +OfflineMember);
				System.out.println("Abwesende Member " +IdleMember);
				System.out.println("Nicht störend Member " +DoNotDisturbMember);



				builder.append("[");

				builder.append("{\"Online\": \"").append(OnlineMember).append("\",").append("\"Offline\": \"").append(OfflineMember).append("\",").append("\"Idle\": \"").append(IdleMember).append("\",").append("\"DoNotDisturb\": \"").append(DoNotDisturbMember).append("\"}");
				OnlineMember = 0;
				OfflineMember = 0;
				IdleMember = 0;
				DoNotDisturbMember = 0;


				builder.append("]");


			}
		}, 0, (60*1000)*5);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

		return builder.toString();
	}


	public String Tickets(String TicketCategoryName){
		StringBuilder builder = new StringBuilder();

		List<TextChannel> textChannels = GetTickets.getTicket(TicketCategoryName);

		builder.append("{");
		for (TextChannel textChannel : textChannels) {
			builder.append("\"").append(textChannel.getName()).append("\":[");
			for (Message message : textChannel.getHistory().retrievePast(50).complete()) {
				builder.append("{")
						.append("\"id\": ").append(message.getId()).append(", ")
						.append("\"author\": \"").append(message.getAuthor()).append("\", ")
						.append("\"content\": \"").append(message.getContentRaw()).append("\"")
						.append("},");
			}
			builder.deleteCharAt(builder.length() - 1); // Remove trailing comma
			builder.append("],");
		}
		builder.deleteCharAt(builder.length() - 1); // Remove trailing comma
		builder.append("}");

		return builder.toString();
	}


}
