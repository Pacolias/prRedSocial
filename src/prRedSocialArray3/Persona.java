package prRedSocialArray3;

public class Persona {

	private String nombre;
	private int edad;
	private String email;

	public Persona(String n, int e, String em) {
		if (n == null || em == null || e < 0)
			throw new RedSocialException("Parametros de entrada erroneos");

		nombre = n;
		edad = e;
		email = em;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return nombre + " " + edad + " (" + email + ")";
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Persona) {
			Persona p = (Persona) o;
			res = p.nombre.equalsIgnoreCase(this.nombre) && p.email.equals(this.email);
		}

		return res;
	}

	@Override
	public int hashCode() {
		return nombre.toUpperCase().hashCode() + email.hashCode();
	}

}
