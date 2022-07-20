package com.poe.crmSpringboot.dao;

import com.poe.crmSpringboot.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Création d'une interface ClientRepository (sans annotation) qui étend JpaRepository
// Cette interface sera directement "injectable" sans aucune implémentation (@Autowired)
// Elle est sous la forme JpaRepository<ENTITE,TYPE CLE PRIMAIRE>
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> { }