/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe costruita per eseguire la dimostrazione delle funzionalià del sistema.
 *
 */
public class Demo {
	
	/** Array atto a contenere i risultati della simulazione di ricerca utenti. */
	static ArrayList<Persona> found = new ArrayList<Persona>();
	
	/** Array atto a contenere i risultati della simulazione di ricerca articoli. */
	static ArrayList<Articolo> foundz = new ArrayList<Articolo>();
	
	/** Il sistema. */
	static Sbu sistema = new Sbu("Sbu");
	
	/** Una Biblioteca. */
	static Biblioteca biblio= new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
	
	/** Una biblioteca. */
	static Biblioteca biblia= new Biblioteca ("Biblio 2", "piazza Dante 7", sistema);
	
	/**
	 * Il metodo che permette di eseguire la dimostrazione
	 * Nb: i controlli sulla compilazione dei campi sono lasciati alla gui
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		/* Stampa di Benvenuto*/
		System.out.println("##### Benvenuto nella demo del Sistema di Gestione di una Biblioteca p9_facchinetti_lorenzo #####");
		
		/* Preparazione ed esecuzione Uc23 riferimento figura 6  Sdd*/
		System.out.println("\n# Esecuzione Uc23: Registra nuovo utente #");
		sistema.inserisciUtente(new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cf", "1234", "mail@gmailcom", "1234", sistema));
		sistema.inserisciUtente(new Bibliotecario ("Mario", "Rossi", "via bari 33", new Date(), "cfmario", "7776", "mrossi@gmailcom", "5432", sistema));
		System.out.println("\n# Esecuzione Uc23 - 6b #");
		sistema.inserisciUtente(new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cf", "1234", "amail@gmailcom", "1234", sistema));
		sistema.inserisciUtente(new UtenteRegistrato ("Mario", "rossi", "via roma 11", new Date(), "cfmaria", "1234", "ehe@gmailcom", "1234", sistema));
		
		/* Preparazione ed esecuzione Uc1 riferimento figura 8 sdd*/
		System.out.println("\n# Esecuzione Uc1: Autenticarsi #");
		sistema.login("mrossi@gmailcom", "5432");
		System.out.println("\n# Esecuzione Uc1 -5a #");
		sistema.login("mdrossi@gmail.com", "5432");
		System.out.println("\n# Esecuzione Uc1 -5a #");
		sistema.login("mrossi@gmail.com", "54321");
		
		/* Preparazione ed esecuzione Uc2*/
		System.out.println("\n# Esecuzione Uc2: Inserire nuovo Articolo #");
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblia.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblia);
		biblia.inserisciArticolo(1, "Titolo3|Autore3|Genere3|collocazione3|isbn|casa editrice|565", biblia);
		System.out.println("\n# Esecuzione Uc2 -3a #");
		biblio.inserisciArticolo(2, "Titolo1|Autore1|Genere1|collocazione1|dvd", biblia);
		biblio.inserisciArticolo(2, "Titolo2|Autore2|Genere1|collocazione2|rivista", biblio);
		
		/* Preparazione ed esecuzione Uc7 riferimento figura 10 sdd*/
		System.out.println("\n# Esecuzione Uc7: Ricerca Utente Registrato #");
		demoRicercaUtenteN ("Mario| Rossi"); // si e' reso necessario ai fini della dimostrazione invocare un metodo aggiuntivo 
		System.out.println("\n# Esecuzione Uc7 -4b #");
		demoRicercaUtenteN ("Non| Trovare");
		System.out.println("\n# Esecuzione Uc7 -2a (ricerca per id) #");
		demoRicercaUtenteI (1); // si e' reso necessario ai fini della dimostrazione invocare un metodo aggiuntivo 
		System.out.println("\n# Esecuzione Uc7 -2a (ricerca per id) #");
		demoRicercaUtenteI (2);
		
		/* Preparazione ed esecuzione Uc27 riferimento parziale aa figura 3 sdd*/
		System.out.println("\n# Esecuzione Uc27: Cosniglia Acquisto nuovi libri #");
		sistema.consigliaLibro("Vorrei che venisse acquistato il libro xxx dell'autore yyy");
		
		/* Preparazione ed esecuzione Uc3 riferimento figura 7 sdd*/
		System.out.println("\n# Esecuzione Uc3: Ricerca Articolo #");
		sistema.addBiblioteca(biblio); 
		System.out.println("\n# Esecuzione Uc3 -4d (ricerca con filtro: genere) #");
		sistema.addBiblioteca(biblia);
		String fil[]=new String [2]; // utile per la simulazione filtri ottenuti dalla gui
		fil[0]="";
		fil[1]="Genere3";
		demoRicercaArticoli("Titolo3", 1,null); // si e' reso necessario ai fini della dimostrazione invocare un metodo aggiuntivo 
		demoRicercaArticoli(null,1,fil); // si e' reso necessario ai fini della dimostrazione invocare un metodo aggiuntivo 
		
		/* Stampa di Fine Dimostrazione*/
		System.out.println("\n\n##### FINE. Grazie per aver utilizzato la demo del Sistema di Gestione di una Biblioteca p9_facchinetti_lorenzo #####");
	}
		
	/**
	 * Metodo aggiuntivo per la ricerca utente con nome e cognome ( ottenuti da gui a regime )
	 *
	 * @param nomeCognome 
	 */
	public static void demoRicercaUtenteN (String nomeCognome) {
		found=sistema.ricercaUtente(nomeCognome);
		
		if (found.isEmpty()) {
			System.out.println("Con i parametri forniti non e' stato trovato nessun utente"); 
		} else {
			System.out.println("\nI risultati della ricerca sono: ");
			for (Persona p : found) {
				System.out.println(p.getNome() + " " + p.getCognome() + " " +  p.getCodiceFiscale() + " Id: " + p.getId());
    		}
		}
	}
	
	/**
	 * Metodo aggiuntivo per la ricerca utente con id ( dato ottenuto da gui a regime )
	 *
	 * @param id the id
	 */
	public static void demoRicercaUtenteI (int id) {
		Persona p;
		p = sistema.ricercaUtente(id);
		if (p == null ) {
			System.out.println("Con i parametri forniti non e' stato trovato nessun utente"); 
		} else {
			System.out.println("I risultati ricerca con id=" + id +" sono:" );
			System.out.println(p.getNome() + " " + p.getCognome() + " " +  p.getCodiceFiscale());
    	
		}
	}
	
	/**
	 * Metodo aggiuntivo per la ricerca articoli
	 *
	 * @param titolo 
	 * @param tipo libro o miscellanea
	 * @param filtri  ottenuti da gui a regime (opzionali)
	 */
	public static void demoRicercaArticoli (String titolo, int tipo, String filtri[] ) {
		foundz = sistema.ricercaArticolo(titolo,tipo,filtri);
		
		if (foundz.isEmpty()) {
			System.out.println("Con i parametri forniti non e' stato trovato nessun articolo"); 
		} else {
			System.out.println("\nI risultati della ricerca sono: ");
			for (Articolo a : foundz) {
				System.out.println(a.getTitolo() + " " + a.getAutore() + " " +  a.getGenere() + " Biblioteca: " + a.getBiblio().getNome() + " Collocazione: " + a.getCollocazione() );
    		}
		}
	}
}
