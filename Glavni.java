package hr.fer.oop.lab1.prob6;

import java.util.Scanner;

public class Glavni {

		private static ListNode addToList(ListNode head, double value) {
			
			if(head==null) {
				head = new ListNode();
				head.next = null;
				head.value = value;
			} else {
				ListNode temp = head;
				while(temp.next!=null)
					temp = temp.next;
				temp.next = new ListNode();
				temp.next.next = null;
				temp.next.value = value;
			}
			return head;
		}
		
		private static int listSize(ListNode head) {
			int brojac = 0;
			if(head==null) return brojac;
			while(head.next!=null) {
				brojac++;
				head = head.next;
			}
			return brojac+1;
		}
		
		private static double calcAverage(ListNode head) {
		
			double suma = 0;
			double duljina = listSize(head);
			while(head.next!=null) {
				suma+=head.value;
				head = head.next;
			}
			suma+=head.value;
			double prosjek = suma/duljina;
			return prosjek;
		}
		
		private static void writeBiggerThan(ListNode head, double value) {
		
			ListNode temp = head;
			while(temp.next!=null) {
				if(temp.value > value)
					System.out.println(temp.value);
				temp = temp.next;
			}
			if(temp.value > value)
				System.out.println(temp.value);
		}
		
		
		public static void main(String[] args) {
			ListNode head = null;
			double pom;
			Scanner sc = new Scanner(System.in);
			while(true) {
				if(sc.hasNextDouble()) {
					pom = sc.nextDouble();
					if(pom < 0) {
						break;
					} else {
						head = addToList(head, pom);
					}
				} else {
					sc.next();
				}
			}
			// čitati decimalne brojeve s tipkovnice
		 // ako se unese nešto što nije decimalni broj, preskočiti
		 // ako se unese negativan broj, prekida se čitanje
		 // inaće se uneseni broj dodaje u listu
			if(listSize(head)<1) {
				System.out.println("Niste unijeli niti jedan broj!");
				sc.close();
				return;
			}
			double average = calcAverage(head);
			System.out.println("Prosjek unesenih brojeva je: " + average);
			System.out.println("Brojevi koji su veći od prosjeka su: ");
			writeBiggerThan(head, average);
			sc.close();
		}

}
