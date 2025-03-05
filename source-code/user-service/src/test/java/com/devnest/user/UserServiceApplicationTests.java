package com.devnest.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories("my.package.base.*")
@ComponentScan(basePackages = { "my.package.base.*" })
@EntityScan("my.package.base.*")
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
