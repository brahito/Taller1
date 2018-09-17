package brayan_moreno;

import processing.core.PApplet;

public class Lluvia {
	PApplet app;
	float x, y, z, len, yVel;

	public Lluvia(PApplet app) {
		this.app = app;
		 x = app.random(app.width);
		 y = app.random(-500, -50);
		 z = app.random(0, 20);
		 len = Main.map(z, 0, 20, 10, 20);
		 yVel = Main.map(z, 0, 20, 4, 10);
	}

	public void caer() {
		y = y + yVel;
		float grav = Main.map(z, 0, 20, 0.01f, 0.1f);
		yVel = yVel + grav;

		if (y > app.height) {
			y = app.random(-200, -100);
			yVel = Main.map(z, 0, 20, 4, 10);
		}
	}

	public void agua() {
		float thick = Main.map(z, 0, 20, 1, 2);
		app.strokeWeight(thick);
		app.stroke(0, 43, 226);		
		app.line(x, y, x, y + len);
	}
}
