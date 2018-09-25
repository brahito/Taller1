package brayan_moreno;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private ArrayList<Lluvia> lluvia;
	private Protagonista prota;
	private ArrayList<Nubes> nubes;
	private ArrayList<Orbe> orbes;
	private String[] palabras;
	private String[] guardarTexto;
	private OrbeV orbeV;
	private boolean est, pArb, caminoR, caminoA, crearO;
	private int orbes1;
	private Arbol arbol;

	public Logica(PApplet app) {
		this.app = app;
		arbol = new Arbol(app);
		nubes = new ArrayList<Nubes>();
		lluvia = new ArrayList<Lluvia>();
		orbes = new ArrayList<Orbe>();
		prota = new Protagonista(app);
		orbeV = new OrbeV(app);
		palabras = app.loadStrings("melancholy.txt");
		dividirPalabras();
		est = true;
		pArb = false;
		orbes1 = 1;

		crearO = true;
		caminoA = false;
		caminoR = false;

//		cargarTxt();
		for (int i = 0; i < 500; i++) {
			lluvia.add(i, new Lluvia(app));
		}
		for (int i = 0; i < 10; i++) {
			nubes.add(i, new Nubes(app));
		}

	}

	public void pintar() {
		app.noStroke();

		if (orbeV.validar(prota)) {
			est = false;
			orbes1++;
		}
		if (prota.getOjos() == 4 && est == true) {
			orbeV.pintar();
		}
		if (orbes1 == 2) {
			orbes.add(new OrbeA(app, app.width / 2, app.height / 4));
			orbes.add(new OrbeR(app, app.width / 2, app.height / 4));
		}

		if (pArb == true) {
			arbol.pintar();

		}
		if (arbol.getTam() == 39) {
			for (int i = 0; i < 5; i++) {
				orbes.add(i, new OrbeA(app));
			}

			for (int i = 0; i < 5; i++) {
				orbes.add(i, new OrbeR(app));
			}

		}

		for (int i = 0; i < orbes.size() && pArb == true; i++) {
			if (orbes.get(i).validar(prota)) {
				arbol.setCrecer(false);
				if (orbes.get(i) instanceof OrbeA) {
					arbol.crecerA();
				}
				if (orbes.get(i) instanceof OrbeR) {
					arbol.crecerR();
				}
				orbes.remove(i);
			}
		}
		if (arbol.getTam() <= 0) {
			arbol.centroA();
			crearO = false;
			caminoA = true;

			orbes.removeAll(orbes);
		}
		if (arbol.getTam2() <= 0) {
			arbol.centroR();
			crearO = false;
			caminoR = true;
			orbes.removeAll(orbes);
		}
		for (int i = 0; i < orbes.size(); i++) {
			orbes.get(i).pintar();
			if (pArb == false) {
				orbes.get(i).mover();
			} else {
				orbes.get(i).moverTodos();
			}
			if (orbes.get(i).getY() > app.height + 150) {
				orbes.remove(i);
				pArb = true;
			}
		}

		prota.pintar();
		if (prota.getOjos() == 4) {
			prota.mover(app.mouseX, app.mouseY);
		}

		lluvia();
	}

	public void lluvia() {

		for (int i = 0; i < lluvia.size(); i++) {
			lluvia.get(i).agua();
			lluvia.get(i).caer();

		}

		for (int i = 0; i < nubes.size(); i++) {
			nubes.get(i).pintar(i * 130);

		}
	}

	public void dividirPalabras() {
		guardarTexto = PApplet.splitTokens(palabras[0]);

	}

	public void newTxt() {
		String temp = PApplet.join(guardarTexto, ' ');
		try {
			File archivo = new File("texto.txt");
			archivo.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			bw.write(temp);
			bw.flush();
			bw.close();

		} catch (Exception e) {

		}

	}

	public void clic() {
		if (prota.getOjos() < 4 && prota.validar(app.mouseX, app.mouseY)) {
			prota.agregarO();
		}

	}

	public void tecla() {
		if (pArb == true && prota.getX() < app.width / 2 && crearO == true && app.key == 'e') {
			orbes.add(new OrbeA(app, app.width / 2, (int) app.random(50, 300)));
		}
		if (pArb == true && prota.getX() > app.width / 2 && crearO == true && app.key == 'e') {
			orbes.add(new OrbeR(app, app.width / 2, (int) app.random(50, 300)));
		}
		if (app.key == 's' && caminoR == true) {
			if (nubes.size() > 1) {
				nubes.remove(1);
			} else {
				nubes.removeAll(nubes);
			}
			for (int i = 0; i < 50; i++) {
				if (lluvia.size() > 50) {
					lluvia.remove(i);
				} else {
					lluvia.removeAll(lluvia);
				}
			}

		}
	}
}
