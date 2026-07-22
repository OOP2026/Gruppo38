package controller;

import exceptions.CampoVuotoException;
import exceptions.CreaException;
import exceptions.MissingStudentException;
import exceptions.MissingTeacherException;
import model.*;

import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
	ArrayList<Studente> studenti = new ArrayList<>();
	ArrayList<Docente> docenti = new ArrayList<>();
	ArrayList<Aula> aule = new ArrayList<>();

	private String[][] orarioGenerale = null;

	public void registrazioneDocente (String login, String password, String nome, String cognome, String email, String isResponsabile) throws LoginException, AuthenticationException, CampoVuotoException {

		if(login.isBlank() || nome.isBlank() || cognome.isBlank() || email.isBlank() || password.isBlank() || isResponsabile.isBlank()) {
			throw new CampoVuotoException("Bisogna riempire tutti i campi");
		}

		for (Utente utente : docenti) {
			if (utente.getLogin().equals(login)) {
				throw new LoginException("Utente già esistente");
			}
		}

		if(password.equals(login) || password.length() < 8){
			throw new AuthenticationException("Password corta");
		}

		boolean boolIsResponsabile = isResponsabile.equals("SI");

        docenti.add(new Docente(login, password, nome, cognome, email, boolIsResponsabile));
	}


	public void registrazioneStudente (String login, String password, String nome, String cognome, String email, String matricola, String annoCorsoStr) throws LoginException, AuthenticationException, CampoVuotoException {

		if(login.isBlank() || nome.isBlank() || cognome.isBlank() || email.isBlank() || matricola.isBlank() || annoCorsoStr.isBlank() || password.isBlank()) {
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}

		AnnoAccademico annoCorso = AnnoAccademico.valueOf(annoCorsoStr);

		for (Utente utente : studenti) {
			if (utente.getLogin().equals(login)) {
				throw new LoginException("Utente già esistente");
			}
		}

		if(password.equals(login) || password.length() < 8){
			throw new AuthenticationException("Password corta");
		}

		studenti.add(new Studente(login, password, nome, cognome, email, matricola, annoCorso));

	}

	public boolean loginStudente (String login, String password) throws LoginException, CampoVuotoException, MissingStudentException{
		if(login.isBlank() || password.isBlank()){
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}

		int i = 0;
		int lenS = studenti.size();
		boolean studenteTrovato = false;
		while(!studenteTrovato && i < lenS){
			if(studenti.get(i).getLogin().equals(login)){
				studenteTrovato = true;
				continue;
			}
			i++;
		}
		if (!studenteTrovato)
			throw new MissingStudentException("lo studente " + login + " non esiste.");
		if(studenti.get(i).getPassword().equals(password))
			return true;
		throw new LoginException("Password non corretta");
	}

	public boolean loginDocente (String login, String password) throws LoginException, CampoVuotoException, MissingTeacherException {
		if(login.isBlank() || password.isBlank()){
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}

		int i = 0;
		int lenD = docenti.size();
		boolean docenteTrovato = false;
		while(!docenteTrovato && i < lenD){
			if(docenti.get(i).getLogin().equals(login)){
				docenteTrovato = true;
				continue;
			}
			i++;
		}
		if (!docenteTrovato)
			throw new MissingTeacherException("lo docente " + login + " non esiste.");
		if(docenti.get(i).getPassword().equals(password))
			return true;
		throw new LoginException("Password non corretta");
	}

	public List<String> getAttributiStudente(String login) throws MissingStudentException {
		boolean studenteTrovato = false;
		int i = 0;
		while(!studenteTrovato && i < studenti.size()){
			if(studenti.get(i).getLogin().equals(login)){
				studenteTrovato = true;
			}
			i++;
		}
		if (studenteTrovato) {
			ArrayList<String> attributiStudente = new ArrayList<>();
			attributiStudente.add(studenti.get(i-1).getNome());
			attributiStudente.add(studenti.get(i-1).getCognome());
			attributiStudente.add(studenti.get(i-1).getMatricola());
			attributiStudente.add(studenti.get(i-1).getEmail());
			attributiStudente.add(studenti.get(i-1).getAnnoCorso().name());
			return attributiStudente;
		}
		throw new MissingStudentException("Lo studente " + login + " non esiste.");
	}

	public List<String> getAttributiDocente(String login) throws MissingTeacherException {
		boolean docenteTrovato = false;
		int i = 0;
		while(!docenteTrovato && i < docenti.size()){
			if(docenti.get(i).getLogin().equals(login)){
				docenteTrovato = true;
			}
			i++;
		}
		if (docenteTrovato) {
			ArrayList<String> attributiDocente = new ArrayList<>();
			attributiDocente.add(docenti.get(i-1).getNome());
			attributiDocente.add(docenti.get(i-1).getCognome());
			attributiDocente.add(docenti.get(i-1).getEmail());
			attributiDocente.add(docenti.get(i-1).isResponsabile().toString());
			return attributiDocente;
		}
		throw new MissingTeacherException("Il docente " + login + " non esiste.");
	}

	public List<String> getInsegnamenti (String login) throws MissingTeacherException {
		for(Docente docente : docenti){
			if(docente.getLogin().equals(login)){
				ArrayList<String> insegnamenti = new ArrayList<>();
				for(Insegnamento ins : docente.getMaterie()){
					insegnamenti.add(ins.getNome() + " - " + ins.getCfu() + " CFU- " + ins.getAnno().name() + " ANNO");
				}
				return insegnamenti;
			}
		}
		throw new MissingTeacherException("Il docente " + login + " non esiste.");
	}
	public void addInsegnamento (String login, String nome, String cfuStr, String annoCorsoStr) throws CampoVuotoException, NumberFormatException, MissingTeacherException {
		for(Docente docente : docenti){
			if(docente.getLogin().equals(login)){
				docente.aggiungiInsegnamento(nome, cfuStr, annoCorsoStr);
				return;
			}
		}
		throw new MissingTeacherException("Il docente " + login + " non esiste.");
	}

	public void removeInsegnamento (String login, int selectedIndex) throws MissingTeacherException {
		for (Docente docente : docenti) {
			if (docente.getLogin().equals(login)) {
				docente.removeInsegnamento(selectedIndex);
				return;
			}
		}
	}

	public List<String> getDatiInsegnamento (String login, int selectedIndex) throws MissingTeacherException {
		List<String> datiInsegnamento = new ArrayList<>();
		for (Docente docente : docenti) {
			if (docente.getLogin().equals(login)) {
				datiInsegnamento.add(docente.getMaterie().get(selectedIndex).getNome());
				datiInsegnamento.add(String.valueOf(docente.getMaterie().get(selectedIndex).getCfu()));
				datiInsegnamento.add(String.valueOf(docente.getMaterie().get(selectedIndex).getAnno()));
				return datiInsegnamento;
			}
		}
		return Collections.emptyList();
	}

	public void modificaInsegnamento (String login, int selectedIndex, String nome, String cfuStr, String annoCorsoStr) throws MissingTeacherException {
		for (Docente docente : docenti) {
			if (docente.getLogin().equals(login)) {
				docente.getMaterie().get(selectedIndex).setNome(nome);
				docente.getMaterie().get(selectedIndex).setCfu(Integer.parseInt(cfuStr));
				docente.getMaterie().get(selectedIndex).setAnno(AnnoAccademico.valueOf(annoCorsoStr));
			}
		}
	}

	public List<String> getTuttiInsegnamentiConDocente() {
		List<String> insegnamenti = new ArrayList<>();
		for (Docente docente : docenti) {
			if (docente.getMaterie() != null) {
				for (Insegnamento ins : docente.getMaterie()) {
					insegnamenti.add(ins.getNome() + " (" + docente.getNome() + " " + docente.getCognome() + ")");
				}
			}
		}
		return insegnamenti;
	}

	public void salvaOrarioGenerale(String[][] nuovoOrario) {
		this.orarioGenerale = nuovoOrario;
	}

	public String[][] getOrarioGenerale() {
		return this.orarioGenerale;
	}

	public void aggiungiAula(String nome, String capienzaStr) throws CampoVuotoException, CreaException {
		if (nome.isBlank() || capienzaStr.isBlank()) {
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}

		for (Aula aula : aule) {
			if (aula.getNome().trim().equalsIgnoreCase(nome.trim())) {
				throw new CreaException("L'aula '" + nome + "' è già nel sistema!");
			}
		}

		int capienza = Integer.parseInt(capienzaStr.trim());

		aule.add(new Aula(nome, capienza));
	}

	public void removeAula(int selectedIndex) {
		aule.remove(selectedIndex);
	}

	public String[] getDatiAule(int selectedIndex) {
		String[] datiAula = new String[2];
		datiAula[0] = aule.get(selectedIndex).getNome();
		datiAula[1] = String.valueOf(aule.get(selectedIndex).getCapienza());
		return datiAula;
	}

	public void modificaAule(int selectedIndex, String nome, String capienzaStr){
		aule.get(selectedIndex).setNome(nome);
		aule.get(selectedIndex).setCapienza(Integer.parseInt(capienzaStr.trim()));
	}

	public List<String> getAule() {
		List<String> auleList = new ArrayList<>();

		for (Aula aula : aule) {
			auleList.add("Aula: " + aula.getNome() + " || Capienza: " + aula.getCapienza() + " posti");
		}
		return auleList;
	}
	public List<String> getInsegnamentiPerRicercaAnno() {
		List<String> listaFormattata = new ArrayList<>();

		for (Docente docente : docenti) {
			if (docente.getMaterie() != null) {
				for (Insegnamento ins : docente.getMaterie()) {
					String voce = ins.getNome() + " - Anno: " + ins.getAnno() +
							" || Docente: " + docente.getNome() + " " + docente.getCognome();
					listaFormattata.add(voce);
				}
			}
		}
		return listaFormattata;
	}

	public List<String> getInsegnamentiPerAnno(String annoCercato) {
		List<String> listaFormattata = new ArrayList<>();

		for (Docente docente : docenti) {
			if (docente.getMaterie() != null) {
				for (Insegnamento ins : docente.getMaterie()) {
					if (ins.getAnno().name().equalsIgnoreCase(annoCercato)) {
						String voce = ins.getNome() + " - Anno: " + ins.getAnno() +
								" || Docente: " + docente.getNome() + " " + docente.getCognome();
						listaFormattata.add(voce);
					}
				}
			}
		}
		return listaFormattata;
	}
}
