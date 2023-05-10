
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	
	private Scanner sc = new Scanner(System.in);
	private Crud crud = new Crud();
	private SaveC save = new SaveC();
	
	public void MenuPrincipal() throws IOException {
		System.out.print("\nBem-vindo ao RPGFinder\n\n"
						+ "1 - Criar nova criatura.\n"
						+ "2 - Alterar criatura.\n"
						+ "3 - Visualizar criatura.\n"
						+ "4 - Deletar criatura\n"
						+ "5 - Sair\n\n"
						+ "Digite a opção: ");
		
		while(true) {
			
			int escolha = sc.nextInt();
			
			switch(escolha) {
				case 1:
					Selecionar("Menu Criação", 1);
					break;
				case 2:
					Selecionar("Menu Alterar", 2);
					break;
				case 3:
					Selecionar("Menu Visualizar", 3);
					break;
				case 4:
					Selecionar("Menu Deletar", 4);
					break;
				case 5:
					System.exit(0);
				default:
					System.out.print("\nEscolha inválida, tente novamente.\n"
							+ "Digite um novo valor: ");
			}
		}
	}
	
	private void Selecionar(String titulo, int v) throws IOException {
		
		while(true) {
			
			System.out.print("\n"+ titulo + "\n"
					+ "1 - Continuar\n"
					+ "2 - Voltar\n"
					+ "Escolha a opção: ");
			
			int escolha = sc.nextInt();
			
			if (escolha == 1) {
				
				switch(v) {
					case 1:
						MenuCriar();
						break;
					case 2:
						MenuAlterar();
						break;
					case 3:
						MenuVisualizar();
						break;
					case 4:
						MenuDeletar();
						break;
				}
				
			}
			
			else if (escolha == 2) {
				MenuPrincipal();
			}
			
			else {
				System.out.println("Valor inválido, tente novamente.");
			}
		}
	}
	
	
	private void MenuCriar() throws IOException {
		
		int id, hp, mp, qtAtq;
		String nome, tipo;
		String[] ataques;
		
		while (true) {
			
			System.out.print("\nID: ");
			id = sc.nextInt();
			if(save.VerifyFileExist(id)) {
				System.out.printf("\nA criatura %d já existe no local %s, deseja substituir a criatura?"
								+ "\n1 - Sim"
								+ "\n2 - Não"
								+ "\nDigite a opção: ", id, save.GetDir());
				int substituirCriatura = sc.nextInt();
				if (substituirCriatura == 1) {
					break;
				}
				else if (substituirCriatura == 2) {
					System.out.println("\nDigite o ID novamente.");
				}
				else {
					System.out.println("Valor inválido, tente novamente.");
				}
			}
			else {
				break;
			}
		}
		
		System.out.print("\nHP: ");
		hp = sc.nextInt();
		
		System.out.print("MP: ");
		mp = sc.nextInt();
		
		System.out.print("Nome: ");
		sc.nextLine();
		nome = sc.nextLine();
		
		System.out.print("Tipo: ");
		tipo = sc.nextLine();
		
		System.out.print("Quantidade de ataques: ");
		qtAtq = sc.nextInt();
		ataques = new String[qtAtq];
		
		sc.nextLine();
		for (int i = 0; i < qtAtq; i++) {
			System.out.print("Nome do ataque " + (i+1) + ": ");
			ataques[i] = sc.nextLine();
		}
		
		crud.CreateCreature(id, hp, mp, nome, tipo, ataques);
		System.out.println("Criatura criada com sucesso.");
	}

	private void MenuAlterar() throws IOException {
		
		while(true) {
			System.out.print("\nID para alterar: ");
			int idAlterar = sc.nextInt();
			
			if(save.VerifyFileExist(idAlterar)) {;
					
				System.out.print("\nO que deseja alterar?\n"
						+ "1 - HP\n"
						+ "2 - MP\n"
						+ "3 - Nome\n"
						+ "4 - Tipo\n"
						+ "5 - Ataques\n"
						+ "Digite a opção: ");
				int opcaoAlterar = sc.nextInt();
				
				if(opcaoAlterar == 5) {
					crud.AlterAtaques(idAlterar, opcaoAlterar);
					break;
				}
				else {
					System.out.print("\nDigite a alteração: ");
					sc.nextLine();
					String newValue = sc.nextLine();
					
					crud.AlterCreature(idAlterar, opcaoAlterar, newValue);
					break;
				}
			}
			
			else {
				System.out.println("ID inexistente ou inválido, tente novamente.");
			}
			
		}
	}
	
	private void MenuVisualizar() throws FileNotFoundException {
		
		while(true) {
			System.out.print("\nID para visualizar: ");
			int idVisualizar = sc.nextInt();
			if(save.VerifyFileExist(idVisualizar)) {
				crud.ReadCreature(idVisualizar);
				break;
			}
			else {
				System.out.println("ID inexistente ou inválido, tente novamente.");
			}
		}
	}
	
	private void MenuDeletar() throws IOException {
		while(true) {
			System.out.print("\nID para deletar: ");
			int idDeletar = sc.nextInt();
			if(save.VerifyFileExist(idDeletar)) {
				crud.DeleteCreature(idDeletar);
				break;
			}
			else{
				System.out.println("ID inexistente ou inválido, tente novamente.");
			}
		}	
	}
	
}
