package brayan_moreno;

import processing.core.PApplet;

public class OrbeR extends Orbe {

	public OrbeR(PApplet app) {
		super(app);
		x = (int) app.random(app.width + 50, app.width + 100);
		y = (int) app.random(50, app.height - 250);
		color = app.color(255, 0, 0, 90);

	}

	public OrbeR(PApplet app, int x, int y) {
		super(app);
		this.x = x;
		this.y = y;
		color = app.color(255, 0, 0, 90);
	}

	@Override
	public void pintar() {
		app.fill(color);
		app.ellipse(x, y, tam, tam);

	}

	public void mover() {
		x += 3;
		y += 5.5;
	}

}
