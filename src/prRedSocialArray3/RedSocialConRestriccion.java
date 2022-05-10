package prRedSocialArray3;

public class RedSocialConRestriccion extends RedSocial {

	private TipoRestriccion restriccion;

	public RedSocialConRestriccion(TipoRestriccion r) {
		restriccion = r;
	}

	@Override
	public void darAlta(Persona p) {
		if (p == null)
			throw new RedSocialException("Persona nula");
		else if (restriccion.valida(p))
			super.darAlta(p);
	}
}
