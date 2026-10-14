package ex4;


import java.util.Scanner;
import ex4.*;

public class TestBibliotheque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Capacité de la bibliothèque (minimum 2) : ");
            n = sc.nextInt();
        } while (n < 2);

        sc.nextLine();

        Bibliotheque b = new Bibliotheque(n);

        b.ajouter(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 96));
        b.ajouter(new Revue("Science et Vie", "Octobre", 2026));

        int choix;

        do {
            System.out.println("\n===== MENU BIBLIOTHEQUE =====");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("1. Livre");
                    System.out.println("2. Revue");
                    System.out.println("3. Dictionnaire");
                    System.out.println("4. Roman");
                    System.out.println("5. Manuel");
                    System.out.print("Type de document : ");

                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;

                    switch (type) {
                        case 1:
                            System.out.print("Auteur : ");
                            String auteur = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pages = sc.nextInt();
                            sc.nextLine();
                            doc = new Livre(titre, auteur, pages);
                            break;

                        case 2:
                            System.out.print("Mois : ");
                            String mois = sc.nextLine();
                            System.out.print("Année : ");
                            int annee = sc.nextInt();
                            sc.nextLine();
                            doc = new Revue(titre, mois, annee);
                            break;

                        case 3:
                            System.out.print("Langue : ");
                            String langue = sc.nextLine();
                            doc = new Dictionnaire(titre, langue);
                            break;

                        case 4:
                            System.out.print("Auteur : ");
                            String auteurRoman = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pagesRoman = sc.nextInt();
                            System.out.print("Prix : ");
                            double prix = sc.nextDouble();
                            sc.nextLine();
                            doc = new Roman(titre, auteurRoman,
                                    pagesRoman, prix);
                            break;

                        case 5:
                            System.out.print("Auteur : ");
                            String auteurManuel = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pagesManuel = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();
                            doc = new Manuel(titre, auteurManuel,
                                    pagesManuel, niveau);
                            break;

                        default:
                            System.out.println("Type invalide.");
                    }

                    if (doc != null) {
                        if (b.ajouter(doc)) {
                            System.out.println("Document ajouté. Numéro : "
                                    + doc.getNumEnreg());
                        } else {
                            System.out.println("Bibliothèque pleine.");
                        }
                    }
                    break;

                case 2:
                    b.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numéro du document à supprimer : ");
                    int numSup = sc.nextInt();
                    sc.nextLine();

                    Document docSup = b.document(numSup);

                    if (docSup != null && b.supprimer(docSup)) {
                        System.out.println("Document supprimé.");
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 4:
                    System.out.print("Numéro du document à rechercher : ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    Document resultat = b.document(num);

                    if (resultat != null) {
                        System.out.println(resultat);
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 5:
                    b.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }
}
