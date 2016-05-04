package us.myprogram.dpbookofcook;

/**
 * Created by diman-pro on 03.05.16.
 */
public class Tex_System {
    public List<String> _data;
    public void parse(String str){
        boolean comand=false;
        String tmp="";
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='\\'){
                comand=true;
                continue;
            }
            if(comand==true){
                if((str.charAt(i)==' ')||(str.charAt(i)=='{')){
                    _data.add(tmp);
                    tmp="";
                    comand=false;
                    continue;
                }
            }
            tmp+=str.charAt(i);
        }
    }
}
