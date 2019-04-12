package org.ukdaga.practise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DocumentPrintQueue {
	
	public static void main (String args[])
	{
		PrintQueue printQueue = new PrintQueue();
		
		
		printQueue.createPrintQueue();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			String line = sc.nextLine();
			if("END".equals(line))
				break;
			
			else if ("POP".equals(line))
				printQueue.pop();
			
			else
			{
				String[] tokens = line.split(" ");
				printQueue.push(tokens[1], tokens[2]);
			}
		}
		
		
		printQueue.report();
		
		
	}
}	
	abstract class Document
	{
	    String name;
		public String Name ()
		{
			return name;
		}
		public abstract String Type ();
		
		public void printDocument ()
		{
			System.out.println ("Name: "+name);
			System.out.println("Type: "+Type());
		}
	}
	
	class WordDocument extends Document 
	{
		@Override
		public String Type() {
			return "WORD";
			}
	}
	
	class PdfDocument extends Document
	{
		@Override
		public String Type() {
			return "PDF";	
		}
	}
	
	class PrintQueue 
	{
		List<Document> queue;
		
		public PrintQueue()
		{
			
		}
		
		public void createPrintQueue ()
		{
			queue = new LinkedList<>();
		}
		
		public void push (String type, String name)
		{
			if ("WORD".equalsIgnoreCase(type))
			{
				WordDocument wordDocument = new WordDocument();
				wordDocument.name=name;
				queue.add(wordDocument);
			}
			else
			{
				PdfDocument pdfDocument = new PdfDocument();
				pdfDocument.name = name;
				queue.add(pdfDocument);
			}
		}
		
		public void pop ()
		{
			Document firstDocument = queue.get(0);
			firstDocument.printDocument();
			queue.remove(firstDocument);
		}
		
		public void report ()
		{
			for (Document d : queue)
			{
				d.printDocument();
			}
		}
		
	}
	
	

