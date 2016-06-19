package com.rzd.pktb.StatGamer;

import com.rzd.pktb.SPSGame.gameSPS;
import com.rzd.pktb.SPSGame.playerSPS;

/**
 * Created by SimpleUser on 18.06.2016.
 */
public class statisticsGamer implements playerSPS {
    //счетчики ходов противника
    private int enemyPaper;
    private int enemyStone;
    private int enemyScissors;

    public statisticsGamer(){
        enemyPaper = 0;
        enemyStone = 0;
        enemyScissors = 0;
    }

    @Override
    public int fight() {
        //делаем ход против наиболее вероятного хода противника (тот, которым он ходил меньше всего)
        if (enemyPaper < enemyStone && enemyPaper < enemyScissors) return gameSPS.SCISSORS;
        else if (enemyStone < enemyPaper && enemyStone < enemyScissors) return gameSPS.PAPER;
        else if (enemyScissors < enemyStone && enemyScissors < enemyPaper) return gameSPS.STONE;
        else return 0;
    }

    @Override
    public void result(int result, int enemyStep) {
        if (enemyStep==gameSPS.PAPER) enemyPaper++;
        if (enemyStep==gameSPS.STONE) enemyStone++;
        if (enemyStep==gameSPS.SCISSORS) enemyScissors++;
    }

    @Override
    public String about() {
        return "Игрок, делающий ход на основе статистики ходов противника";
    }
}
