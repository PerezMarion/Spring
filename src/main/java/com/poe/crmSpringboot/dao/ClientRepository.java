package com.poe.crmSpringboot.dao;

import com.poe.crmSpringboot.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Création d'une interface ClientRepository qui étend JpaRepository
// Cette interface sera directement "injectable" sans aucune implémentation (@Autowired)
// Elle est sous la forme JpaRepository<ENTITE,TYPE CLE PRIMAIRE>
// Elle nous permet de générer toutes sortes de méthodes vers la base de données sans que l'on ait à écrire
// La moindre requête ou implémentation Dao
// Méthodes disponibles (entre autres) : findAll(), findById(), save(), saveAll(), delete(), deleteAll(),
// deleteById(), count(), existsById()
// + utilisation de méthodes spécifiques ajoutées dans cette interface
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findAllClientsByCompanyName(String companyName);

    public List<Client> findAllClientsByFirstNameAndLastName(String firstName, String lastName);
}