package webserver;

import java.util.Collection;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
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
}
