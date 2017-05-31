/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Classe rappresentate la struttura ManagerDiSistema.
 */
public class ManagerDiSistema extends Persona {

	/**
	 * Instantiates a new manager di sistema.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param indirizzo the indirizzo
	 * @param dataNascita the data nascita
	 * @param codiceFiscale the codice fiscale
	 * @param telefono the telefono
	 * @param email the email
	 * @param password the password
	 * @param sbuAppartenenza the sbu appartenenza
	 */
	public ManagerDiSistema(String nome, String cognome, String indirizzo, Date dataNascita, String codiceFiscale,
			String telefono, String email, String password, Sbu sbuAppartenenza) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, telefono, email, password, sbuAppartenenza);
		
	}
  
}

