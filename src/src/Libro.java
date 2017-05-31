/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

// TODO: Auto-generated Javadoc
/**
 * Classe rappresentate la struttura Libro.
 */
public class Libro extends Articolo {
    
    /**  Attributes. */
    private String isbn;
    
    /** The casa editrice. */
    private String casaEditrice;
    
    /** The pagine. */
    private String pagine;
    
    /**
     * Instantiates a new libro.
     *
     * @param titolo 
     * @param autore 
     * @param genere 
     * @param collocazione 
     * @param b 
     * @param isbn
     * @param casaEditrice
     * @param pagine 
     */
    public Libro(String titolo, String autore, String genere, String collocazione, Biblioteca b, String isbn, String casaEditrice,
			String pagine) {
		super(titolo, autore, genere, collocazione, b );
		this.isbn = isbn;
		this.casaEditrice = casaEditrice;
		this.pagine = pagine;
	}

	/**
	 * Gets the isbn.
	 *
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Gets the casa editrice.
	 *
	 * @return the casa editrice
	 */
	public String getCasaEditrice() {
		return casaEditrice;
	}

	/**
	 * Gets the pagine.
	 *
	 * @return the pagine
	 */
	public String getPagine() {
		return pagine;
	}
    
}

