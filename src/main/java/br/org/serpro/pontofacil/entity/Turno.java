package br.org.serpro.pontofacil.entity;

public enum Turno {
	HR_ENT_1_TURNO(0, "horario de entrada do 1 turno"),
	HR_SAI_1_TURNO(1, "horario de saíida do 1 turno"),
	HR_ENT_2_TURNO(2, "horario de entrada do 2 turno"),
	HR_SAI_2_TURNO(3, "horario de saída do 2 turno"),
	HR_ENT_1_TURNO_E(4, "horario de entrada do 1 turno extra"),
	HR_SAI_1_TURNO_E(5, "horario de saída do 1 turno extra"),
	HR_ENT_2_TURNO_E(6, "horario de entrada do 2 turno extra"),
	HR_SAI_2_TURNO_E(7, "horario de saída do 2 turno extra");
	
	private int numero;
	private String literal;
	
    Turno(final int numero, final String literal) {
        this.numero = numero;
        this.literal = literal;
    }

    public String getLiteral(){
    	return literal;    	
    }
    
    public int getNumero() {
		return numero;
	}
    
    public static Turno parse(String aTurno){
    	Turno turno = null;
    	
    	if(aTurno.equals("HR_ENT_1_TURNO")){
    		
    		turno = Turno.HR_ENT_1_TURNO;
    		
    	} else if(aTurno.equals("HR_SAI_1_TURNO")){
    		
    		turno = Turno.HR_SAI_1_TURNO;
    		
    	} else if(aTurno.equals("HR_ENT_2_TURNO")){
    		
    		turno = Turno.HR_ENT_2_TURNO;
    		
    	} else if(aTurno.equals("HR_SAI_2_TURNO")){
    		
    		turno = Turno.HR_SAI_2_TURNO;
    		
    	} else if(aTurno.equals("HR_ENT_1_TURNO_E")){
    		
    		turno = Turno.HR_ENT_1_TURNO_E;
    		
    	} else if(aTurno.equals("HR_SAI_1_TURNO_E")){
    		
    		turno = Turno.HR_SAI_1_TURNO_E;
    		
    	} else if(aTurno.equals("HR_ENT_2_TURNO_E")){
    		
    		turno = Turno.HR_ENT_2_TURNO_E;
    		
    	} else if(aTurno.equals("HR_SAI_2_TURNO_E")){
    		
    		turno = Turno.HR_SAI_2_TURNO_E;
    		
    	}
    	
    	
		return turno;
    }

}
