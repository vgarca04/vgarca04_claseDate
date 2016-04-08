package es.unileon.prg.date;

public class MyException extends Exception{

	StringBuffer _buffer;
	
	public MyException(StringBuffer buffer){
		_buffer = buffer;
	}
	
	public String toString() {
		StringBuffer salida = new StringBuffer();
		salida.append(_buffer);
		return salida.toString();	
	}
}

