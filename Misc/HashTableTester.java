import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class HashTableTester {

	enum Operation {
		PUT	{ void eval(HashTable table, int key, int value) { table.put(new Integer(key), new Integer(value)); } },
		GET	{ void eval(HashTable table, int key, int value) { table.get(new Integer(key)); } },
		SIZE	{ void eval(HashTable table, int key, int value) { table.size(); } },
		OUT	{ void eval(HashTable table, int key, int value) { table.output(); } };
		abstract void eval(HashTable table, int key, int value);
	}

	public static void readFile(BufferedReader in) {
		HashTable table = new HashTable(50);
		String line;
		try {
			while ((line = in.readLine()) != null) {
				String[] splitLine = line.split("\t");
				
				if (splitLine.length > 3) {
					System.err.println("Too many arguments");
				}
				String command = splitLine[0].toUpperCase();
				int key = -1; int value = -1;
				if (splitLine.length > 2 ) {
					key = Integer.parseInt(splitLine[1]);
					value = Integer.parseInt(splitLine[2]);
				}
				Operation op = null;
				try {
					op = Enum.valueOf(Operation.class, command);
				} catch (IllegalArgumentException e) {
					System.err.println("Unknown command");
					continue;
				}
				op.eval(table, key,value);

			}
		} catch (IOException e) {
			return;
		}
	}

	public static void usage(String message) {
		if (message != null) {
			System.out.println(message);
		}
		System.out.println(
			"Usage: java HashTableTester [--file=filename] ");
		System.exit(1);
	}

	public static void main(String[] args) {
		BufferedReader file = null;
		boolean random = false;
		String filename = "C:\\Users\\IBM_ADMIN\\repos\\2015\\assignments\\a3\\provided_a03\\provided_a03\\input1.txt";
			try {
				file = new BufferedReader(new InputStreamReader(
						new DataInputStream(new FileInputStream(filename))));
			} catch (IOException e){
				usage("Could not open file " + filename);
			}

		if (file != null) {
			readFile(file);
		}
		
	}



}
