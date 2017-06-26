/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

// TODO: Auto-generated Javadoc
/**
 * Classe rappresentate la struttura della Recensione.
 */
public class Recensione {
    
    /**  Attributes. */
    private String titolo;
    
    /** The id. */
    private int id;
    
    /** The totale. */
    private static int totale=0; // tiene conto di tutti i prestiti del sistema
    
    /** The descrizione. */
    private String descrizione;
   
    /**  Associations. */
    private UtenteRegistrato recensore;

	public Recensione(String titolo, String descrizione, UtenteRegistrato recensore) {
		super();
		this.titolo = titolo;
		this.id=totale;
		totale++; // incremento il numero totale di recensioni nel sistema
		this.descrizione = descrizione;
		this.recensore = recensore;
	}
    
    
    
   
}

