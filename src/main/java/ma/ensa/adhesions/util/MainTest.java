package ma.ensa.adhesions.util;

import ma.ensa.adhesions.model.Club;
import ma.ensa.adhesions.model.DemandeAdhesion;
import ma.ensa.adhesions.model.Role;
import ma.ensa.adhesions.model.StatutDemande;
import ma.ensa.adhesions.model.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

public class MainTest {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            Long nbUtilisateurs = session
                    .createQuery("select count(u) from Utilisateur u", Long.class)
                    .uniqueResult();

            if (nbUtilisateurs != null && nbUtilisateurs > 0) {
                System.out.println("Les données existent déjà : rien à insérer.");
                return;
            }

            tx = session.beginTransaction();

            Utilisateur mohamed = new Utilisateur(
                    "Alaoui", "Mohamed", "m.alaoui@etu.ma",
                    "etu123", Role.ETUDIANT, true
            );

            Utilisateur karim = new Utilisateur(
                    "Benali", "Karim", "k.benali@etu.ma",
                    "etu123", Role.ETUDIANT, true
            );

            Utilisateur sara = new Utilisateur(
                    "Idrissi", "Sara", "s.idrissi@etu.ma",
                    "resp123", Role.RESPONSABLE_CLUB, true
            );

            session.persist(mohamed);
            session.persist(karim);
            session.persist(sara);

            Club robotique = new Club(
                    "Club de robotique",
                    "Projets Arduino et compétitions",
                    "Technologie",
                    sara
            );

            Club theatre = new Club(
                    "Club de théâtre",
                    "Ateliers et représentations",
                    "Culture",
                    sara
            );

            session.persist(robotique);
            session.persist(theatre);

            session.persist(new DemandeAdhesion(
                    Date.valueOf("2026-10-10"),
                    Date.valueOf("2026-10-12"),
                    StatutDemande.ACCEPTEE,
                    mohamed,
                    robotique
            ));

            session.persist(new DemandeAdhesion(
                    Date.valueOf("2026-11-02"),
                    null,
                    StatutDemande.EN_ATTENTE,
                    mohamed,
                    theatre
            ));

            session.persist(new DemandeAdhesion(
                    Date.valueOf("2026-10-15"),
                    Date.valueOf("2026-10-18"),
                    StatutDemande.REFUSEE,
                    karim,
                    robotique
            ));

            session.persist(new DemandeAdhesion(
                    Date.valueOf("2026-11-03"),
                    null,
                    StatutDemande.EN_ATTENTE,
                    karim,
                    robotique
            ));

            tx.commit();

            System.out.println(
                    "Données insérées : 3 utilisateurs, 2 clubs et 4 demandes."
            );

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}