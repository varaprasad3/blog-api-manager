
package com.subhu.blog_app_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.subhashree.repo.UserRepo;

@SpringBootTest
class BlogAppApiApplicationTests {

	@Autowired
	private UserRepo repo; // Ensure UserRepo is a Spring Data repository

	@Test
	void contextLoads() {
		// This test is fine, just loads the Spring context
	}

	@Test
	void repoTest() {
		if (repo != null) {
			String className = this.repo.getClass().getName();
			String packageName = this.repo.getClass().getPackageName();
			System.out.println("Class Name: " + className);
			System.out.println("Package Name: " + packageName);
		} else {
			System.out.println("Repository is not injected properly.");
		}
	}
}
