import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class JogoDaVelhaServidorImplementacao extends UnicastRemoteObject implements JogoDaVelhaServidorInterface {

    private int tabuleiro[][];
    private int numeroJogada;
    private Map<Integer, JogoDaVelhaClienteInterface> jogadores;
    private int idJogador;
    private Placar placar;

    private static final long serialVersionUID = 1L;


    protected JogoDaVelhaServidorImplementacao() throws RemoteException {
        super();
        placar = new Placar();
        jogadores = new HashMap<Integer, JogoDaVelhaClienteInterface>();
        idJogador = 0;

        tabuleiro = new int[3][3];
        numeroJogada = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = 9;
            }
        }
    }

    @Override
    public synchronized void logar(JogoDaVelhaClienteInterface cliente) throws RemoteException {
        if (idJogador < 2) {
            jogadores.put(idJogador, cliente);
            System.out.println("Server: jogador " + idJogador + " logado com sucesso.");
            cliente.setIdJogador(idJogador);
            cliente.getRespostaServidor("Logado com sucesso.");
            idJogador++;
            if (idJogador < 2) {
                cliente.getRespostaServidor("Aguardando o próximo jogador...");
            } else {
                for (int i = 0; i < 2; i++) {
                    jogadores.get(i).getRespostaServidor("Aguarde a jogada do outro jogador!");
                }
                atualizaPlacar();
                iniciarPartida();
            }
        } else {
            cliente.getRespostaServidor("Impossível logar: O servidor está lotado. ");
            cliente.setIdJogador(-1);
//            cliente.finalizarProcessoCliente();
        }

    }

    @Override
    public void jogar(int id, int linha, int coluna) throws RemoteException {
    	
    	if(jogadores.containsKey(id)) {
	    	if(linha < 0 || coluna < 0) {
	    		if(jogadores.size() > 1) {
		    		jogadores.get(Math.abs(1 - id)).getRespostaServidor("Voce venceu!");
		        	jogadores.get(Math.abs(1 - id)).finalizarJogo();
		        	JogoDaVelhaClienteInterface jogador = jogadores.get(id);
		        	jogadores.remove(id);
		        	
		        	
		        	resetaPartida();
		        	
		        	
		        	jogador.finalizarProcessoCliente();		        	
	    		}
	    		else {
//	    			jogadores.get(id).finalizarProcessoCliente();
	    			
	    			JogoDaVelhaClienteInterface jogador = jogadores.get(id);
		        	jogadores.remove(id);
		        	
		        	resetaPartida();
		        	
		        	jogador.finalizarProcessoCliente();

	    		}	
	    	}
    	}
    	else
    		throw new RemoteException();

        this.tabuleiro[linha][coluna] = id;
        numeroJogada++;
        if (numeroJogada >= 5) {
            boolean isVencedor = processarVencedor(id);
            if (isVencedor) {               
                jogadores.get(id).getRespostaServidor("Voce venceu!");
                jogadores.get(id).finalizarJogo();
                jogadores.get(Math.abs(1 - id)).getJogadaAdversario(id, linha, coluna);
                jogadores.get(Math.abs(1 - id)).getRespostaServidor("Voce perdeu!");
                jogadores.get(Math.abs(1 - id)).finalizarJogo();
                tocaMusica(id);
                placar.setIdVencedor(id);
				resetaPartida();
            } else {
                if (numeroJogada == 9) {
                    jogadores.get(id).getRespostaServidor("Deu Velha!");
                    jogadores.get(Math.abs(1 - id)).getJogadaAdversario(id, linha, coluna);
                    jogadores.get(Math.abs(1 - id)).getRespostaServidor("Deu vellha!");
                    tocaMusica(-1);
                    resetaPartida();

                } else {               
                    jogadores.get(id).getRespostaServidor("Aguarde a jogada do outro jogador!");
                    jogadores.get(Math.abs(1 - id)).getJogadaAdversario(id, linha, coluna);
                    jogadores.get(Math.abs(1 - id)).autorizarJogada(this);
                }
            }
        } else {        
            jogadores.get(id).getRespostaServidor("Aguarde a jogada do outro jogador!");
            jogadores.get(Math.abs(1 - id)).getJogadaAdversario(id, linha, coluna);
            jogadores.get(Math.abs(1 - id)).autorizarJogada(this);
        }
    }

    @Override
    public synchronized void deslogar(JogoDaVelhaClienteInterface cliente) throws RemoteException {
        

    }
    
    private void sortearPrimeiroJogador() {
        if (Math.random() < 0.5) {
            try {
                jogadores.get(0).autorizarJogada(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                jogadores.get(1).autorizarJogada(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void iniciarPartida() {
        sortearPrimeiroJogador();
    }
    
    private void tocaMusica(int idVencedor) {
    	Boolean vencedor;
    	
    	if(idVencedor >= 0) {
    		vencedor  = true;
    		try {
    			jogadores.get(idVencedor).tocaMusica(vencedor);
				jogadores.get(Math.abs(1 - idVencedor)).tocaMusica(!vencedor);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}
    	else {
    		vencedor = false;
    		try {
    			jogadores.get(0).tocaMusica(vencedor);
				jogadores.get(1).tocaMusica(vencedor);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}
    }
    
    private void atualizaPlacar() {
    	placar.atualizarPlacar();
    	String pontuacao = placar.toString();
    	try {
			jogadores.get(0).setPlacar(pontuacao);
			jogadores.get(1).setPlacar(pontuacao);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	
    }
    
    private void resetaPartida() {
    	numeroJogada = 0;
    	
    	for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = 9;
            }
        }
    	
    	if(jogadores.containsKey(0)) {
    		try {
    			jogadores.get(0).resetaTela();
    			jogadores.get(0).criarTela(0);
			} catch (RemoteException e) {}
    		
    	}
    	if(jogadores.containsKey(1)) {
	    	try {
	    		jogadores.get(1).resetaTela();
	    		jogadores.get(1).criarTela(1);
	    	}
	    	catch(Exception e) {}
    	}

    	if(jogadores.size() > 1) {
    		atualizaPlacar();
    		sortearPrimeiroJogador();
    	}
    	else {
    		placar.limpaPlacar();
    		if(jogadores.size() == 0)
    			idJogador = 0;
    		else {
    			idJogador = 1;
	    		if(jogadores.containsKey(1)) {
	    			JogoDaVelhaClienteInterface jogador = jogadores.get(1);
	    			jogadores.remove(1);
	    			try {
						jogador.setIdJogador(0);
						jogadores.put(0, jogador);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
	    		}
    		}	
    	}
    }

    private boolean processarVencedor(int idJogador) {
        boolean resultado = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] != idJogador) {
                    break;
                }
                if (j == 2) {
                    resultado = true;
                    System.out.println("Linhas Verificadas resultado = " + resultado);
                    return true;
                }
            }
            if (resultado) {
                break;
            }
        }
        System.out.println("Linhas Verificadas resultado = " + resultado);
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][j] != idJogador) {
                    break;
                }
                if (i == 2) {
                    resultado = true;
                    System.out.println("Colunas Verificadas resultado = " + resultado);
                    return true;
                }
            }
            if (resultado) {
                break;
            }
        }
        System.out.println("Colunas Verificadas resultado = " + resultado);
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][i] != idJogador) {
                break;
            }
            if (i == 2) {
                resultado = true;
                System.out.println("Diagonal Principal Verificada resultado = " + resultado);
                return true;
            }
        }
        System.out.println("Diagonal Principal Verificada resultado = " + resultado);

        for (int i = 2, j = 0; i >= 0; i--, j++) {
            if (tabuleiro[i][j] != idJogador) {
                break;
            }
            if (j == 2) {
                resultado = true;
                System.out.println("Diagonal Secundaria Verificada resultado = " + resultado);
                return true;
            }
        }
        System.out.println("Diagonal Secundaria Verificada resultado = " + resultado);
        System.out.println("__________________________________________________");
        return resultado;
    }
}