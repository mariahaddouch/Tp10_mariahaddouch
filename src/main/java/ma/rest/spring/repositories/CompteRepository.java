package ma.rest.spring.repositories;

import ma.rest.spring.entities.Compte;
import ma.rest.spring.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;  // ✅ Ajouter cet import
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

    // Endpoint personnalisé : /comptes/search/byType?t=EPARGNE
    @RestResource(path = "byType", rel = "byType")
    List<Compte> findByType(@Param("t") TypeCompte type);
}
