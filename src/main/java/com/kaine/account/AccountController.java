package com.kaine.account;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AccountController {

    @NotNull
    private final AccountRepository accountRepository;

    @GetMapping("/account")
    public Account readAccount(@RequestParam Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No account with such ID"));
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/account")
    public Account updateAccount(@RequestParam Integer id,
                                 @RequestBody Account newAccount) {
        return accountRepository.findById(id)
                .map(customer -> {
                    customer.setNumber(newAccount.getNumber());
                    customer.setAmount(newAccount.getAmount());
                    return accountRepository.save(customer);
                })
                .orElseThrow(() -> new NoSuchElementException("No account with such ID"));
    }

    @DeleteMapping("/account")
    public void deleteAccount(@RequestParam Integer id) {
        accountRepository.deleteById(id);
    }
}