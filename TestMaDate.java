import java.util.Scanner;
public class TestMaDate {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        MaDate date1 = new MaDate(2024);
        System.out.println("date1: " + date1.toString());


        MaDate date2 = new MaDate(5, 10, 2024);
        System.out.println("date2: " + date2.toString());
		
		MaDate date3 = new MaDate(15, 5, 2022);
		System.out.println("date3: " + date3.toString());

        date3.setJour(20);
        date3.setMois(12);
        date3.setAnnee(2025);
        System.out.println("aprés setters date3:" + date3.toString());
		
		date1.ajouterUnJour();
        System.out.println("Après ajouterUnJour: " + date1);
		
		boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu :");
            System.out.println("1. Ajouter un jour");
            System.out.println("2. Ajouter plusieurs jours");
            System.out.println("3. Ajouter un mois");
            System.out.println("4. Ajouter une année");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
			if (choix == 5) {
                exit = true;
                System.out.println("Au revoir !");
            } else {
			System.out.print("Choisissez la date à modifier (1, 2 ou 3) : ");
            int dateChoix = scanner.nextInt();
            MaDate dateChoisie = null;

            switch (dateChoix) {
                case 1:
                    dateChoisie = date1;
                    break;
                case 2:
                    dateChoisie = date2;
                    break;
                case 3:
                    dateChoisie = date3;
                    break;
                default:
                    System.out.println("Choix invalide !");
                    continue;
            }
			switch (choix) {
					case 1:
						dateChoisie.ajouterUnJour();
						System.out.println("Nouvelle date : " + dateChoisie);
						break;
					case 2:
						System.out.print("Combien de jours à ajouter ? ");
						int nbJours = scanner.nextInt();
						dateChoisie.ajouterPlusieursJours(nbJours);
						System.out.println("Nouvelle date : " + dateChoisie);
						break;
					case 3:
						dateChoisie.ajouterUnMois();
						System.out.println("Nouvelle date : " + dateChoisie);
						break;
					case 4:
						dateChoisie.ajouterUnAn();
						System.out.println("Nouvelle date : " + dateChoisie);
						break;
					case 5:
						exit = true;
						System.out.println("Au revoir !");
						break;
					default:
						System.out.println("Choix invalide !");
						break;
			}
		}
	}
	scanner.close();
	}
}