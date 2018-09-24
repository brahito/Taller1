package brayan_moreno;

import processing.core.PApplet;

public class OrbeV extends Orbe {
	public OrbeV(PApplet app) {
		super(app);
		x = app.width / 2;
		y = app.height / 4;
	}

	@Override
	public void pintar() {
		app.fill(150, 0, 150, 90);
		app.ellipse(x, y, tam*5, tam*5);
	}
	public void mover() {
		
	}

}
