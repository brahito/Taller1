package brayan_moreno;

import processing.core.PApplet;

public class Nubes {
	protected PApplet app;
	protected int y, tam, largo;

	public Nubes(PApplet app) {
		this.app = app;
		tam = 50;
		largo = 60;
		y = -10;
	}

	public void pintar(int x) {
		app.fill(153, 153, 153, 150);
		app.noStroke();

		app.ellipseMode(PApplet.CENTER);
		app.ellipse(x, y, tam + largo + 20, tam);
		app.ellipse(x - tam / 2, y + tam / 2, tam + largo, tam);
		app.ellipse(x + tam / 2, y + tam / 2, tam + largo, tam);
	}

}
