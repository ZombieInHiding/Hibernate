package lti.ex7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import lti.util.HibernateUtil;

public class MovieCharTest {

	@Test
	public void testCase1() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		
		Movie movie = new Movie();
		movie.setMovieNo(10);
		movie.setMovieName("Inception");
		movie.setMovieGenre("Science Fiction");
		
		tx.begin();
		session.save(movie);
		tx.commit();
	}
	
	@Test
	public void testCase2() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		
		tx.begin();
		Movie movie = (Movie) session.get(Movie.class,10);
		
		Character chars = new Character();
		chars.setCharNo(108);
		chars.setCharName("Wenda");
		chars.setMovie(movie);
		
		session.save(chars);
		tx.commit();
	}
	
}
