package controller;

import model.AnnoAccademico;
import model.Docente;
import model.Studente;
import model.Utente;

import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.MissingResourceException;

public class Controller {
	ArrayList<Studente> studenti = new ArrayList<Studente>();
	ArrayList<Docente> docenti = new ArrayList<Docente>();

	public Controller() {
	}

	public void registrazioneStudente(String login, String password, String nome, String cognome, String email, String matricola, AnnoAccademico annoCorso) throws LoginException, AuthenticationException, CampoVuotoException {
		for (Utente utente : studenti) {
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
		studenti.add(new Studente(login,password,nome,cognome,email,matricola,annoCorso));

	}

	private static class CampoVuotoException extends Exception{
		public CampoVuotoException(String message){
			super(message);
		}
	}
}
