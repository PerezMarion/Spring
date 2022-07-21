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
    // On a plus besoin de déclarer la variable Service ici de la manière "Service service = new Service();"
    // c'est à dire qu'on a plus besoin de faire une implémentation car Spring la recherche directement
    // dans le bean correspondant, ce qui nous permet d'utiliser les méthodes du bean injecté
    @Autowired
    ServicesClientOrder service;

    // @GetMapping : traitement d'une requête http GET et mapping de cette requête
    // Equivalent à une annotation @GET + une annotation @RequestMapping
    @GetMapping("clients")
    public List<Client> getAllClients() {

        return service.getAllClients();
    }

    @GetMapping("clients/{id}")
    // @PathVariable : liaison entre le paramètre "id" de la méthode et l'uri de la requête http
    public ResponseEntity<Client> findClientById(@PathVariable("id") Long id) {

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
    public void addClient(@RequestBody Client client) {
        service.addClient(client);
    }

    // Traitement d'une requête http DELETE et mapping de cette requête
    // Equivalent à une annotation @DELETE + une annotation @RequestMapping
    @DeleteMapping("clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {

        if(service.deleteClient(id) == true) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("L'identifiant ne correspond à aucun client");
        }
    }

    // Traitement d'une requête http PUT et mapping de cette requête
    // Equivalent à une annotation @PUT + une annotation @RequestMapping
    @PutMapping("clients/{id}")
    public ResponseEntity<String> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {

        if(!id.equals(client.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("L'identifiant dans l'url ne correspond pas à l'identifiant dans le body");
        } else {
            if(service.updateClient(client) == true) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body("L'identifiant ne correspond à aucun client");
            }
        }
    }

    @GetMapping("searchbycn")
    // @RequestParam : liaison entre le paramètre "companyname" correspondante a "companyName" de la méthode et
    // l'uri de la requête http qui sera sous la forme http://localhost:8080/api/searchbycn?companyname=...
    public List<Client> findAllClientsByCompanyName
            (@RequestParam(value="companyname") String companyName) {

        System.out.println("Compagnie : " + companyName);
        return service.findAllClientsByCompanyName(companyName);
    }

    @GetMapping("searchbyfnln")
    // uri de la requête http sous la forme http://localhost:8080/api/searchbyfnln?firstname=...&lastname=...
    public List<Client> findAllClientsByFirstNameAndLastName
            (@RequestParam(value="firstname") String firstName,
             @RequestParam(value="lastname") String lastName) {

        System.out.println("Identite : " + firstName + " " + lastName);
        return service.findAllClientsByFirstNameAndLastName(firstName, lastName);
    }


}