
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class SaveC extends JPanel  {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JFileChooser escolhaDir;
	private String escolhaTitulo = "Escolher diretorio";
	
	private static File dir;
	
	private FileWriter arquivo;
	private PrintWriter escreverArquivo;
	
	public void WindowOpener() {
		escolhaDir = new JFileChooser();
		escolhaDir.setCurrentDirectory(new java.io.File("C:\\"));
		escolhaDir.setDialogTitle(escolhaTitulo);
		escolhaDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		escolhaDir.setAcceptAllFileFilterUsed(false);
		
		if (escolhaDir.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			dir = escolhaDir.getSelectedFile();
		}
	}
	
	public void SaveFile(int id, String text) throws IOException {
		arquivo = new FileWriter(dir + String.format("/%d.txt", id));
		escreverArquivo = new PrintWriter(arquivo);
		escreverArquivo.printf(text);
		arquivo.close();
	}
	
	public File GetDir() {
		return dir;
	}
	
	public void SetDir() {
		if (dir == null) {
			WindowOpener();
		}
	}
	
	
}
