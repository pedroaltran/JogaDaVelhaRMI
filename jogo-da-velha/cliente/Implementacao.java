import java.awt.Frame;
import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import javax.swing.JFrame;

public class JogoDaVelhaClienteImplementacao extends UnicastRemoteObject implements JogoDaVelhaClienteInterface {

    private int id;
    private TelaJogador tela;
    private JogoDaVelhaServidorInterface server;

    protected JogoDaVelhaClienteImplementacao() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void setIdJogador(int id) throws RemoteException {
        this.id = id;
        tela.setId(id);
    }

    @Override
    public void autorizarJogada(JogoDaVelhaServidorInterface servidor) throws RemoteException {
        tela.getCampoInstrucoes().setText("Faça sua jogada:");
        tela.habilitarBotoesJogador();

    }
    
    public void resetaTela() throws RemoteException {
    	tela.removeAll();
    	tela.revalidate();
    	tela.repaint();
    	tela.habilitarBotoesJogador();
    	tela.setVisible(false);
    }
    
    public void criarTela(int id) throws RemoteException{
    	tela = new TelaJogador();
    	tela.setServidor(this.server);
		tela.setId(id);
		tela.getCampoInstrucoes().setText("Aguarde...");
    }
    

    @Override
    public void finalizarJogo() throws RemoteException {
        tela.desabilitarBotoesJogador();

    }
    
    public void setPlacar(String placar) {
    	tela.setPlacar(placar);
    }
       
    public void setServidor(JogoDaVelhaServidorInterface server) throws RemoteException{
    	this.server = server;
    }
    
    public void tocaMusica(Boolean vencedor) throws RemoteException {
    	PlaySound.tocaMusica(vencedor);
    }

    
    @Override
    public void getRespostaServidor(String resposta) throws RemoteException {
        tela.getCampoInstrucoes().setText(resposta);
    }
    
    @Override
    public void getJogadaAdversario(int idAdversario, int linha, int coluna) throws RemoteException {
        tela.setJogadaAdversario(idAdversario, linha, coluna);
        tela.habilitarBotoesJogador();
    }
   
    @Override
    public void finalizarProcessoCliente() throws RemoteException {
        System.exit(1);
    }

    @Override
    public void setTelaJogador(TelaJogador tela) throws RemoteException {
        this.tela = tela;
    }

}