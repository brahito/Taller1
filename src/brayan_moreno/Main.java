package brayan_moreno;

import processing.core.PApplet;

public class Main extends PApplet {
	Logica log;

	public static void main(String[] args) {
		PApplet.main("brayan_moreno.Main");
	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		log = new Logica(this);
	}

	public void draw() {
		background(235);
		log.pintar();
	}

	public void keyPressed() {
		log.tecla();
	}

	public void mousePressed() {
		log.clic();
	}

	public void mouseDragged() {
		
	}

}
