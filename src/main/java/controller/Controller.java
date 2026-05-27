package controller;

import exceptions.CampoVuotoException;
import exceptions.MissingStudentException;
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

	public void registrazioneDocente (String login, String password, String nome, String cognome, String email, Boolean isResponsabile) throws LoginException, AuthenticationException, CampoVuotoException {
		for (Utente utente : docenti) {
			if (utente.getLogin().equals(login)) {
				throw new LoginException("Utente già esistente");
			}
		}

		if(password.equals(nome) || password.length() < 8){
			throw new AuthenticationException("Password corta");
		}

		if(login.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty()){
			throw new CampoVuotoException("Bisogna riempire tutti i campi");
		}

		docenti.add(new Docente(login, password, nome, cognome, email, isResponsabile));

	}


	public void registrazioneStudente (String login, String password, String nome, String cognome, String email, String matricola, AnnoAccademico annoCorso) throws LoginException, AuthenticationException, CampoVuotoException {
		for (Utente utente : studenti) {
			if (utente.getLogin().equals(login)) {
				throw new LoginException("Utente già esistente");
			}
		}

		if(password.equals(nome) || password.length() < 8){
			throw new AuthenticationException("Password corta");
		}

		if(login.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty()){
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}

		studenti.add(new Studente(login, password, nome, cognome, email, matricola, annoCorso));

	}

	public boolean loginStudente (String login, String password) throws LoginException, CampoVuotoException, MissingStudentException{
		if(login.isEmpty() || password.isEmpty()){
			throw new CampoVuotoException("Bisogna riempire tutti i campi!");
		}
		int i,len;
		i = 0;
		len = studenti.size();
		boolean studenteTrovato = false;
		while(!studenteTrovato && i < len){
			if(studenti.get(i).getLogin().equals(login)){
				studenteTrovato = true;
			}
			i++;
		}
		if (!studenteTrovato)
			throw new MissingStudentException("lo studente " + login + " non esiste.");
		if(studenti.get(i).getPassword().equals(password))
			return true;
		throw new LoginException("Password non corretta");
	}
}
