package com.smart.web;



import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.slf4j.impl.StaticLoggerBinder;
//import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class BdsDaemo {
	@RequestMapping("/")
	public String index() {
		return "huanying";
	}

	public static void main(String[] args)throws Exception {
//		URL urlOfClass = StaticLoggerBinder.class.getClassLoader().getResource("org/slf4j/spi/StaticLoggerBinder.class");//InsertProgarm锟角革拷锟斤拷锟斤拷锟斤拷诘锟斤拷锟�
//        System.out.println(urlOfClass);
//		ProtectionDomain pd = StaticLoggerBinder.class.getProtectionDomain();  
//        CodeSource cs = pd.getCodeSource();  
//        System.out.println(cs.getLocation());
		
		SpringApplication.run(BdsDaemo.class, args);

	}

}
