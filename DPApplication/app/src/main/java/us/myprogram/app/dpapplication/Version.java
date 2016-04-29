package us.myprogram.app.dpapplication;

/**
 * Created by Дмитрий ПРО on 22.04.2016.
 */
public class Version {
    //Номер версии
    private int _version;
    //Тип версии
    //0 - в разработке
    //1 - альфа тестирование
    //2 - бета тестирование
    //3 - готовое издание
    private int _type;
    //Номер публичного издания
    private int _numerPublicVersion;
    //Номер непубличного издания
    private int _numerPrivateVersion;
    public Version(int version, int type, int publics, int privates){
        if(version<1){
            throw new ExceptionInInitializerError("Некоректный параметр version");
        }
        this._version=version;
        if((type<0)||(type>3)){
            throw new ExceptionInInitializerError("Некоректный параметр type");
        }
        _type=type;
        if(publics<0){
            throw new ExceptionInInitializerError("Некоректный параметр publics");
        }
        _numerPublicVersion=publics;
        if(privates<0){
            throw new ExceptionInInitializerError("Некоректный параметр privates");
        }
        _numerPrivateVersion=privates;
    }
    @Override
    public String toString(){
        return Integer.toString(_version)+"."+Integer.toString(_type)+"."+Integer.toString(_numerPublicVersion)+"."+Integer.toString(_numerPrivateVersion);
    }
}
