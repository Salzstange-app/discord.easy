package net.sta.event.message.embedbuilder;

import net.dv8tion.jda.api.EmbedBuilder;

public class EmbedCreate {
	
    public String title;
    public String thumbnail;
    public String image;
    public String image2;
    public String description;
    public String footer;
	
	public EmbedCreate() {
	}
	

    public EmbedBuilder getBuildedEmbed(){
        EmbedBuilder builder = new EmbedBuilder();

        if(title != null)
            builder.setTitle(title);

        if(description != null)
            builder.setDescription(description);

        if(thumbnail != null)
            builder.setThumbnail(thumbnail);

        if(image != null)
            builder.setImage(image);

        if(footer != null)
            builder.setFooter(footer);


        return builder;
    }


}
