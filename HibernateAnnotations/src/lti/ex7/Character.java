package lti.ex7;

//Character to Movie is many to one relationship

public class Character {

	private int charNo;
	private String charName;
	private Movie movie;
	
	public int getCharNo() {
		return charNo;
	}
	public void setCharNo(int charNo) {
		this.charNo = charNo;
	}
	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
