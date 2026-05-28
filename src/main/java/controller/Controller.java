package controller;

import exceptions.CampoVuotoException;
import exceptions.MissingStudentException;
import exceptions.MissingTeacherException;
import model.AnnoAccademico;
import model.Docente;
import model.Studente;
import model.Utente;

import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class Controller {
	ArrayList<Studente> studenti = new ArrayList<Studente>();
	ArrayList<Docente> docenti = new ArrayList<Docente>();

	public Controller() {
	}

	public void registrazioneDocente (String login, String password, String nome, String cognome, String email, String isResponsabile) throws LoginException, AuthenticationException, CampoVuotoException {

		if(login.isBlank() || nome.isBlank() || cognome.isBlank() || email.isBlank() || password.isBlank() || isResponsabile.isBlank()) {
			throw new CampoVuotoException("Bisogna riempire tutti i campi");
		}

		for (Utente utente : docenti) {
			if (utente.getLogin().equals(login)) {
				throw new LoginException("Utente già esistente");
			}
		}

		if(password.equals(nome) || password.length() < 8){
			throw new AuthenticationException("Password corta");
		}

		boolean boolIsResponsabile = isResponsabile.equals("Si");

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

		if(password.equals(nome) || password.length() < 8){
			throw new AuthenticationException("Password corta");
		}

		studenti.add(new Studente(login, password, nome, cognome, email, matricola, annoCorso));

	}

	public boolean loginStudente (String login, String password) throws LoginException, CampoVuotoException, MissingStudentException{
		if(login.isBlank() || password.isBlank()){
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}
		int i,len;
		i = 0;
		len = studenti.size();
		boolean studenteTrovato = false;
		while(!studenteTrovato && i < len){
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

	public boolean loginDocente (String login, String password) throws LoginException, MissingTeacherException {
		if(login.isBlank() || password.isBlank()){
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}
		int i,len;
		i = 0;
		len = docenti.size();
		boolean docenteTrovato = false;
		while(!docenteTrovato && i < len){
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
}
