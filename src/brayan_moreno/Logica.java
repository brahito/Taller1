package brayan_moreno;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private ArrayList<Lluvia> lluvia;
	private Protagonista prota;
	private ArrayList<Nubes> nubes;
	private ArrayList<Orbe> orbes;
	private ArrayList<Arbol> arboles;
	private String[] palabras;
	private String[] guardarTexto;
	private OrbeV orbeV;
	private boolean est, pArb;
	private int orbes1, lluviaI, nubesI;
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
		lluviaI = 500;
		nubesI = 13;

//		cargarTxt();
		for (int i = 0; i < 500; i++) {
			lluvia.add(i, new Lluvia(app));
		}
		for (int i = 0; i < 13; i++) {
			nubes.add(i, new Nubes(app));
		}

	}

	public void pintar() {
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

		if (pArb == true)
			arbol.pintar();

		if (arbol.getTam() == 39) {
			for (int i = 0; i < 10; i++) {
				orbes.add(i, new OrbeA(app));
//				
			}
			for (int i = 0; i < 10; i++) {
				orbes.add(i, new OrbeR(app));
			}
		}

		for (int i = 0; i < orbes.size(); i++) {
			orbes.get(i).pintar();
			if (pArb == false) {
				orbes.get(i).mover();
			}else {
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
			nubes.get(i).pintar(i * 100);
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

}
