package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;

@SpringBootTest
@ActiveProfiles("test")
public class WalletItensRepositoryTest {
	
	private static final Date DATE = new Date();
	private static final String TYPE = "EN";
	private static final String DESCRIPTION = "Conta de luz";
	private static final BigDecimal VALUE = BigDecimal.valueOf(65);
	
	@Autowired
	WalletItemRepository repository;
	
	@Autowired
	WalletRepository walletRepository;
	
	@Test
	void testSave() {
		Wallet w = new Wallet();
		w.setName("Carteira 3");
		w.setValue(BigDecimal.valueOf(500));
		walletRepository.save(w);
		WalletItem wi = new WalletItem(1L,w, DATE, TYPE, DESCRIPTION, VALUE);
		
		WalletItem response = repository.save(wi);
		
		assertNotNull(response);
		assertEquals(response.getDescription(),DESCRIPTION);
		assertEquals(response.getType(),TYPE);
		assertEquals(response.getValue(),VALUE);
		assertEquals(response.getWallet().getId(),w.getId());
		
	}

}
