package Rat;

/**
 *
 * @author Ryan
 */
class Rat {
    
    public static boolean status = true;

    public String move(String move, String last) {
        String result = "";
        while(status != false){
            if(move.charAt(7) == 'p' && (!last.equals("up"))){
                result = move.substring(0,4) + "p" + move.substring(5,7) + "r" + move.substring(8,9);
            }else if(move.charAt(5) == 'p' && (!last.equals("left"))){
                result = move.substring(0,4) + "pr" + move.substring(6,9);
            }else if(move.charAt(1) == 'p' && (!last.equals("down"))){
                result = move.substring(0,1) + "r" + move.substring(2,4) + "p" + move.substring(5,9);
            }else if(move.charAt(3) == 'p' && (!last.equals("right"))){
                result = move.substring(0,3) + "rp" + move.substring(5,9);
            }else{
                for(int i = 0; i < 9; i++)
                    if(move.charAt(i) == 'p'){
                        status = false;
                        switch(i){
                            case(1):
                                result = move.substring(0,1) + "r" + move.substring(2,4) + "p" + move.substring(5,9);
                                break;
                            case(3):
                                result = move.substring(0,3) + "rp" + move.substring(5,9);
                                break;
                            case(5):
                                result = move.substring(0,4) + "pr" + move.substring(6,9);
                                break;
                            case(7):
                                result = move.substring(0,4) + "p" + move.substring(5,7) + "r" + move.substring(8,9);
                                break;
                        }
                    }
            }
            return result;
        }
        while(status != true){
            if(move.charAt(7) == 'p' && (!last.equals("up"))){
                result = move.substring(0,4) + "p" + move.substring(5,7) + "r" + move.substring(8,9);
            }else if(move.charAt(3) == 'p' && (!last.equals("right"))){
                result = move.substring(0,3) + "rp" + move.substring(5,9);
            }else if(move.charAt(1) == 'p' && (!last.equals("down"))){
                result = move.substring(0,1) + "r" + move.substring(2,4) + "p" + move.substring(5,9);
            }else if(move.charAt(5) == 'p' && (!last.equals("left"))){
                result = move.substring(0,4) + "pr" + move.substring(6,9);
            }else{
                for(int i = 0; i < 9; i++)
                    if(move.charAt(i) == 'p'){
                        status = true;                    
                        switch(i){
                            case(1):
                                result = move.substring(0,1) + "r" + move.substring(2,4) + "p" + move.substring(5,9);
                                break;
                            case(3):
                                result = move.substring(0,3) + "rp" + move.substring(5,9);
                                break;
                            case(5):
                                result = move.substring(0,4) + "pr" + move.substring(6,9);
                                break;
                            case(7):
                                result = move.substring(0,4) + "p" + move.substring(5,7) + "r" + move.substring(8,9);
                                break;
                        }
                    }
            }
            return result;
        }
        return null;
    }

    public String getLastplay(String play) {
        String last = new String();
        for(int i = 0; i < 9; i++)
            if(play.charAt(i) == 'r')
                switch(i){
                    case(1):
                        last = "up";
                        break;
                    case(3):
                        last = "left";
                        break;
                    case(5):
                        last = "right";
                        break;
                    case(7):
                        last = "down";
                        break;
               }
        return last;
    }

}
