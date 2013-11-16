package DBManagement;

import beans.Album;
import beans.Book;
import beans.ComplexOrder;
import beans.Contient;
import beans.Format;
import beans.Photo;
import beans.SimpleOrder;
import beans.Utilisateur;

public class CRUD {
	
	/*** UTILISATEUR ***/
	public void addUtilisateur(Utilisateur u) {
		u.add();
	}
	
	/*** PHOTO ***/
	public void addPhoto(Photo p) {
		p.add();
	}
	
	/*** ALBUM ***/
	public void addAlbum(Album a) {
		a.add();
	}
	
	/*** CONTIENT ***/
	public void addContient(Contient c) {
		c.add();
	}

	/*** BOOK ***/
	public void addBook(Book b) {
		b.add();
	}

	/*** FORMAT ***/
	public void addFormat(Format f) {
		f.add();		
	}

	/*** SIMPLE ORDER ***/
	public void addSimpleOrder(SimpleOrder so) {
		so.add();
	}
	
	public void removeSimpleOrder(Integer id) {
		SimpleOrder so = new SimpleOrder();
		// so.remove(id);
	}

	/*** COMPLEX ORDER ***/
	public void addComplexOrder(ComplexOrder co) {
		co.add();
	}
}
