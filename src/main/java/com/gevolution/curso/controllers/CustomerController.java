package com.gevolution.curso.controllers;
import com.gevolution.curso.domain.Customer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class CustomerController {
    
    // Lista para ontener los clientes

    private List<Customer> customers = new ArrayList<>(
        Arrays.asList(
            new Customer(1, "Juan", "juan123", "juan@mail.com", "123"),
            new Customer(2, "Ana", "ana123", "ana@mail.com", "123"),
            new Customer(3, "Luis", "luis123", "luis@mail.com", "123"),
            new Customer(4, "Maria", "maria123", "maria@mail.com", "123")
        )
    );

    @GetMapping("/clientes")  
    public List<Customer> getCustomers(){
        return customers;
    }

    @GetMapping("/cliente/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c : customers){
            if(c.getUsername().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null;
    }

}
