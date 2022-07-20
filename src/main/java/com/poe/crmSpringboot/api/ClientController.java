package com.poe.crmSpringboot.api;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.service.ServicesClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

// @RestController : controller équivalent Api d'où packages api
// Couche de code permettant le dialogue entre le code métier et l'utilisateur via requête http
@RestController
// @RequestMapping : indication du chemin à prendre dans la fin de l'url (uri) de la requête http
@RequestMapping("api")
public class ClientController {

    // @Autowired : injection de Service dans cette classe (récupération automatique du bean)
    // On a plus besoin de déclarer la variable Service ici (Service service = new Service();)
    // car Spring la recherche directement dans le bean correspondant, ce qui nous permet d'utiliser
    // les méthodes du bean injecté
    @Autowired
    ServicesClientOrder service;

    // @GetMapping : traitement d'une requête http GET et mapping de cette requête
    // Equivalent à une annotation @GET + une annotation @RequestMapping
    @GetMapping("clients")
    public List<Client> getAll() {

        return service.getAllClients();
    }

    @GetMapping("clients/{id}")
    // @PathVariable : liaison entre le paramètre "id" de la méthode et l'uri de la requête http
    public ResponseEntity<Client> findbyId(@PathVariable("id") Long id) {

        Optional<Client> oc = service.findClientById(id);
        if(oc.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(oc.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Traitement d'une requête http POST et mapping de cette requête
    // Equivalent à une annotation @POST + une annotation @RequestMapping
    @PostMapping("clients")
    // @RequestBody : liaison entre l'objet "client" et le corps d'une requête http
    public void add(@RequestBody Client client) {
        service.addClient(client);
    }

    // Traitement d'une requête http DELETE et mapping de cette requête
    // Equivalent à une annotation @DELETE + une annotation @RequestMapping
    @DeleteMapping("clients/{id}")
    public ResponseEntity<Client> delete(@PathVariable("id") Long id) {

        boolean hasDeleted = service.deleteClient(id);
        if(hasDeleted == true) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}