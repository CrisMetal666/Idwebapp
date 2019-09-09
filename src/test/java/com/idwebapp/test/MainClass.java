package com.idwebapp.test;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		ListaClass lst = new ListaClass();

		// contentra los servicios en comun
		List<Long> lstFinal = new ArrayList<>();

		/*
		 * variable que nos dira si la lista final no se ha inicializado la primera vez
		 */
		boolean init = false;

		for (int i = 0; i < 3; i++) {

			List<Long> idServicios = new ArrayList<>();

			if (i == 2) {
				idServicios = lst.getLista3();
			}
			if (i == 0) {
				idServicios = lst.getLista2();
			}
			if (i == 1) {
				idServicios = lst.getLista1();
			}
			
			System.out.println(i + "  --- " + idServicios.size());

			// inicializamos la lista una sola vez
			if (!init) {
				lstFinal = idServicios;
				init = true;
				continue;
			}

			// lista que contendra los id de los servicios en comun
			List<Long> listaComun = new ArrayList<>();

			/*
			 * recorremos la lista de los id de los servicios que se han ido guardando para
			 * compararlo con la lista actual para volver a encontrar los valores en comun
			 */
			for (Long idFinal : lstFinal) {

				for(Long idActual : idServicios) {
					
					System.out.println(idActual + "  -  " + idFinal);
					
					if(idFinal == idActual) {
						
						listaComun.add(idFinal);
						break;
					}
				}
			}

			lstFinal = listaComun;

		}
		
		System.out.println("--------- fin");
		for(Long id : lstFinal) {
			System.out.println(id);
		}

	}

}
