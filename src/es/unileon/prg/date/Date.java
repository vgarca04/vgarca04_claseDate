package es.unileon.prg.date;

import java.util.Calendar;
import java.util.Random;

public class Date {
	
	StringBuffer myBuffer = new StringBuffer();
	
	private int _year;
	private int _month;
	private int _day;
	
	public Date(int day, int month, int year) throws MyException{
		if(day < 1){
			myBuffer.append("Dia no valido, es negativo o 0: "+ day+"\n");
		}
		if(month < 1){
			myBuffer.append("Mes no valido, es negativo o 0: " + month+"\n");
		}else{
			if(month > 12){
				myBuffer.append("Mes no valido, solo hay 12 meses: " + month+"\n");
			}else{
				if(day > this.diasDelMes(day,month,year)){
					myBuffer.append("Dia del mes no valido, el mes no contiene el dia: " +day+"/"+ month+"\n");
				}
			}
		}
		if(year < 1){
			myBuffer.append("Año no valido, es negativo o 0: "+ year+"\n");
		}
		if(myBuffer.length() != 0){
			throw new MyException(myBuffer);
		}else{
			_year = year;
			_month = month;
			_day = day;
		}
		
	}
	
	public Date(Date fecha){
		this._year = fecha.getYear();
		this._month = fecha.getMonth();
		this._day = fecha.getDay();
	}
	
	int getYear(){
		return _year;
	}
	
	void setYear(int year) throws MyException{
		if(year < 1){
			myBuffer.append("Año no valido, es negativo o 0: "+ year+"\n");
		}
		if(myBuffer.length() != 0){
			throw new MyException(myBuffer);
		}else{
			this._year = year;
		}
	}
	
	int getMonth(){
		return _month;
	}
	
	void setMonth(int month) throws MyException{
		if(month < 1 || month >12){
			myBuffer.append("Mes no valido, los meses van de 1 a 12: " + month+"\n");
		}
		if(myBuffer.length() != 0){
			throw new MyException(myBuffer);
		}else{
			this._month = month;
		}	
	}
	
	int getDay(){
		return _day;
	}
	
	void setDay(int day) throws MyException{
		if(day < 1){
			myBuffer.append("Dia no valido, es negativo o 0: "+ day+"\n");
		}
		if(myBuffer.length() != 0){
			throw new MyException(myBuffer);
		}else{
			this._day = day;
		}	
	}
	
	boolean isSameYear(Date fecha){
		 return (this._year == fecha.getYear());
	}
	
	boolean isSameMonth(Date fecha){
		 return (this._month == fecha.getMonth());
	}

	boolean isSameDay(Date fecha){
		 return (this._day == fecha.getDay());
	}

	boolean isSame(Date fecha){
		 return (this._year == fecha.getYear() && this._month == fecha.getMonth() 
				 && this._day == fecha.getDay());
	}
	
	public String nombreMes(Date fecha){
		String nameMonth = "";
		switch(fecha.getMonth()){
		case 1: nameMonth = "Enero"; break;
		case 2: nameMonth = "Febrero"; break;
		case 3: nameMonth = "Marzo"; break;
		case 4: nameMonth = "Abril"; break;
		case 5: nameMonth = "Mayo"; break;
		case 6: nameMonth = "Junio"; break;
		case 7: nameMonth = "Julio"; break;
		case 8: nameMonth = "Agosto"; break;
		case 9: nameMonth = "Septiembre"; break;
		case 10: nameMonth = "Octubre"; break;
		case 11: nameMonth = "Noviembre"; break;
		case 12: nameMonth = "Diciembre"; break;
		}
		
		return nameMonth;
	}
	
	public int diasDelMes(int day, int month, int year) throws MyException{
		int dias=0;
		switch(month){
		case 1: 
		case 3:
		case 5:
		case 7: 
		case 8:
		case 10:
		case 12:
			dias = 31;
			break;
		case 2: 
			if(year%4 == 0 && year%100 != 0 && day<=29){
				dias = 29;
			}else if(day<=28){
				dias = 28;
			}
			break;
		case 4: 
		case 6: 
		case 9: 
		case 11: 
			dias = 30;
			break; 
		}
		return dias;
	}
	
	public String estacionAnyo(Date fecha){
		String estacion = "";
		switch(fecha.getMonth()){
		case 1: 
		case 2: 
			estacion = "Invierno"; break;
		case 3: 
			if(fecha.getDay()>=21){
				estacion = "Primavera";
			}else{
				estacion = "Invierno";
			}
			break;
		case 4: 
		case 5:
			estacion = "Primavera"; break;
		case 6: 
			if(fecha.getDay()>=21){
				estacion = "Verano";
			}else{
				estacion = "Primavera";
			}
			break;
		case 7: 
		case 8: 
			estacion = "Verano"; break;
		case 9: 
			if(fecha.getDay()>=23){
				estacion = "Otoño";
			}else{
				estacion = "Verano";
			}
			break;
		case 10: 
		case 11: 
			estacion = "Otoño"; break;
		case 12: 
			if(fecha.getDay()>=21){
				estacion = "Invierno";
			}else{
				estacion = "Otoño";
			}
			break;
		}
		
		return estacion;
	}
	
	public String mesesHastaFinalAnyo(Date fecha) throws MyException{
		Date aux = new Date(this);
		StringBuffer meses = new StringBuffer();
		for(int i=fecha.getMonth()+1; i<=12; i++){
			aux.setMonth(i);
			meses.append(fecha.nombreMes(aux)+ " ");	
		}
		return meses.toString();
		
	}
	
	public String toString() {
		StringBuffer salida = new StringBuffer();
		salida.append(_day + "/"+ _month +"/"+ _year);
		return salida.toString();	
	}
	
	public String diasHastaFinalMes(Date fecha) throws MyException{
		Date aux = new Date(this);
		StringBuffer dias = new StringBuffer();
		switch(fecha.getMonth()){
		case 1: 
		case 3:
		case 5:
		case 7: 
		case 8:
		case 10:
		case 12:
			for(int i=fecha.getDay(); i<=31; i++){
				aux.setDay(i);
				dias.append(i+ " ");	
			}
			break;
		case 2: 
			if(fecha.getYear()%4 == 0 && fecha.getYear()%100 != 0){
				for(int i=fecha.getDay(); i<=29; i++){
					aux.setDay(i);
					dias.append(i+ " ");	
				}
			}else{
				for(int i=fecha.getDay(); i<=28; i++){
					aux.setDay(i);
					dias.append(i+ " ");	
				}
			}
			break;
		case 4: 
		case 6: 
		case 9: 
		case 11: 
			for(int i=fecha.getDay(); i<=30; i++){
				aux.setDay(i);
				dias.append(i+ " ");	
			}
			break; 
		}
		
		return dias.toString();
		
	}
	
	public String mesesMismosDias(Date fecha) throws MyException{
		Date aux = new Date(this);
		StringBuffer meses = new StringBuffer();
		StringBuffer mesesDe31 = new StringBuffer();
		StringBuffer mesesDe30 = new StringBuffer();
		String aux2;
		for(int i=fecha.getMonth()+1; i<=12; i++){
			aux.setMonth(i);
			aux2 = aux.diasHastaFinalMes(aux).trim();
			if(aux2.charAt(aux2.length()-1) == '1'){
				mesesDe31.append(fecha.nombreMes(aux)+ " ");
			}else if(aux2.charAt(aux2.length()-1) == '0'){
				mesesDe30.append(fecha.nombreMes(aux)+ " ");
			}	
		}
		if(fecha.getMonth()==4 || fecha.getMonth()==6 || fecha.getMonth()==9 || 
				fecha.getMonth()==11){
			meses.append(mesesDe30);
		}else if(fecha.getMonth() == 2){
			meses.append("No hay ningun mes con los mismos dias que Febrero.");
		}else{
			meses.append(mesesDe31);
		}
		return meses.toString();
	}
	
	public long diasTranscurridos(Date fecha){
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(fecha.getYear(), 1, 1);
		cal2.set(fecha.getYear(), fecha.getMonth(), fecha.getDay());
		
		long milis1 = cal1.getTimeInMillis();
		long milis2 = cal2.getTimeInMillis();
		long diff = milis2 - milis1;
		
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;
		
	}
	
	public int intentosAdivinarFechaWhile(Date fecha) throws MyException{
		Date fecha2 = new Date(1,1,fecha.getDay());
		int contador = 0;
		Random aleatorio = new Random();
		while(fecha2.getDay() != fecha.getDay() || fecha2.getMonth() != fecha.getMonth()){
			fecha2.setDay((int)(aleatorio.nextDouble() * 31 + 1));
			fecha2.setMonth((int)(aleatorio.nextDouble() * 12 + 1));
			contador++;
		}
		return contador;
	}
	
	public int intentosAdivinarFechaDoWhile(Date fecha) throws MyException{
		Date fecha2 = new Date(1,1,fecha.getDay());
		int contador = 0;
		Random aleatorio = new Random();
		do{
			fecha2.setDay((int)(aleatorio.nextDouble() * 31 + 1));
			fecha2.setMonth((int)(aleatorio.nextDouble() * 12 + 1));
			contador++;
		}while(fecha2.getDay() != fecha.getDay() || fecha2.getMonth() != fecha.getMonth());
		return contador;
	}
}
