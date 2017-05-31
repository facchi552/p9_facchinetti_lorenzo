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
    private int ID;
    
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
    
    
    /**
     * Operation
     *
     * @param dataF
     * @return boolean
     */
    public boolean prolungaPrestito ( Date dataF ) {
    	return true;
    }
    
    /**
     * Operation.
     *
     * @param id the id
     * @return Bool
     */
    public Boolean ricercaPrestito ( int id ) {
      
    	return true;
    }
   
}

