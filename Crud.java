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
	
	public void CreateCreature(int id, int hp, int mp, String nome, String tipo, String[] ataques) throws IOException {
		text = String.format("%d\n"
							+ "%d\n"
							+ "%d\n"
							+ "%s\n"
							+ "%s\n"
							+ "%s", 
							id, hp, mp, nome, tipo, Arrays.toString(ataques));
		save.SetDir();
		save.SaveFile(id, text);
	}
	
	public File ReadCreature(int id) throws FileNotFoundException {
		save.SetDir();
		File arq = new File(String.format("%s/%d.txt", save.GetDir(), id));
		
		try {
			Scanner sc = new Scanner(arq);
			String[] array = {"Creature ID: ", "HP: ", "MP: ", "Nome: ", "Tipo: ", "Ataques: "};
			int i = 0;
			while(sc.hasNextLine()) {
				System.out.print(array[i]);
				System.out.println(sc.nextLine());
				i++;
			}
		}
		catch(Exception e) {
			System.out.println("ID inexistente ou não encontrado, tente novamente");
		}
		
		return arq;
	}
	
	public void AlterCreature(int id, int valor, String newValue) throws IOException {
		
		File arq = ReadCreature(id);
		
		List<String> lines = Files.readAllLines(arq.toPath(), StandardCharsets.UTF_8);
		lines.set(valor, newValue);
		Files.write(arq.toPath(), lines, StandardCharsets.UTF_8);
		
	}
	
}
