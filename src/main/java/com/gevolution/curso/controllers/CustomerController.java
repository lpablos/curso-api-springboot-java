package com.gevolution.curso.controllers;
import com.gevolution.curso.domain.Customer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
// Implementacion a nivel de clase para unificar las rutas
@RequestMapping("/api/clientes")
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

    // @GetMapping("/clientes")  
    // RequestMapping nos da la unificacion de rutas
    // @GetMapping
    // Implementando el metodo GET con RequestMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customers;
    }

    // @GetMapping("/clientes/{username}")
    // RequestMapping nos da la unificacion de rutas y solo se deja el parametro que se pasa
    // @GetMapping("/{username}")   
    // Implementando el metodo GET con RequestMapping 
    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c : customers){
            if(c.getUsername().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null;
    }

    // @PostMapping("/clientes")
    // RequestMapping nos da la unificacion de rutas
    // @PostMapping
    // Implementando el metodo POST con RequestMapping
    @RequestMapping(method = RequestMethod.POST)
    public Customer setCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    // Actualizacion de un objecto completo de cliente
    // @PutMapping("/clientes")
    // RequestMapping nos da la unificacion de rutas
    // @PutMapping
    // IMplementando el metodo PUT con RequestMapping
    @RequestMapping(method = RequestMethod.PUT)
    public Customer putCliente(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setEmail(customer.getEmail());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;
    }

    // @DeleteMapping("/clientes/{id}")
    // RequestMapping nos da la unificacion de rutas y solo se le deja el parametro que se pasa
    // @DeleteMapping("/{id}")
    // Implementando el metodo DELETE con RequestMapping
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public Customer deleteCliente(@PathVariable int id){
        for(Customer c : customers){
            if(c.getId() == id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    // @PatchMapping("/clientes")
    // RequestMapping nos da la unificacion de rutas
    // @PatchMapping
    // Implementando el metodo PATCH con RequestMapping
    @RequestMapping(method = RequestMethod.PATCH)
    public Customer patchCliente(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getId() == customer.getId()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getEmail() != null){
                    c.setEmail(customer.getEmail());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }

}
