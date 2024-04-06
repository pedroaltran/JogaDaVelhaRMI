import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JogoDaVelhaServidor {
	
    private static String ip = "localhost";
    private static String porta = "1099";
    private static String nomeServico = "JogoDaVelha";

    public static void main(String args[]) {
        JogoDaVelhaServidorInterface server;

        try {
            Registry registry = LocateRegistry.getRegistry(Integer.parseInt(porta));
            registry.list();
            String url = "rmi://" + ip + ":" + porta + "/" + nomeServico;
            server = new JogoDaVelhaServidorImplementacao();
            Naming.rebind(url, server);
        } catch (RemoteException e) {
            System.out.println("Remote Exception: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        }

    }

}