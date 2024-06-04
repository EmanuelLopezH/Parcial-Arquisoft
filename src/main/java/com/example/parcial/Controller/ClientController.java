package com.example.parcial.Controller;

import com.example.parcial.Service.ClientService;
import com.example.parcial.Model.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@CrossOrigin
@Tag(name = "Clientes")
@Api(value = "Sistema de gestion de cliente", description = "Operaciones para los clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Ver lista de clientes")
    @GetMapping(value = "/clients", produces = "application/vnd.api+json;version=v1")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @ApiOperation(value = "Buscar Cliente")
    @GetMapping(value = "/{clientId}", produces = "application/vnd.api+json;version=v1")
    public Optional<Client> searchClient(@PathVariable Long clientId) {
        return clientService.getClientById(clientId);
    }

    @ApiOperation(value = "Guardar Cliente")
    @PostMapping(value = "client", consumes = "application/vnd.api+json;version=v1")
    public void saveClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    @ApiOperation(value = "Eliminar Cliente")
    @DeleteMapping(value = "/{clientId}", consumes = "application/vnd.api+json;version=v1")
    public void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClientById(clientId);
    }
}
