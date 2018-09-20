package lti.assign;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.util.HibernateUtil;

public class TestMusic {

	@Test
	public void testCase1() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Genre genre = new Genre();
		genre.setGenreName("Pop");

		Artist artist = new Artist();
		artist.setArtistName("Madonna");

		Album album = new Album();
		album.setAlbumName("Happy");
		album.setArtist(artist);

		Song song = new Song();
		song.setSongName("Dance");
		song.setAlbum(album);
		song.setArtist(artist);
		song.setGenre(genre);

		session.save(genre);
		session.save(artist);
		session.save(album);
		session.save(song);

		tx.commit();
		factory.close();

	}
	
	
}
