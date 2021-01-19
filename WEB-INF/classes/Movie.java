package net.moviedb;

public class Movie {
	private String title, genre, mood, category;
	private int year;
	private double score;

	
	public Movie() {
		super();
	}

	public Movie(String title, String genre, String mood, int year, double score) {
		super();
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.mood = mood;
		this.score = score;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}

