package tpdev.tools;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;

public class Modele {

	/** The inchan. */
	private BufferedReader inchan;

	/** The outchan. */
	private OutputStreamWriter outchan;
	
	public Modele () {
		
	}
	
	public OutputStreamWriter getOutchan () {
		return outchan;
	}
	
	public BufferedReader getInchan () {
		return inchan;
	}
	
}
