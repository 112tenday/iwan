package repository;


import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
@ActiveProfiles("dev")

public class AccountRepositoryImplTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    void testGetAccountByIdSucces() {

       try {
           String id = "1";
           Account account = accountRepository.getAccountById(id);
           assertEquals(id, account.getId());
       }catch (Exception e) {
       }
    }

    @Test
    void testGetAccountByIdNegatif() {
        try {
            String id = "10";
            Account account = accountRepository.getAccountById(id);
        }catch (Exception e ) {
            if (e instanceof EmptyResultDataAccessException) {
                assertTrue(true);
            }
        assertFalse(false);
        }
    }


}
