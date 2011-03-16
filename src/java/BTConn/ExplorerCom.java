package java.BTConn;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 01.03.11
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
public class ExplorerCom extends LegoCon implements ICommandConst, ILegoCon {

    public ExplorerCom(String name, String adress){
        super(name, adress);
    }

    public int[] sweep(){
        int[] ret =  sendCommand(COMMAND_SWEEP, 0,0);
        int[] res = new int[4];

        for(int i =0; i < ret.length ; i++){
            if(ret[i] > -20 && ret[i] < 45){
                 res[0] = 1;
            }
            else if(ret[i] < 125){
                res[1] = 1;
            }
            else if(ret[i] < 225){
                res[2] = 1;
            }
            else if(ret[i] < 315){
                ret[3] = 1;
            }
            else if(ret[i] < 405){
                ret[0] = 1;
            }
        }

        return res;
    }

    public String travel(int dist, boolean checkColor){
        String colorAtStop = "";
        int ck = 0;

        if(checkColor){
            ck = 1;
        }

        int[] ret = sendCommand(COMMAND_TRAVEL, dist, ck);

        colorAtStop = getColor(ret[0]);

        return colorAtStop;
    }

    public boolean turn(int degrees){
         sendCommand(COMMAND_TURN, degrees, 0);
         return true;
    }

        private String getColor(int i) {
           switch(i) {
           case 0: return "RECOVER";
           case 1: return "BLACK";
           case 2: return "BLUE";
           case 3: return "GREEN";
           case 4: return "YELLOW";
           case 5: return "RED";
           case 6: return "WHITE";
           default: return  "WHITE";
           }
    }


}
