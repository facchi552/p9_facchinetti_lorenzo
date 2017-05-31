/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Classe rappresentate la struttura dell'Sbu.
 */
public class Sbu {
    
    /**  Attributes. */
    private String nome;
    
    /** The articoli consigliati. */
    private ArrayList <String> articoliConsigliati;
    
    /**  Associations. */
    private ArrayList<Recensione>  recensioni;
    
    /** The biblioteche. */
    private ArrayList<Biblioteca>  biblioteche;
    
    /** The persone. */
    private ArrayList<Persona> persone;
    
    /**
     * Costruttore.
     *
     * @param nome the nome
     */
    public Sbu(String nome) {
		super();
		this.nome = nome;
		persone = new ArrayList<Persona>();
		recensioni = new ArrayList<Recensione>();
		biblioteche = new ArrayList<Biblioteca>();
		articoliConsigliati = new ArrayList<String>();
		}
    
    /**
     * Autenticazione
     *
     * @param username 
     * @param password 
     * @return boolean return 1 se autenticazione avvenuta 0 se fallita
     */
    public boolean login ( String username, String password ) {
    	boolean trovato = false;
    
    	for (Persona p : persone) {
    		if ((p.getEmail().equals(username)) && (p.getPassword().equals(password))) {
    		trovato = true;
    		System.out.println(this.nome + ": Autenticato " + username);
    		}
    	}
    	if (trovato == false) {
    		System.out.println(this.nome + ": Errore nei dati inseriti, " + username + " non trovato");
    	}
    return trovato;
    }
    
    /**
     * Metodo che effettua la ricerca articolo all'interno di ogni biblioteca appartenente all'sbu
     *
     * @param arg Il titolo dell'opera ricercata
     * @param tipo 
     * @param filtri
     * @return <Articolo> return gli articoli appartenenti al Sbu
     */
    public ArrayList<Articolo> ricercaArticolo ( String arg , int tipo, String filtri[] ) {
    	ArrayList<Articolo> articoliTrovati = new ArrayList<Articolo>();
    	for (Biblioteca b : biblioteche) {
    		articoliTrovati = b.ricercaArticolo(arg, tipo, filtri);
    	}
    	
    	return articoliTrovati;
    }
    
    /**
     * Metodo utilizzato per la funzione consiglia libro
     *
     * @param testo the testo
     */
    public void consigliaLibro ( String testo ) {
    	
    	articoliConsigliati.add(testo + "pending");
    	System.out.println(this.nome + ": L'articolo consigliato e' stato registrato ");
    }
    
    /**
     * Metodo per la ricerca dell'utente con nome e/o cognome
     *
     * @param arg Nome e Cognome utente
     * @return ArrayList<Persona>
     */
    public ArrayList<Persona> ricercaUtente ( String arg ) {
    	ArrayList<Persona> trovati = new ArrayList<Persona>();
    	StringTokenizer st = new StringTokenizer(arg,"|");
        String temp[] = new String[st.countTokens()];
        
        for (int i=0; i<=st.countTokens(); i++) {
        	 temp[i] = st.nextToken();
         	}
        
        System.out.println(this.nome + ": Ricerco l'utente: " + temp[0] + " " + temp[1]);
        
    	for (Persona p : persone) {
    		if ((p.getNome().contains(temp[0])) || (p.getCognome().contains(temp[1]))) {
    		trovati.add(p);
    		}
    	}
    	
    return trovati;
    }
    
    /**
     * Metodo per la ricerca dell'utente con id
     *
     * @param id
     * @return trovato 
     */
    public Persona ricercaUtente ( int id ) {
    	Persona trovato = null;
    	for (Persona p : persone) {
    		if (p.getId()==id) {
    		trovato=p;
    		}
    	}
    return trovato;
    }
    
    
    /**
     * Metodo utile per verificare l'univocita' di un utente nel sistema
     * Non presente nei diagrammi ma utile in fase implementativa
     *
     * @param cf the cf
     * @return Boolean 1 se utente gia' registrato, 0 se non e' registrato
     */
    public boolean utenteIsUnivoco ( String cf ) {
    	for (Persona p: persone) {
    		if (p.getCodiceFiscale().equals(cf)) {
    			return false;
    		}
    	}
    return true;
    }
    
    /**
     * Metodo per l'inserimento di un utente a sistema
     *
     * @param utente 
     */
    public void inserisciUtente ( Persona utente ) {
    	if (utenteIsUnivoco(utente.getCodiceFiscale())) {
    		persone.add(utente);
            System.out.println(this.nome + ": Utente inserito. Username:" + utente.getEmail() + " Password: " +utente.getPassword());
    	} else {
    		System.out.println(this.nome + ": Utente gia' presente a sistema");
    	}
    }
    
    /**
     * Operation.
     * Non implementato
     *
     * @param utente the utente
     */
    public void rimuoviUtente ( Persona utente ) {
        
    	
    }
    
    /**
     * Operation.
     * Non implementato
     *
     * @param articolo the articolo
     * @param testo the testo
     */
    public void scriviRecensione ( Articolo articolo, String testo ) {
        
    }
    
    /**
     * Operation.
     * Non implementato
     *
     * @param Id the id
     * @return Prestito
     */
    public Prestito ricercaPrestito ( int Id ) {
      
    	return null;
    }
    
    /**
     * Non implementato
     *
     * @param nome the nome
     * @param cognome the cognome
     * @return Prestito
     */
    public Prestito ricercaPrestito ( String nome, String cognome ) {
    	return null;
    }
  
    /**
     * Operation.
     * Non implementato
     *
     * @param articolo the articolo
     * @return Prenotazione
     * Persona[]
     */
    public List<Persona> ricercaPrenotazione ( Articolo articolo ) {
    	return null;
    }
    
    /**
     * Operation.
     * Non implementato
     *
     * @param nome the nome
     * @param cognome the cognome
     * @return Articolo[]
     */
    public List<Articolo> ricercaPrenotazione ( String nome, String cognome ) { 
    	return null;
    }
    
   /**
    * Operation.
    * Non implementato
    *
    * @return String[*]
    */
    public String[] visualizzaRichieste (  ) {
       return null;
    }

    /**
     * Aggiunge una biblioteca al sistema
     * 
     * @param biblio rappresenta la biblitoeca da aggiungere al sistema
     * @return String[*]
     */
    public void addBiblioteca (Biblioteca biblio) {
	this.biblioteche.add(biblio);
    }
    
}


