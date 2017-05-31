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

// TODO: Auto-generated Javadoc
/**
 * Classe rappresentate la struttura Biblioteca.
 */
public class Biblioteca {
    
    /**  Attributes. */
    private String nome;
    
    /** The indirizzo. */
    private String indirizzo;
    
    /** The id. */
    private int id;
    
    /** The totale. */
    private static int totale=0; // tiente conto di tutte le biblitoeche del sistema
    
    /**  Associations. */
    private ArrayList<Articolo> articoli;
    
    /** The recensioni. */
    private ArrayList<Recensione> recensioni;
    
    /** The sbu appartenenza. */
    private Sbu sbuAppartenenza;
   
    /**
     * Costruttore.
     *
     * @param nome 
     * @param indirizzo 
     * @param sbuAppartenenza
     */
     public Biblioteca(String nome, String indirizzo, Sbu sbuAppartenenza) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.id = totale;
		totale++; // incremento il numero totale di biblioteche nel sistema;
		this.sbuAppartenenza = sbuAppartenenza;
		articoli = new ArrayList<Articolo>();
	    recensioni = new ArrayList<Recensione>();
	}
     
     /**
      * Inserisce un articolo nella specifica biblioteca 
      *
      * @param tipo il tipo di articolo
      * @param args stringa rappresentante le informazioni relative all'articolo, ottenute dalla gui
      */
     public void inserisciArticolo(int tipo,String args,Biblioteca b) {
    	 StringTokenizer st = new StringTokenizer(args,"|");
    	 String temp[] = new String[st.countTokens()];
    	 
    	 for (int i=0; i<=st.countTokens(); i++) {
    		 temp[i] = st.nextToken();
     	 }
    	 
    	 if (tipo==1) {
    		 Libro l = new Libro(temp[0], temp[1], temp[2], temp[3], b, temp[4], temp[5], temp[6]);
    		 articoli.add(l);
    		 System.out.println(this.nome + ": Libro inserito correttamente");
    	 } else if (tipo==2) {
    		 Miscellanea m = new Miscellanea(temp[0],temp[1],temp[2],temp[3],b, temp[4]);
    		 articoli.add(m);
    		 System.out.println(this.nome + ": Miscellanea inserita correttamente");
    	 } else {
    		 System.out.println("Tipologia non esistente");
    	 }
     }
    
    /**
     * Rispetto all'srs e' stato lievemente cambiato il senso della ricerca 
     * i req di implementazione risultavano vaghi. Si e' fatta fede all'sdd.
     *
     * @param arg il titolo dell'opera ricercata 
     * @param tipo libro o miscellanea
     * @param filtri ottenuti dalla gui
     * @return <Articolo> lista di articoli trovati
     */
    public ArrayList<Articolo> ricercaArticolo ( String arg , int tipo, String filtri[] ) {
    	ArrayList<Articolo> trovati = new ArrayList<Articolo>();
    	
    	for (Articolo a : articoli) {
    		if ( arg == null) {
    			 if  ( (a.getAutore().equals(filtri[0])) || (a.getGenere().equals(filtri[1])) ) {
    				 trovati.add(a);
    	    } else if (arg != null && a.getTitolo().contains(arg)) {
     			     trovati.add(a);
    		}
    		}
    	} 
    return trovati;
    }
    
    /**
     * visualizzaPrestitiTotali
     * non implementato
     *
     * @return Prestito[*]
     */
    public ArrayList<Prestito> visualizzaPrestitiTotali (  )
    {
    	return null;
    }

    /**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
    public String getNome() {
		return nome;
	}
}

