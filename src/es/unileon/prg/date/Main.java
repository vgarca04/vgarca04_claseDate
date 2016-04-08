package es.unileon.prg.date;

public class Main {

	public static void main(String[] args) {
		try{
			Date fecha1 = new Date(30, 2, 2016);
			Date fecha2 = new Date(30, 12, 2017);
			
			System.out.println("Mes de la 1ª fecha: " + fecha1.nombreMes(fecha1));
			System.out.println("Mes de la 2ª fecha: " + fecha2.nombreMes(fecha2));
			System.out.println("Estacion de la primera fecha: " + fecha1.estacionAnyo(fecha1));
			System.out.println("Estacion de la segunda fecha: " + fecha2.estacionAnyo(fecha2));
			System.out.println("Meses hasta el final del año de la 1ª fecha: " +fecha1.mesesHastaFinalAnyo(fecha1));
			System.out.println("Meses hasta el final del año de la 2ª fecha: " +fecha2.mesesHastaFinalAnyo(fecha2));
			System.out.println("1ª fecha: "+ fecha1);
			System.out.println("2ª fecha: "+ fecha2);
			System.out.println("Dias hasta fin de mes de la 1ª fecha: " +fecha1.diasHastaFinalMes(fecha1));
			System.out.println("Dias hasta fin de mes de la 2ª fecha: " +fecha2.diasHastaFinalMes(fecha2));
			System.out.println("Meses con mismos dias que el mes de la 1ª fecha: " +fecha1.mesesMismosDias(fecha1));
			System.out.println("Meses con mismos dias que el mes de la 2ª fecha: " +fecha2.mesesMismosDias(fecha2));
			System.out.println("Dias desde el 1 de enero hasta la 1ª fecha: " +fecha1.diasTranscurridos(fecha1));
			System.out.println("Dias desde el 1 de enero hasta la 2ª fecha: " +fecha2.diasTranscurridos(fecha2));
			System.out.println("Intentos para adivinar 1ª fecha: "+ fecha1.intentosAdivinarFechaDoWhile(fecha1));
			System.out.println("Intentos para adivinar 2ª fecha: "+ fecha2.intentosAdivinarFechaDoWhile(fecha2));
		}catch(MyException except){
			System.err.println(except.toString());
		}
		
	}

}
