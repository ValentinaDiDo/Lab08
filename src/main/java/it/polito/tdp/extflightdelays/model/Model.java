package it.polito.tdp.extflightdelays.model;
import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.graph.*;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;
public class Model {

	List<Flight> voli;
	List<Airport> aeroporti;
	List<Connessioni> connessioni;
	Map<Integer, Airport> mAeroporti = new TreeMap<Integer, Airport>();
	SimpleWeightedGraph <Airport, DefaultWeightedEdge> grafo = new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
	ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
	public Model() {
		
	}
	public void attivaModel() {
		this.aeroporti = dao.loadAllAirports(); //PRENDO TUTTI GLI AEROPORTI
	//	this.voli = dao.loadAllFlights(); //PROB INUTILE
		
		for(Airport a : aeroporti) {
			mAeroporti.put(a.getId(), a);
			//System.out.println(a.getId()+" "+a.getAirportName());
		}
	}
	public void creaGrafo(int d) {
		connessioni = dao.getConnectedAirports(d, mAeroporti);
		
		//ORA SELEZIONO SOLO I GRAFI CHE RISPETTANO I PARAMETRI DI DISTANZA
		for(Connessioni c : connessioni) {
			Graphs.addEdgeWithVertices(grafo, c.Partenza, c.Arrivo, c.distanza);
		}
		
	}
	
	
	public int numeroVerticiGrafo() {
		return this.grafo.vertexSet().size();
	}
	public int numeroArchiGrafo() {
		return this.grafo.edgeSet().size();
	}
	public List<Connessioni> getAllConnessioni(){
		return this.connessioni;
	}
	
	
}
