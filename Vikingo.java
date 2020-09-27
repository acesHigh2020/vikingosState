
public class Vikingo {       
	private int vida;
	private Estado estado;    ///El estado en su interior va a referenciar al vikingo que tiene ese estado
	private String nombre;
		
	public Vikingo(String n){
		nombre = n;
		vida = 100;
		estado = new Normal(this);
	}
	
	@Override
	public String toString() {
		return "\n\nVikingo:"+nombre+"\nEstado:"+estado.toString()+"\nVida restante: "+vida;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void atacarVikingo(Vikingo v) {
		estado.atacar(v);
	}
	
	public void reciboAtaque(int n) {
			int nAttack=this.estado.recibeAtaque(n);
			if(nAttack>vida)
				{this.setEstado(new Muerto(this));
			System.out.println("El vikingo esta muerto!!!");
				vida = 0;
				return;
				}
 			if(nAttack>0)
			restarVida(nAttack);
		}
		
	private void restarVida(int n) {
		this.vida-=n;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setEstado(Estado s) {
		this.estado = s;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	public void meditacion() {
		estado.meditar();
	}
	
}
