package com.wipro.mockitotasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class Account {
    private String id;
    private double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() { return id; }
    public double getBalance() { return balance; }

    public void debit(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
    }
}

interface AccountRepository {
    Account findById(String id);
    void update(Account account);
}

interface NotificationService {
    void send(String accountId, String message);
}

class AccountService {
    private final AccountRepository accountRepository;
    private final NotificationService notificationService;

    public AccountService(AccountRepository accountRepository, NotificationService notificationService) {
        this.accountRepository = accountRepository;
        this.notificationService = notificationService;
    }

    public boolean transfer(String fromId, String toId, double amount) {
        Account from = accountRepository.findById(fromId);
        Account to = accountRepository.findById(toId);

        if (from == null || to == null) {
            return false;
        }

        if (from.getBalance() < amount) {
            return false;
        }

        from.debit(amount);
        to.credit(amount);

        accountRepository.update(from);
        accountRepository.update(to);

        notificationService.send(fromId, "Transferred " + amount + " to " + toId);
        return true;
    }
}

public class AccountServiceTest{

	@Mock
    private AccountRepository accountRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSuccessfulTransfer() {
        Account from = new Account("A1", 1000);
        Account to = new Account("A2", 500);

        when(accountRepository.findById("A1")).thenReturn(from);
        when(accountRepository.findById("A2")).thenReturn(to);

        boolean result = accountService.transfer("A1", "A2", 300);

        assertTrue(result);
        assertEquals(700, from.getBalance());
        assertEquals(800, to.getBalance());

        verify(accountRepository, times(2)).update(any(Account.class));
        verify(notificationService, times(1))
            .send("A1", "Transferred 300.0 to A2");
    }

    @Test
    void testTransferFailsDueToInsufficientBalance() {
        Account from = new Account("A1", 100);
        Account to = new Account("A2", 500);

        when(accountRepository.findById("A1")).thenReturn(from);
        when(accountRepository.findById("A2")).thenReturn(to);

        boolean result = accountService.transfer("A1", "A2", 300);

        assertFalse(result);
        assertEquals(100, from.getBalance());
        assertEquals(500, to.getBalance());

        verify(accountRepository, never()).update(any());
        verify(notificationService, never()).send(anyString(), anyString());
    }

    @Test
    void testTransferFailsIfAccountNotFound() {
        when(accountRepository.findById("A1")).thenReturn(null);
        when(accountRepository.findById("A2")).thenReturn(new Account("A2", 500));

        boolean result = accountService.transfer("A1", "A2", 200);

        assertFalse(result);

        verify(accountRepository, never()).update(any());
        verify(notificationService, never()).send(anyString(), anyString());
    }
}
