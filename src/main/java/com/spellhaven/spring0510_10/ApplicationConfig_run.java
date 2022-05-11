package com.spellhaven.spring0510_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfig_run {

	@Bean
	public ServerInfo serverInfo() {
	
		ServerInfo server = new ServerInfo();
		
		server.setIpNum("대충 가상의 아이피 지어냈다고 생각하셈");
		server.setPortNum("3737");
		
		return server;
	}
	
}
