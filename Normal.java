
public class Normal implements Estado{
		private Vikingo v;
		
	public Normal( Vikingo v) {
		this.v = v;
	}

	
	@Override
	public String toString() {
		return "Estado Normal";
	}


	@Override
	public void meditar() {
		v.setEstado(new Calmado(v));
		System.out.println("El vikingo "+v.getNombre()+" en modo normal comienza a meditar, y pasa a estado CALMADO!");
	}

	@Override
	public void atacar(Vikingo vk) {
		vk.reciboAtaque(10);
	}

	@Override
	public int recibeAtaque(int n) {
		this.v.setEstado(new Colerico(v));
		System.out.println("¡El vikingo "+ v.getNombre()+" pasa a un estado colerico!");
		return n;
	}



	@Override
	public void setVik(Vikingo v) {
		this.v = v;
	}

}
