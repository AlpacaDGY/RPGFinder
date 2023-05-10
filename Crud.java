import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crud {
	
	private SaveC save = new SaveC();
	private String text;
	public static File arq;
	
	public void CreateCreature(int id, int hp, int mp, String nome, String tipo, String[] ataques) throws IOException {
		text = String.format("%d\n"
							+ "%d\n"
							+ "%d\n"
							+ "%s\n"
							+ "%s\n"
							+ "%s", 
							id, hp, mp, nome, tipo, Arrays.toString(ataques));
		save.SaveFile(id, text);
	}
	
	public void ReadCreature(int id) throws FileNotFoundException {
			
		Scanner sc = new Scanner(arq);
		String[] array = {"Creature ID: ", "HP: ", "MP: ", "Nome: ", "Tipo: ", "Ataques: "};
		int i = 0;
		System.out.println("\n");
		while(sc.hasNextLine()) {
			System.out.print(array[i]);
			System.out.println(sc.nextLine());
			i++;
		}
		sc.close();
	}
	
	public void AlterCreature(int id, int valor, String newValue) throws IOException {
		
		List<String> lines = Files.readAllLines(arq.toPath(), StandardCharsets.UTF_8);
		lines.set(valor, newValue);
		Files.write(arq.toPath(), lines, StandardCharsets.UTF_8);
		
	}
	
	public void AlterAtaques(int id, int valor) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		List<String> lines = Files.readAllLines(arq.toPath(), StandardCharsets.UTF_8);
		String ataques = lines.get(5).replace('[', ' ').replace(']', ' ').strip();
		String[] lista_ataques = ataques.split(", ");

		for(int i = 0; i < lista_ataques.length; i++) {
			System.out.printf("\n%d - %s", i+1, lista_ataques[i]);
		}
		
		System.out.print("\nQual ataque deseja mudar: ");
		int valorTrocar = sc.nextInt();
		
		System.out.print("\nNovo nome do ataque: ");
		sc.nextLine();
		String ataqueTrocar = sc.nextLine();
		
		lista_ataques[valorTrocar-1] = ataqueTrocar;

		lines.set(5, Arrays.toString(lista_ataques));
		Files.write(arq.toPath(), lines, StandardCharsets.UTF_8);
	}
	
	public void DeleteCreature(int id) throws IOException {
		arq = new File(String.format("%s\\%d.txt", save.GetDir(), id));
		arq.delete();

	}
	
}
