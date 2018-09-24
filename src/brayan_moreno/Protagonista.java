package brayan_moreno;

import processing.core.PApplet;

public class Protagonista {
	protected PApplet app;
	protected int x, y, tam, ojos;

	public Protagonista(PApplet app) {
		this.app = app;
		x = app.width / 2;
		y = (app.height / 2)+80;
		tam = 30;
		ojos = 0;
	}

	public void pintar() {

		app.fill(0);
		app.rectMode(PApplet.CENTER);
		app.rect(x, y, tam + 10, tam * 4, 90);

		for (int i = 1; i <= ojos; i++) {
			app.fill(255);
			app.quad(x - 10, (y - tam * i) + tam + 45, x, (y - tam * i - 10) + tam + 45, x + 10,
					(y - tam * i) + tam + 45, x, (y - tam * i + 10) + tam + 45);

			app.fill(0);

			app.ellipse(x, (y - tam * i) + tam + 45, tam / 5, tam / 5);
		}

	}
	public boolean validar(int mX,int mY) {
		if(PApplet.dist(mX, mY, x, y)<tam) {
			return true;
		}else {
			return false;
		}
	}

	public void agregarO() {
		if (app.mouseButton == PApplet.LEFT) {
			ojos++;
		}
	}

	

	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getOjos() {
		return ojos;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
