import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JogoDaVelhaServidorInterface extends Remote {

    public void logar(JogoDaVelhaClienteInterface cliente) throws RemoteException;

    public void jogar(int id, int linha, int coluna) throws RemoteException;

    public void deslogar(JogoDaVelhaClienteInterface cliente) throws RemoteException;

}