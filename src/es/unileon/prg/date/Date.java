package es.unileon.prg.date;

public class Date {
	
	private int _year;
	private int _month;
	private int _day;
	
	public Date(int day, int month, int year){
		_year = year;
		_month = month;
		_day = day;
	}
	
	int getYear(){
		return _year;
	}
	
	void setYear(int year){
		this._year = year;
	}
	
	int getMonth(){
		return _month;
	}
	
	void setMonth(int month){
		this._month = month;
	}
	
	int getDay(){
		return _day;
	}
	
	void setDay(int day){
		this._day = day;
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
		default: nameMonth = "Mes no valido"; break;
		}
		
		return nameMonth;
	}
	
	public boolean diaDelMesCorrecto(Date fecha){
		boolean diaCorrecto = false;
		switch(fecha.getMonth()){
		case 1: 
		case 3:
		case 5:
		case 7: 
		case 8:
		case 10:
		case 12:
			if(fecha.getDay()<=31){
				diaCorrecto = true;
			}
			break;
		case 2: 
			if(fecha.getYear()%4 == 0 && fecha.getYear()%100 != 0 && fecha.getDay()<=29){
				diaCorrecto = true;
			}else if(fecha.getDay()<=28){
				diaCorrecto = true;
			}
			break;
		case 4: 
		case 6: 
		case 9: 
		case 11: 
			if(fecha.getDay()<=30){
				diaCorrecto = true;
			}
			break; 
		}
		
		return diaCorrecto;
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
	
	public String mesesHastaFinalAnyo(Date fecha){
		Date aux = new Date(fecha.getDay(), fecha.getMonth(), fecha.getYear());
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
}
