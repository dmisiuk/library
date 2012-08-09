package by.minsler.library.bean;

import java.io.Serializable;

public class Book implements Serializable {

	private int id;
	private String name;
	private String description;
	private String author;
	private String date;
	private double price;
	private int idpublihser;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIdpublihser() {
		return idpublihser;
	}

	public void setIdpublihser(int idpublihser) {
		this.idpublihser = idpublihser;
	}

}
