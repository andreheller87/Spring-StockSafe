package com.stocksafe.course.entities.enuns;

public enum UserNivel {
    CEO(1),
    GERENTE(2),
    FUNCIONARIO(3);
   

    private int nivel;

    UserNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
    
    public static UserNivel valueOf(int code) {
    	for(UserNivel value : UserNivel.values()) {
    		if(value.getNivel()== code) {
    			return value;
    		}
    	}
    	throw new IllegalArgumentException("Nivel Invalido");
    }
}
