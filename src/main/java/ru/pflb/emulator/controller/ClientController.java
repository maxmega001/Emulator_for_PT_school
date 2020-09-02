package ru.pflb.emulator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getclient/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long id) {
        ClientDto client = clientService.getUserById(id);
        return ResponseEntity.ok(client);
    }


    //    public ResponseEntity addClient(
//            @RequestBody ClientDto client) {
//        return ResponseEntity.ok(client).status(201).build();
//    }
    @PostMapping("/client/1")
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto client) {
        //ClientDto client = clientService.getUserById(id);
//        System.out.println(body);
//        return null;//ResponseEntity.ok(client);
        return ResponseEntity.ok(client).status(201).build();
    }

}