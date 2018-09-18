package brayan_moreno;

import processing.core.PApplet;

public class Protagonista {
	protected PApplet app;
	protected int x, y, tam;

	public Protagonista(PApplet app) {
		this.app = app;
		x = app.width / 2;
		y = app.height / 2;
		tam=30;
	}

	public void pintar() {
		app.fill(0);
		app.rect(x, y, tam+10, tam * 4,80);
	}

}
