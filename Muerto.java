
public class Muerto implements Estado{
		private Vikingo v;
		
		
		public Muerto(Vikingo vv) {
			v = vv;
		}
		
		@Override
		public String toString() {
			return "Estado muerto";
		}

		@Override
		public void setVik(Vikingo v) {
			this.v = v;
		}
		
		@Override
		public void meditar() {
			System.out.println("¡El vikingo "+v.getNombre()+"está Muerto y no puede meditar!");
		}
		
		@Override
		public void atacar(Vikingo v) {
			System.out.println("¡El vikingo "+v.getNombre()+"está Muerto y no puede atacar!");
			
		}
		@Override
		public int recibeAtaque(int n) {
			System.out.println("¡El vikingo "+v.getNombre()+"está Muerto y no puede recibir ataques!");
			return 0;
		}
		
		
}
