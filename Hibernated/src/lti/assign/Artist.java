package lti.assign;

import java.util.HashSet;
import java.util.Set;

public class Artist {

	private int artistId;
	private String artistName;

	private Set<Song> songs;
	private Set<Album> albums;

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Set<Song> getSongs() {
		return songs == null ? new HashSet<Song>() : songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}

	public Set<Album> getAlbums() {
		return albums == null ? new HashSet<Album>() : albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}
