package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Espandi {
	
	private List<Schedina> soluzioni;
	
	public List<Schedina> espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN()) ;
		soluzioni = new ArrayList<Schedina>();
		espandi(p, parziale, 0) ;
		
		return this.soluzioni;
	}
	
	
	// Livello della ricorsione = singola partita
	// livello = 0 -> schedina con 0 risultati
	// livello = 1 -> schedina con 1 risultato ...
	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		
		// parziale contiene gi�(livello) valori 
		//		nelle posizioni 0...livello-1
		// io devo determinare parziale[livello]
		//		(cio� la livello+1esima riga)
		// sulla base della previsione in p[livello]
		
		
		if(livello==p.getN()) {
			//System.out.println(parziale) ;
			this.soluzioni.add(new Schedina(parziale));
			return ;
		}
		
		
		Previsione prev = p.get(livello) ;
		
		// prova le varie alternative
		for(Risultato r: prev.getValori()) {
			// provo ad aggiungere 'r'
			parziale.add(r);
			
			espandi(p, parziale, livello+1) ;
			
			// backtrack
			parziale.removeLast();
			
		}
		
	}
	

}
