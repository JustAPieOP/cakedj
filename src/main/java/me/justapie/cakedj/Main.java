package me.justapie.cakedj;

import com.sedmelluq.discord.lavaplayer.jdaudp.NativeAudioSendFactory;
import me.justapie.cakedj.database.DBConnector;
import me.justapie.cakedj.database.collections.ConfigCollection;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        new DBConnector().initCollection();

        DefaultShardManagerBuilder
                .createDefault(ConfigCollection.getConfig().token())
                .enableIntents(GatewayIntent.GUILD_VOICE_STATES)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new Listener())
                .setAutoReconnect(true)
                .setAudioSendFactory(new NativeAudioSendFactory())
                .build();
    }
}
