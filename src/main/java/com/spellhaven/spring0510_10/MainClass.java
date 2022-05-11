package com.spellhaven.spring0510_10;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	// 왜 프로젝트 이름이 0510_X인가? 0510_10이라고 하면 0510_2 바로 위로 정렬됐기 때문이다, 😩
	public static void main(String[] args) {
		
		// 사용자에게서 빨간 프로필 줄까 파란 프로필 줄까 입력받는 부분
		System.out.println("개발하려는 서버를 입력해 주세요(dev / run): ");
		Scanner scann = new Scanner(System.in);
		String str = scann.next();
		
		String config = null;
		
		if(str.equals("dev")) {
			config = "dev";
		} else {
			config = "run";
		}
		
		scann.close();
		
		
// 사용자 요구에 맞는 Bean 가져오는 부분. 지금은 .java를 쓰고 있으니까 .xml을 쓸 때와 다르디, ㅋ. xml 쓸 때의 구문은 주석 처리했으니 참고하디.
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		
//		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");		
		ctx.register(ApplicationConfig_dev.class, ApplicationConfig_run.class);
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("Server IP:" + info.getIpNum());
		System.out.println("Server Port:" + info.getPortNum());
		
		ctx.close();
	}
}













