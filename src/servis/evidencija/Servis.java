package servis.evidencija;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import racunar.LapTop;

public class Servis {

	private List<EvidencijaRacunara> racunari; 
	
	public Servis() {
		this.racunari = new ArrayList<>(); 
	}
	
	public void dodajRacunarNaServis(EvidencijaRacunara racunarZaEvidenciju) throws IOException {
		racunari.add(racunarZaEvidenciju);
		BufferedWriter writer = 
				new BufferedWriter(new FileWriter("c:/servis/"+
								racunarZaEvidenciju.getEvidencioniBroj()+".txt"));
		writer.write(racunarZaEvidenciju.toString());
		writer.close();
	}
	
	public void preuzmiURad(String evidencioniBroj) {
		for (EvidencijaRacunara evidencija : racunari) {
			if(evidencija.getEvidencioniBroj().equals(evidencioniBroj)){
				evidencija.setStatusServisa(Status.U_RADU);
			}
		}
	}
	
	public void zavrsiServis(String evidencioniBroj, Naplata naplata) {
		for (EvidencijaRacunara evidencija : racunari) {
			if(evidencija.getEvidencioniBroj().equals(evidencioniBroj)){
				evidencija.setStatusServisa(Status.ZAVRSEN_SERVIS);
				evidencija.setNaplata(naplata);
				evidencija.setDatumZavrsetkaServisa(LocalDate.now());
			}
		}
	}
	
	public void otpremiRacunar(String evidencioniBroj, Boolean naplaceno) {
		for (EvidencijaRacunara evidencija : racunari) {
			if(evidencija.getEvidencioniBroj().equals(evidencioniBroj)){
				evidencija.setStatusServisa(Status.ROBA_PREUZETA);
				evidencija.getNaplata().setNaplaceno(naplaceno);
			}
		}
	}
	
	public void racunariNaServisu() throws IOException {
		BufferedWriter pisac = new BufferedWriter(new FileWriter("c:/servis/RacunariNaServisu.txt"));
		for (EvidencijaRacunara evidencija : racunari) {
			evidencija.informacijeOEvidenciji();
			pisac.write(evidencija.toString());
			pisac.newLine();
		}
		pisac.close();
	}
	
	public void lapTopRacunariNaServisu() {
		for (EvidencijaRacunara evidencija : racunari) {
			if(evidencija.getRacunar() instanceof LapTop) {
				evidencija.informacijeOEvidenciji();
			}
		}
	}
}
