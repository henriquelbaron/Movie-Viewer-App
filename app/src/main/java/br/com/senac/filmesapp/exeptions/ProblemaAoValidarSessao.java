package br.com.senac.filmesapp.exeptions;

public class ProblemaAoValidarSessao extends RuntimeException{

    public ProblemaAoValidarSessao (String msg){
        super(msg);
    }
}
