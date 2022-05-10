package prRedSocialArray3;

public class RestriccionEdad implements TipoRestriccion {

	private int edadMinima;

	public RestriccionEdad(int e) {
		if (e < 0)
			throw new RedSocialException("Edad negativa");

		edadMinima = e;
	}

	@Override
	public boolean valida(Persona p) {
		return edadMinima < p.getEdad();
	}
}
