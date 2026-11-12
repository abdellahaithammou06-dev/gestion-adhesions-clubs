package ma.ensa.adhesions.model;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "demande_adhesion")
public class DemandeAdhesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Temporal(TemporalType.DATE)
    @Column(name = "date_demande", nullable = false)
    private Date dateDemande;


    @Temporal(TemporalType.DATE)
    @Column(name = "date_decision")
    private Date dateDecision;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutDemande statut;


    @ManyToOne(optional = false)
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Utilisateur etudiant;


    @ManyToOne(optional = false)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;


    public DemandeAdhesion() {
    }

    public DemandeAdhesion(Date dateDemande, Date dateDecision,
                           StatutDemande statut, Utilisateur etudiant, Club club) {
        this.dateDemande = dateDemande;
        this.dateDecision = dateDecision;
        this.statut = statut;
        this.etudiant = etudiant;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Date getDateDecision() {
        return dateDecision;
    }

    public void setDateDecision(Date dateDecision) {
        this.dateDecision = dateDecision;
    }

    public StatutDemande getStatut() {
        return statut;
    }

    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }

    public Utilisateur getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Utilisateur etudiant) {
        this.etudiant = etudiant;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}