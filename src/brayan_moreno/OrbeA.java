package brayan_moreno;

import processing.core.PApplet;

public class OrbeA extends Orbe {
	public OrbeA(PApplet app) {
		super(app);
		x = (int) app.random(-50,-25);
		y = (int) app.random(-25,app.height+25);
	}

	public OrbeA(PApplet app, int x, int y) {
		super(app);
		this.x = x;
		this.y = y;
	}

	@Override
	public void pintar() {
		app.fill(0, 0, 255, 90);
		app.ellipse(x, y, tam, tam);
	}

	public void mover() {
		x -= 3;
		y += 5.5;
	}

}
