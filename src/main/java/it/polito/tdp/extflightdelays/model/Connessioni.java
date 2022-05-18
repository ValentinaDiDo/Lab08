package it.polito.tdp.extflightdelays.model;

public class Connessioni {

	Airport Partenza;
	Airport Arrivo;
	int distanza;
	public Connessioni(Airport idPartenza, Airport idArrivo, int distanza) {
		super();
		this.Partenza = idPartenza;
		this.Arrivo = idArrivo;
		this.distanza = distanza;
	}
	
	public String getAeroportoPartenza(){
		return this.Partenza.getAirportName()+" ("+this.Partenza.getId()+")";
	}
	public String getAeroportoArrivo(){
		return this.Arrivo.getAirportName()+" ("+this.Arrivo.getId()+")";
	}
	public int getDistanza() {
		return this.distanza;
	}
	
}
