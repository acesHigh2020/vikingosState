
public class Berserker implements Estado{
	private Vikingo v;
	
	public Berserker(Vikingo vv) {
		v = vv;
	}
	
	
	@Override
	public void meditar() {
		v.setEstado(new Normal(v));
		System.out.println("El vikingo "+v.getNombre() +" en modo Berserker comienza a meditar, y pasa a estado normal!");
		
	}

	@Override
	public String toString() {
		return "Estado Berserker";
	}


	@Override
	public void atacar(Vikingo vk) {
		vk.reciboAtaque(30);
		
	}


	@Override
	public void setVik(Vikingo v) {
		this.v = v;
	}


	@Override
	public int recibeAtaque(int n) {
		return n/2;
	}

}
