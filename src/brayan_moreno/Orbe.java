package brayan_moreno;

import processing.core.PApplet;

public abstract class Orbe implements Comparable<Orbe> {
	PApplet app;
	protected int x, y, tam, color, vel, sec,milSec;

	public Orbe(PApplet app) {
		this.app = app;
		tam = 40;
		vel = (int) ((int) 3 + (Math.random() * 10));
		milSec = app.frameCount;
	}

	public abstract void pintar();

	public abstract void mover();

	public void moverTodos() {
		
		if (app.frameCount % 30==0) {
			sec++;
		}

		if (sec < 2 && x < app.width/2 )
			x += vel;
		if (sec < 2 && x > app.width/2)
			x -= vel;
		
	}
	public int compareTo(Orbe o) {
		return color-o.color;
	}

	public boolean validar(Protagonista p) {
		if (PApplet.dist(p.getX(), p.getY(), x, y) < tam) {
			return true;
		} else {
			return false;
		}
	}

	public int getY() {
return y;
	}
}
