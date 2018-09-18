package brayan_moreno;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {
	protected PApplet app;
	protected Lluvia[] lluvia = new Lluvia[500];
	protected boolean caer;
	protected Protagonista prota;
	protected ArrayList<Nubes> nubes;

	public Logica(PApplet app) {
		this.app = app;
		nubes = new ArrayList<Nubes>();
		caer = false;
		prota = new Protagonista(app);
		for (int i = 0; i < lluvia.length; i++) {
			lluvia[i] = new Lluvia(app);
		}
		for (int i = 0; i < 13; i++) {
			nubes.add(i, new Nubes(app));
		}

	}

	public void pintar() {

		for (int i = 0; i < lluvia.length && caer; i++) {
			lluvia[i].agua();
			lluvia[i].caer();
		}
		for (int i = 0; i < nubes.size(); i++) {
			nubes.get(i).pintar(i * 100);
		}
		prota.pintar();

	}

	public void presionar() {
		if (app.key == 'a') {
			caer = !caer;
		}
	}
}
