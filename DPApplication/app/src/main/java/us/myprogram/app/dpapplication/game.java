package us.myprogram.app.dpapplication;

/**
 * Created by Дмитрий ПРО on 29.04.2016.
 */
class game{
    private int N;
    public game(){

    }
    public game(int N){
        while(N>=3){
            N-=3;
        }
        this.N=N;
    }
    public static game kamen(){
        game t=new game();
        t.N=1;
        return t;
    }
    public static game bumaga(){
        game t=new game();
        t.N=2;
        return t;
    }
    public static game noschnizi(){
        game t=new game();
        t.N=0;
        return t;
    }
    public static int mensche(game g1,game g2){
        int N1=g1.N;
        int N2=g2.N;
        if((N1==0)||(N2==0)){
            if(N1==0){
                if(N2==2){
                    return -1;
                }
            }
            if(N2==0){
                if(N1==2){
                    return 1;
                }
            }
        }
        if(N2-N1==1){
            return 1;
        }
        if(N2==N1){
            return 0;
        }
        return -1;
    }
    public int getN(){
        return N;
    }
}
