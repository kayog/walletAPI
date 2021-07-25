package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entity.User;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	private static final String EMAIL = "teste@teste.com";

	@Autowired
	UserRepository repository;

	@BeforeAll
	public void setUp() {
		User u = new User();
		u.setName("Set up user");
		u.setPassword("teste123");
		u.setEmail(EMAIL);

		repository.save(u);

	}

	@AfterAll
	public void tearDown() {

		repository.deleteAll();

	}
	@Test
	private void testSave() {
		User u = new User();
		u.setName("Teste");
		u.setPassword("12345");
		u.setEmail("teste@teste.com");

		User response = repository.save(u);

		assertNotNull(response);

	}

	@Test
	private void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);

		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
}
