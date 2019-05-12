package com.kaine.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomerController {

    @NotNull
    private final CustomerRepository customerRepository;

    @GetMapping("/customer")
    public Customer readCustomer(@RequestParam Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No customer with such ID"));
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestParam Integer id,
                                   @RequestBody Customer newCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new NoSuchElementException("No customer with such ID"));
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(@RequestParam Integer id) {
        customerRepository.deleteById(id);
    }
}
