/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

import java.util.Date;


/**
 * Classe rappresentate la struttura di un Prestito.
 */
public class Prestito {
    
    /**  Attributes. */
    private int id;
    
    /** The totale. */
    private static int totale=0; // tiene conto di tutti i prestiti del sistema
    
    /** The data inizio. */
    private Date dataInizio;
    
    /** The data fine. */
    private Date dataFine;
    
    /** The rinnovi. */
    private int rinnovi;
  
    /**  Associations. */
    private Articolo articolo;
    
    /** The utente assegnatario. */
    private UtenteRegistrato utenteAssegnatario;
    
    
    
    public Prestito(Date dataInizio, Date dataFine, int rinnovi, Articolo articolo,
			UtenteRegistrato utenteAssegnatario) {
		super();
		this.id=totale;
		totale++; // incremento il numero totale di persone nel sistema
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.rinnovi = rinnovi;
		this.articolo = articolo;
		this.utenteAssegnatario = utenteAssegnatario;
	}
   
}

