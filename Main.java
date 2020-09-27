
public class Main {
	public static void main(String args[]) {
		Vikingo vk1 = new Vikingo("Ragnar");
		Vikingo vk2 = new Vikingo("Bjorn");
		
		
		vk1.atacarVikingo(vk2);
		System.out.println(vk1);
		System.out.println(vk2);
		
		vk1.atacarVikingo(vk2);
		System.out.println(vk2);
		
		vk2.atacarVikingo(vk1);
		System.out.println(vk1);
		vk2.atacarVikingo(vk1);
		System.out.println(vk1);
		vk2.atacarVikingo(vk1);
		System.out.println(vk1);
	}
	
}
