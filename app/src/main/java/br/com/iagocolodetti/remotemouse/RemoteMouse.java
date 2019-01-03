package br.com.iagocolodetti.remotemouse;

import lipermi.handler.CallHandler;
import lipermi.net.Client;

public class RemoteMouse {

    private Client client;
    private IMouse mouse;

    public RemoteMouse(String ip, int port) throws Exception {
        try {
            CallHandler callHandler = new CallHandler();
            client = new Client(ip, port, callHandler);
            mouse = (IMouse) client.getGlobal(IMouse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Não foi possível realizar a conexão. Verifique se o servidor está aberto e se o ip e a porta estão corretos.");
        }
    }

    public void close() {
        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client = null;
        }
    }

    public boolean isClosed() {
        return client == null;
    }

    public void click(int button) throws Exception {
        try {
            mouse.click(button);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Não foi possível realizar a ação.");
        }
    }

    public void cursor(int move, int direction) throws Exception {
        try {
            mouse.cursor(move, direction);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Não foi possível realizar a ação.");
        }
    }

    public void scroll(int direction) throws Exception {
        try {
            mouse.scroll(direction);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Não foi possível realizar a ação.");
        }
    }
}
