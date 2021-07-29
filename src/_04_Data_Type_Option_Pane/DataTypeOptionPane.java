package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
	enum DataType {
		BYTE(8), SHORT(16), INT(32), LONG(64), FLOAT(32), DOUBLE(64), BOOLEAN(1), CHAR(16);
		
		private final int bits;
		
		private DataType(int bits) {
			this.bits = bits;
		}
		public int getBits() {
			return bits;
		}
	}
    public static void main(String[] args) {

        DataType[] dataTypes = DataType.values();
        int option = JOptionPane.showOptionDialog(null, "Choose a Data Type", "Data Types", 0, 3, null, dataTypes, dataTypes);
        switch(option) {
        	case 0: {
        		System.out.println("Bytes can contain a minimum value of -128 and a maximum of 127.");
        		break;
        	}
        	case 1: {
        		System.out.println("Shorts can contain a minimum value of -32,768 and a maximum value of 32,767.");
        		break;
        	}
        	case 2: {
        		System.out.println("Ints can contain a minimum value of -2^31 and a maximum value of 2^31-1.");
        		break;
        	}
        	case 3: {
        		System.out.println("Longs can contain a minimum value of -2^63 and a maximum value of 2^63-1.");
        		break;
        	}
        	case 4: {
        		System.out.println("Floats can contain a minimum value of " + Float.MIN_VALUE + " and a maximum value of " + Float.MAX_VALUE + ".");
        		break;
        	}
        	case 5: {
        		System.out.println("Doubles can contain a minimum value of " + Double.MIN_VALUE + " and a maximum value of " + Double.MAX_VALUE + ".");
        		break;
        	}
        	case 6: {
        		System.out.println("Booleans only have two possible values, TRUE and FALSE.");
        		break;
        	}
        	case 7: {
        		System.out.println("Chars have a minimum value of '\\u0000' (or 0) and a maximum value of '\\uffff' (or 65,535 inclusive).");
        		break;
        	}
        }
        System.out.println(dataTypes[option] + " contains " + dataTypes[option].getBits() + " bits.");
    }
}
