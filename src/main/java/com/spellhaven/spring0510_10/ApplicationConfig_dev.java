package com.spellhaven.spring0510_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig_dev {

	@Bean
	public ServerInfo serverInfo() {
	
		ServerInfo server = new ServerInfo();
		
		server.setIpNum("localhost");
		server.setPortNum("8888");
		
		return server;
	}
	
}
