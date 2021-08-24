package com.bruno.ordering;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class OrderingSystemApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() -> OrderingSystemApplication.main(new String[]{}));
	}

}
