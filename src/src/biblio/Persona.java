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
 * Classe rappresentate la struttura Persona.
 */
public abstract class Persona {
    
    /**  Attributes. */
    private String nome;
    
    /** The cognome. */
    private String cognome;
    
    /** The id. */
    private int id;
    
    /** The totale. */
    private static int totale=0; // tiene conto di tutte le persone nel sistema
    
    /** The indirizzo. */
    private String indirizzo;
    
    /** The data nascita. */
    private Date dataNascita;
    
    /** The codice fiscale. */
    private String codiceFiscale;
    
    /** The telefono. */
    private String telefono;
    
    /** The email. */
    private String email;
    
    /** The password. */
    private String password;
    
    /**  Associations. */
    private Sbu sbuAppartenenza; 
    
    /**
     * Costruttore.
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
     * @return Persona
     */
    public Persona(String nome, String cognome, String indirizzo, Date dataNascita, String codiceFiscale,
			String telefono, String email, String password, Sbu sbuAppartenenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.id=totale;
		totale++; // incremento il numero totale di persone nel sistema
		this.indirizzo = indirizzo;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.sbuAppartenenza = sbuAppartenenza;
	}
    
    /**
     * Operation.
     *
     * @param arg the arg
     * @return boolean
     */
    public boolean ricercaPersona ( String arg ) {
       return true;
    }
    
    /**
     * Operation.
     *
     * @return boolean
     */
    public String getCodiceFiscale() {
		return codiceFiscale;
	}

    /**
     * Operation.
     *
     * @return boolean
     */
	public String getEmail() {
		return email;
	}

	 /**
 	 * Operation.
 	 *
 	 * @return boolean
 	 */
	public String getPassword() {
		return password;
	}
	
	 /**
 	 * Operation.
 	 *
 	 * @return boolean
 	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Operation.
	 *
	 * @return String
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Operation.
	 *
	 * @return String
	 */
	public String getCognome() {
		return cognome;
	}
   
}


