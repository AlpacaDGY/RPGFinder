
import java.util.Arrays;

public class Creatures {
	private int id, hp, mp;
	private String nome, tipo;
	private String[] ataques;
	
	public Creatures(int id, int hp, int mp, String nome, String tipo, String[] ataques) {
		SetID(id);
		SetHP(hp);
		SetMP(mp);
		SetNome(nome);
		SetTipo(tipo);
		SetAtaques(ataques);
	}
	
	//Getters
	
	public int GetID() {
		return id;
	}

	public int GetHP() {
		return hp;
	}
	
	public int GetMP() {
		return mp;
	}
	
	public String GetNome() {
		return nome;
	}
	
	public String GetTipo() {
		return tipo;
	}
	
	public String GetAtaques() {
		return Arrays.toString(ataques);
	}
	
	//Setters
	
	private void SetID(int id) {
		if (id >= 0 & id <= 1000) {
			this.id = id;
		}
		else {
			System.out.println("Valor de ID fora de range[0,1000] - Tente novamente com um valor válido.");
		}
	}
	
	private void SetHP(int hp) {
		this.hp = hp;
	}
	
	private void SetMP(int mp) {
		this.mp = mp;
	}
	
	private void SetNome(String nome) {
		this.nome = nome;
	}
	
	private void SetTipo(String tipo) {
		this.tipo = tipo;
	}
	
	private void SetAtaques(String[] ataques) {
		this.ataques = ataques;
	}

}
