package View;

/**
 * 
 * 
 * @author André Heller
 */
import java.io.File;
import java.io.IOException;

public class MAIN {

	public static void main(String[] args) {
		String fileName = "Usuarios.json";
		File file = new File(fileName);

		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Arquivo " + fileName + " criado com sucesso.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}