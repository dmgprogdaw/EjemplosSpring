package com.david.iniciandoSpring.bean;

public class Autor {

	private int id;
	private String nombre;
	private Integer edad;
	private String email;
	private String coche;
	private String sexo;
	private String descripcion;
	private Integer barrita;
	private boolean carnet;
	
	
	public boolean isCarnet() {
		return carnet;
	}
	public void setCarnet(boolean carnet) {
		this.carnet = carnet;
	}
	public Integer getBarrita() {
		return barrita;
	}
	public void setBarrita(Integer barrita) {
		this.barrita = barrita;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCoche() {
		return coche;
	}
	public void setCoche(String coche) {
		this.coche = coche;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
