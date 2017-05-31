/*
 * Lorenzo Facchinetti
 * Date: 20/05/2016
 * Copyright notice: No Copyright
 * Software ad uso didattico
 */

package biblio;

// TODO: Auto-generated Javadoc
/**
 * Classe rappresentate la struttura Miscellanea.
 */
public class Miscellanea extends Articolo {
    
    /**  Attributes. */
    private String tipo;

	/**
	 * Instantiates a new miscellanea.
	 *
	 * @param titolo the titolo
	 * @param autore the autore
	 * @param genere the genere
	 * @param collocazione the collocazione
	 * @param b the b
	 * @param tipo the tipo
	 */
	public Miscellanea(String titolo, String autore, String genere, String collocazione, Biblioteca b, String tipo) {
		super(titolo, autore, genere, collocazione, b);
		this.tipo = tipo;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

}
