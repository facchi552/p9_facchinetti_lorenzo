/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Classe rappresentate la struttura Articolo.
 */
public abstract class Articolo {
    
    /**  Attributes. */
    private String titolo;
    
    /** The id. */
    private String id;
    
    /** The autore. */
    private String autore;
    
    /** The genere. */
    private String genere;
    
    /** The collocazione. */
    private String collocazione;
    
    /**  Associations. */
    private List<Recensione> recensioni;
    
    /** The assegnatari. */
    private List<UtenteRegistrato> assegnatari ;
    
    /** The p. */
    private Prestito p;
    
    /** The biblio. */
    private Biblioteca biblio;
    
    /**
     * Instantiates a new articolo.
     *
     * @param titolo 
     * @param autore 
     * @param genere 
     * @param collocazione 
     * @param biblio la biblioteca di appartenenza
     */
    public Articolo(String titolo, String autore, String genere, String collocazione, Biblioteca biblio) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.collocazione = collocazione;
		this.biblio = biblio;
	}
     
    /**
     * Inserisce la Recensione.
     * non implementato
     * 
     * @param recensione the recensione
     */
    public void inserisciRecensione ( Recensione recensione ) {
    	
    }
    
    /**
     * Rimuove la Recensione. 
     * non implementato
     * 
     * @param autore the autore
     */
    public void rimuoviRecensione ( UtenteRegistrato autore ) {
       
    }
    
    /**
     * Inserisce la prenotazione.
     * non implementato
     * 
     * @param utente the utente
     */
    public void prenota ( UtenteRegistrato utente ) {
     
    }
    
    /**
     * Operation.
     *
     * @param utente the utente
     */
    public void rimuoviPrenotazione ( UtenteRegistrato utente ) {
        
    }

	/**
	 * Gets the titolo.
	 *
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the autore.
	 *
	 * @return the autore
	 */
	public String getAutore() {
		return autore;
	}

	/**
	 * Sets the autore.
	 *
	 * @param autore the new autore
	 */
	public void setAutore(String autore) {
		this.autore = autore;
	}

	/**
	 * Gets the genere.
	 *
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * Sets the genere.
	 *
	 * @param genere the new genere
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}

	/**
	 * Gets the collocazione.
	 *
	 * @return the collocazione
	 */
	public String getCollocazione() {
		return collocazione;
	}

	/**
	 * Sets the collocazione.
	 *
	 * @param collocazione the new collocazione
	 */
	public void setCollocazione(String collocazione) {
		this.collocazione = collocazione;
	}

	/**
	 * Gets the recensioni.
	 *
	 * @return the recensioni
	 */
	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	/**
	 * Sets the recensioni.
	 *
	 * @param recensioni the new recensioni
	 */
	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	/**
	 * Gets the assegnatari.
	 *
	 * @return the assegnatari
	 */
	public List<UtenteRegistrato> getAssegnatari() {
		return assegnatari;
	}

	/**
	 * Sets the assegnatari.
	 *
	 * @param assegnatari the new assegnatari
	 */
	public void setAssegnatari(List<UtenteRegistrato> assegnatari) {
		this.assegnatari = assegnatari;
	}

	/**
	 * Gets the biblio.
	 *
	 * @return the biblio
	 */
	public Biblioteca getBiblio() {
		return biblio;
	}
	
}


