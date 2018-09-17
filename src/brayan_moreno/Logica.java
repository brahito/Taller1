package brayan_moreno;

import processing.core.PApplet;

public class Logica {
	PApplet app;
	Lluvia[] lluvia = new Lluvia[500];
	boolean caer;

	public Logica(PApplet app) {
		this.app = app;

		caer = false;
		for (int i = 0; i < lluvia.length; i++) {
			lluvia[i] = new Lluvia(app);
		}
	}

	public void pintar() {
		for (int i = 0; i < lluvia.length && caer; i++) {
			lluvia[i].agua();
			lluvia[i].caer();
		}
	}

	public void presionar() {
		if (app.key == 'a') {
			caer = !caer;
		}
	}
}
