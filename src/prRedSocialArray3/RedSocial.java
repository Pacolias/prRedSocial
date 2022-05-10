package prRedSocialArray3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RedSocial {

	private ArrayList<Persona> personas;

	public RedSocial() {
		personas = new ArrayList<>();
	}

	private int buscar(Persona p) {
		return personas.indexOf(p);
	}

	public void darAlta(Persona p) {
		if (p == null)
			throw new RedSocialException("Persona nula");
		else if (buscar(p) == -1)
			personas.add(p);

	}

	public void darAlta(String entrada) {

		Path entry = Path.of(entrada);
		
		try (Scanner sc = new Scanner(entry)) {
			sc.useDelimiter("\\s*[%]+\\s*");
			sc.useLocale(Locale.ENGLISH);

			while (sc.hasNextLine()) {
				procesarLinea(sc.nextLine());
			}
		} catch (InputMismatchException e) {
			throw new RedSocialException("Datos de entrada erroneos");
		} catch (NoSuchElementException e) {
			throw new RedSocialException("Datos de entrada insuficientes");
		} catch (IOException e) {
			throw new RedSocialException();
		}
	}
	
	private void procesarLinea(String linea)
	{
		try (Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("\\s*[%]+\\s*");
			sc.useLocale(Locale.ENGLISH);

			darAlta(new Persona(sc.next(), sc.nextInt(), sc.next()));
	
		} catch (InputMismatchException e) {
			throw new RedSocialException("Datos de entrada erroneos");
		} catch (NoSuchElementException e) {
			throw new RedSocialException("Datos de entrada insuficientes");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < personas.size(); i++) {
			sb.append(personas.get(i).toString());

			if (i < personas.size() - 1)
				sb.append("\n");
		}

		return sb.toString();
	}
}
