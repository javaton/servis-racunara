package servis.evidencija;

import java.util.ArrayList;
import java.util.List;

public class Servis {

	private List<EvidencijaRacunara> racunari; 
	
	public Servis() {
		this.racunari = new ArrayList<>(); 
	}
	
	public void dodajRacunarNaServis(EvidencijaRacunara racunarZaEvidenciju) {
		racunari.add(racunarZaEvidenciju);
	}
	
	public void preuzmiURad(String evidencioniBroj) {}
	
	public void zavrsiServis(String evidencioniBroj) {}
	
	public void racunariNaServisu() {
		for (EvidencijaRacunara evidencija : racunari) {
			evidencija.informacijeOEvidenciji();
		}
	}
}
