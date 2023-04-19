import java.io.IOException;
import java.util.Arrays;

public class Crud {
	
	private SaveC save = new SaveC();
	private Creatures criatura;
	private String text;
	
	public void CreateCreature(int id, int hp, int mp, String nome, String tipo, String[] ataques) throws IOException {
		criatura = new Creatures(id, hp, mp, nome, tipo, ataques);
		text = String.format("Creature ID: %d\n"
							+ "HP: %d\n"
							+ "MP: %d\n"
							+ "Nome: %s\n"
							+ "Tipo: %s\n"
							+ "Ataques: %s\n", 
							id, hp, mp, nome, tipo, Arrays.toString(ataques));
		save.SetDir();
		save.SaveFile(id, text);
	}
	
}
