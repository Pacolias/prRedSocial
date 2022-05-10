package Pruebas;

import java.io.IOException;

import prRedSocialArray3.RedSocial;
import prRedSocialArray3.TipoRestriccion;
import prRedSocialArray3.RestriccionNombre;
import prRedSocialArray3.RestriccionEdad;
import prRedSocialArray3.RedSocialConRestriccion;
import prRedSocialArray3.RedSocialException;

public class TestRedSocial {

	public static void main(String[] args) throws IOException {
		try {
			RedSocial red = new RedSocial();
			red.darAlta("redsocial.txt");
			System.out.println(red.toString());

			int apartadoElegido = 7;

			TipoRestriccion rest = null;

			if (apartadoElegido == 7) {
				rest = new RestriccionNombre('M');
			} else {
				rest = new RestriccionEdad(22);
			}

			RedSocialConRestriccion redRestringida = new RedSocialConRestriccion(rest);
			redRestringida.darAlta("redSocial.txt");
			System.out.println(redRestringida);
		} catch (RedSocialException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
