
public class Colerico implements Estado{
	private Vikingo v;
	
	public Colerico(Vikingo vv) {
		v = vv;
	}
	
	@Override
	public void meditar() {
		v.setEstado(new Normal(v));
		System.out.println("El vikingo "+v.getNombre()+" en modo Colerico comienza a meditar, y pasa a estado normal!");
		
	}
	
	@Override
	public void atacar(Vikingo vk) {
		vk.reciboAtaque(20);

	}

	@Override
	public void setVik(Vikingo v) {
		this.v = v;
		
	}

	@Override
	public int recibeAtaque(int n) {
		
		this.v.setEstado(new Berserker(v));
		System.out.println("¡¡¡El Vikingo "+v.getNombre()+" pasa a estado Berserker!!!");
		return n*2;
	}

	@Override
	public String toString() {
		return "Estado colerico";
	}

}
