
public class Calmado implements Estado{
	private Vikingo v;
	
	public Calmado(Vikingo vv) {
		v = vv;
	}
	
	@Override
	public void meditar() {
		System.out.println("El vikingo "+v.getNombre()+" sigue meditando y continúa en estado calmado!");
		
	}

	@Override
	public void atacar(Vikingo vik) {
		
		v.setEstado(new Normal(v));
		vik.reciboAtaque(10);
	}

	@Override
	public String toString() {
		return "Estado calmado";
	}

	@Override
	public void setVik(Vikingo v) {
		this.v = v;
		
	}

	@Override
	public int recibeAtaque(int n) {
		System.out.println("¡¡No le causó daño al vikingo "+v.getNombre()+"!!");	
		return 0;
	}

}
