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
 * Classe rappresentate la struttura Biblbiotecario.
 */
public class Bibliotecario extends Persona {

	/**
	 * Instantiates a new bibliotecario.
	 *
	 * @param nome 
	 * @param cognome 
	 * @param indirizzo 
	 * @param dataNascita 
	 * @param codiceFiscale 
	 * @param telefono 
	 * @param email the 
	 * @param password 
	 * @param sbuAppartenenza 
	 */
	public Bibliotecario(String nome, String cognome, String indirizzo, Date dataNascita, String codiceFiscale,
			String telefono, String email, String password, Sbu sbuAppartenenza) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, telefono, email, password, sbuAppartenenza);
	}

}

