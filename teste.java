import java.io.IOException;

public class teste {
	
	private static Menu menu = new Menu();
	private static SaveC save = new SaveC();

	public static void main(String[] args) throws IOException {
		
		save.SetDir();
		menu.MenuPrincipal();
		
	}

}
