package prRedSocialArray3;

public class RestriccionNombre implements TipoRestriccion {

	private char letra;

	public RestriccionNombre(char c) {
		letra = c;
	}

	@Override
	public boolean valida(Persona p) {
		if (p == null)
			throw new RedSocialException("Persona nula");
		else
			return p.getNombre().startsWith(String.valueOf(letra));
	}

}
