package ma.ensa.adhesions.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nom;

    @Column(nullable = false, length = 80)
    private String prenom;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "mot_de_passe", nullable = false, length = 255)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role role;

    @Column(nullable = false)
    private boolean actif;

    @OneToMany(mappedBy = "responsable")
    private List<Club> clubsGeres = new ArrayList<>();

    @OneToMany(mappedBy = "etudiant")
    private List<DemandeAdhesion> demandes = new ArrayList<>();

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email,
                       String motDePasse, Role role, boolean actif) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.actif = actif;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public List<Club> getClubsGeres() {
        return clubsGeres;
    }

    public void setClubsGeres(List<Club> clubsGeres) {
        this.clubsGeres = clubsGeres;
    }

    public List<DemandeAdhesion> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<DemandeAdhesion> demandes) {
        this.demandes = demandes;
    }
}