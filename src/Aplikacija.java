import java.time.LocalDate;
import java.util.Scanner;

import racunar.LapTop;
import racunar.Racunar;
import servis.evidencija.EvidencijaRacunara;
import servis.evidencija.Servis;

public class Aplikacija {

	public static void main(String[] args) {
		//priprema podataka
		Servis servisSasa = new Servis();
		
		Racunar djoletovRacunar = new LapTop("87897987", 2.5D, "Toshiba", 15.6);
		EvidencijaRacunara djoletovaEvidencija = new EvidencijaRacunara("1A", "Djordje", djoletovRacunar);
		
		servisSasa.dodajRacunarNaServis(djoletovaEvidencija);
		
		Racunar tanjinRacunar = new LapTop("878979", 2.4D, "dell", 15.6);
		EvidencijaRacunara tanjinaEvidencija = new EvidencijaRacunara("3A", "Tanja", tanjinRacunar);
		
		servisSasa.dodajRacunarNaServis(tanjinaEvidencija);

		Scanner ulaz = new Scanner(System.in);

		while(true) {
		System.out.println("Komande za rad sa servisom: ");
		System.out.println("   0 - izlazak iz aplikacije");
		System.out.println("   1 - pregled racunara na servisu");
		System.out.println("   2 - unos nove evidencije");

		int ulaznaKomanda = ulaz.nextInt();
		if(ulaznaKomanda == 0) {
			System.out.println("*** Izlaz iz aplikacije. ***");
			break;
		}
		if(ulaznaKomanda == 1) {
			servisSasa.racunariNaServisu();
		}
		if(ulaznaKomanda == 2) {
			System.out.println("Unesite vlasnika racunara: ");
			String vlasnik = ulaz.next();
			System.out.println("Unesite evidencioni broj: ");
			String evidencioniBroj = ulaz.next();
			System.out.println("Unesite serijski broj racunara: ");
			String serijskiBrojRacunara = ulaz.next();
			System.out.println("Unesite marku racunara: ");
			String marku = ulaz.next();
			System.out.println("Unesite brzinu procesora: ");
			Double brzina = ulaz.nextDouble();
			System.out.println("Unesite dijagonalu ekrana: ");
			Double dijagonala = ulaz.nextDouble();
			Racunar r = new LapTop(serijskiBrojRacunara, brzina, marku, dijagonala);
			EvidencijaRacunara evidncija = new EvidencijaRacunara(evidencioniBroj, vlasnik, r);
			servisSasa.dodajRacunarNaServis(evidncija);
			System.out.println("*** Uspesno ste dodali racunar u servis. ***");
			System.out.println("");
		}
		}
	}

}
