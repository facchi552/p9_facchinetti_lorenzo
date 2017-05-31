/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */
package biblio;

import java.util.Date;
import java.util.List;


/**
 * Classe per rappresentare gli UtentiRegistrati.
 */
public class UtenteRegistrato extends Persona {
	
	/**  Associations. */
    private List<Prestito> prestiti;
    
    /** The articoli. */
    private List<Articolo> articoli;
    
    /**
     * Instantiates a new utente registrato.
     *
     * @param nome 
     * @param cognome 
     * @param indirizzo 
     * @param dataNascita 
     * @param codiceFiscale 
     * @param telefono
     * @param email 
     * @param password 
     * @param sbuAppartenenza 
     */
    public UtenteRegistrato(String nome, String cognome, String indirizzo, Date dataNascita, String codiceFiscale,
			String telefono, String email, String password, Sbu sbuAppartenenza) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, telefono, email, password, sbuAppartenenza);
	}
}

