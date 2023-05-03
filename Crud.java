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
	private static Scanner sc = new Scanner(System.in);
	private String text;
	public File arq;
	public static int idSelecionar;
	
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
	
	public File ReadCreature() throws FileNotFoundException {
		
		while (true) {
			System.out.print("\nDigite o ID da criatura: ");
			idSelecionar = sc.nextInt();
			arq = new File(String.format("%s/%d.txt", save.GetDir(), idSelecionar));
			if (arq.exists()){
				break;
			}
			else{
				System.out.println("ID inexistente, tente novamente.");
			}
		}
			
		Scanner sc = new Scanner(arq);
		String[] array = {"Creature ID: ", "HP: ", "MP: ", "Nome: ", "Tipo: ", "Ataques: "};
		int i = 0;
		while(sc.hasNextLine()) {
			System.out.print(array[i]);
			System.out.println(sc.nextLine());
			i++;
		}
		
		sc.close();
		return arq;
	}
	
	public void AlterCreature(int id, int valor, String newValue) throws IOException {
		
		List<String> lines = Files.readAllLines(arq.toPath(), StandardCharsets.UTF_8);
		lines.set(valor, newValue);
		Files.write(arq.toPath(), lines, StandardCharsets.UTF_8);
		
	}
	
	public void DeleteCreature(int id) throws IOException {
		arq = new File(String.format("%s\\%d.txt", save.GetDir(), id));
		if (arq.exists()) {
			arq.delete();
			System.out.println("Arquivo deletado com sucesso.");
		}
		else {
			System.out.println("ID incorreto ou inexistente.");
		}
	}
	
}
