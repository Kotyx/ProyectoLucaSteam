package controller;

import gui.Gui;

public class LucaSteam {

	
	public static void gestion() {
		System.out.println("PLATAFORMA LUCASTEAM: MENU PRINCIPAL");
		boolean seguir=true;
		while(seguir) {
			seguir=Gui.menu();
		}
	}
}
