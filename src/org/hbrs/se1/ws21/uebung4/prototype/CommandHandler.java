package org.hbrs.se1.ws21.uebung4.prototype;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class CommandHandler {
	
	public void startEingabe()  {

		String strInput = null;

		// Initialisierung der Kommandos
		HashMap<String, Command> commandsMap = new HashMap();
		commandsMap.put( "help" , new HelpCommand() );
		commandsMap.put(  "dump"  , new DumpCommand() );

		// Initialisierung des Eingabe-View
		Scanner scanner = new Scanner( System.in );
		
		while ( true ) {
			// Print the prompt
			System.out.print("> ");

			// Naechster Befehl
			strInput = scanner.nextLine();

			// KEINE IF-Anweisung oder Switch-Case-Statement mit N Zeilen
			// Anforderung: Auswahl des "Kommandos" in EINER Zeile
			// Verwendung des Command Pattern!
			Command command = commandsMap.get( strInput );
			command.execute();

			// Stack
			Stack<Command> stack = new Stack();
			stack.push(command);

			// Ergänzungen:
			stack.pop().undo();




		}

	}

}
