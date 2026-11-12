package ma.ensa.adhesions.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nom;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false, length = 80)
    private String categorie;

    // Responsable du club : clé étrangère responsable_id vers utilisateur.
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Utilisateur responsable;

    // Demandes reçues par ce club.
    @OneToMany(mappedBy = "club")
    private List<DemandeAdhesion> demandes = new ArrayList<>();

    // Constructeur vide obligatoire pour Hibernate.
    public Club() {
    }

    public Club(String nom, String description, String categorie,
                Utilisateur responsable) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.responsable = responsable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Utilisateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }

    public List<DemandeAdhesion> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<DemandeAdhesion> demandes) {
        this.demandes = demandes;
    }
}