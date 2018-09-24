package brayan_moreno;

import processing.core.PApplet;

public class OrbeR extends Orbe {

	public OrbeR(PApplet app) {
		super(app);
		x = (int) app.random(app.width+50,app.width+100);
		y = (int) app.random(-25,app.height+25);

	}
	public OrbeR(PApplet app, int x, int y) {
		super(app);
		this.x = x;
		this.y = y;
	}

	@Override
	public void pintar() {
		app.fill(255, 0, 0, 90);
		app.ellipse(x, y, tam, tam);
		
	}
	public void mover() {
		x+=3;
		y+=5.5;
	}

}
