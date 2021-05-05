package com.example.demo;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class SpringBootSslApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslApplication.class, args);

		/*
		// set server.ssl properties program
		Properties properties = new Properties();
		properties.put("server.ssl.key-alias", "1");
		properties.put("server.ssl.key-password", "changeit");
		properties.put("server.ssl.key-store", "classpath:self-signed-cert.p12");
		properties.put("server.ssl.key-store-password", "changeit");
		properties.put("server.ssl.key-store-type", "PKCS12");
		new SpringApplicationBuilder(SpringBootSslApplication.class).properties(properties).run(args);
		*/
	}

	/*
	/*
	// redirect all traffic from port 8080(HTTP) to 8443(HTTPS).
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(redirectConnector());
		return tomcat;
	}

	private Connector redirectConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}*/


}
