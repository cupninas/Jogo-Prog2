package Jogo;

import Jogo.enums.TipoDificuldade;

public class Jogo {
    public static Log log = new Log();

    public static void main(String[] args) throws Exception {
        //iniciar jogo
        log.addLog("Jogo iniciado com dificuldade: " + TipoDificuldade.MEDIO.toString());
        Turno turno = new Turno(TipoDificuldade.MEDIO, 4, 3);
        log.clearLogs();
        turno.executarTurnos();
        log.showLogs();
    }
}