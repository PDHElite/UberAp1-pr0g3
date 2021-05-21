package com.uberapi.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viajes")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @Column(name = "id_persona")
	 private Long idPersona;

	 @Column(name = "id_piloto")
	 private Long idPiloto;

	 @Column(name = "origen")
	 private String origen;

	 @Column(name = "destino")
	 private String destino;

	 @Column(name = "estado")
	 private String estado;

	 @Column(name = "monto")
	 private Integer monto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public Long getIdPiloto() {
		return idPiloto;
	}
	public void setIdPiloto(Long idPiloto) {
		this.idPiloto = idPiloto;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	

	
	
	
}
