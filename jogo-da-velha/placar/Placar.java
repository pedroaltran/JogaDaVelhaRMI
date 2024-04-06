import java.util.HashMap;

public class Placar {

	private int idVencedor = -1;
	private HashMap<Integer, Integer> placar;
	
	public Placar() {
		placar = new HashMap<>();
		placar.put(0, 0);
		placar.put(1, 0);
	}

	public int getIdVencedor() {
		return idVencedor;
	}

	public void setIdVencedor(int idVencedor) {
		this.idVencedor = idVencedor;
	}

	public HashMap<Integer, Integer> getPlacar() {
		return placar;
	}

	public void setPlacar(HashMap<Integer, Integer> placar) {
		this.placar = placar;
	}
	
	public String toString() {
		return "O - "+ placar.get(0) + "x" + placar.get(1) + " - X";
	}
	
	public void atualizarPlacar() {
		if(idVencedor >=0) {
			int valor = placar.get(idVencedor);
			placar.put(idVencedor, ++valor);
			idVencedor = -1;
		}	
	}
	
	public void limpaPlacar() {
		placar.clear();
		placar.put(0, 0);
		placar.put(1, 0);
	}
}