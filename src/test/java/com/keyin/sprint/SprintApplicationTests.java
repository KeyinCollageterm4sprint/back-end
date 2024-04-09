package com.keyin.sprint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SprintApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// Basic test to check if the application context loads successfully
	}

	@Test
	void applicationContextTest() {
		// Further tests to verify if beans are correctly loaded in the context
		assertNotNull(applicationContext, "The application context should not be null");

		// Example of checking a specific bean in the application context
		// Make sure to replace `YourSpecificBean.class` with an actual bean class from your application
		// assertNotNull(applicationContext.getBean(YourSpecificBean.class), "YourSpecificBean should be loaded in the application context");
	}
}
