package brayan_moreno;

import processing.core.PApplet;

public class Arbol {
	private PApplet app;
	int x, y, tam, tam2;
	boolean crecer;

	public Arbol(PApplet app) {
		this.app = app;
		tam = 1;
		tam2 = 1;
		x = app.width / 2;
		y = app.height;
		crecer = true;
	}

	public void pintar() {
		app.fill(150, 100, 150);
		app.rect(x + app.width / 4, y - tam, tam - tam / 2, tam * 3);
		app.rect(x - app.width / 4, y - tam2, tam2 - tam2 / 2, tam2 * 3);
		app.fill(255, 0, 0, 90);
		app.ellipse((x - tam / 2) + app.width / 4, y - tam * 3, tam * 2, tam * 2);
		app.ellipse((x + tam / 2) + app.width / 4, y - tam * 3, tam * 2, tam * 2);
		app.ellipse(x + app.width / 4, y - tam * 4, tam * 2, tam * 2);
		app.fill(0, 0, 255, 90);
		app.ellipse((x - tam2 / 2) - app.width / 4, y - tam2 * 3, tam2 * 2, tam2 * 2);
		app.ellipse((x + tam2 / 2) - app.width / 4, y - tam2 * 3, tam2 * 2, tam2 * 2);
		app.ellipse(x - app.width / 4, y - tam2 * 4, tam2 * 2, tam2 * 2);
		if(crecer == true) {
		if (tam < 40)
			tam++;
		if (tam2 < 40)
			tam2++;
		}
		
	}
	public void centroR() {
		if(x!=app.width/4)
		x-=2;
	}
	public void centroA() {
		if(x<=app.width/1.35)
		x+=2;
	}
	public void setCrecer(boolean crecer) {
		this.crecer=crecer;
	}
	

	public void crecerR() {
		tam += 5;
		tam2 -= 5;
	}

	public void crecerA() {
		tam2 += 5;
		tam -= 5;
	}

	public int getTam() {
		return tam;
	}

	public int getTam2() {
		return tam2;
	}
}
