package com.application.atm;

import java.util.ArrayList;
import java.util.List;

public class DataSaver {
	
	public static List<Person> list = new ArrayList<Person>();
	
	public static void shto(String emri,String mbiemri, String nrKartes, String pin, String shuma){
		Person person = new Person();
		person.setEmri(emri);
		person.setMbiemri(mbiemri);
		person.setNr_i_kartes(nrKartes);
		person.setPin(Integer.valueOf(pin));
		person.setShuma(Double.valueOf(shuma));
		list.add(person);		
	}

	public static String kerko(String nrKartes, String pin) {
		if (list != null & list.size() != 0) {
			for (Person person : list) {
				if (person.getNr_i_kartes().equals(nrKartes) && person.getPin() == Integer.valueOf(pin)) {
					return "Gjendja e llogarise tuaj eshte: " + String.valueOf(person.getShuma());
				}
			}
			return "Kujdes ne plotesimin e te dhenave tuaja!";
		} else {
			return "Ju fillimisht duhet te regjistroheni!";
		}
	}
	
	public static String terhiq(String shuma, String nrKartes, String pin) {
		if (list != null & list.size() != 0) {
			for (Person person : list) {
				if (person.getNr_i_kartes().equals(nrKartes) && person.getPin() == Integer.valueOf(pin)) {
					if (person.getShuma() >= Double.valueOf(shuma))
						return "Ju mund te terhiqni shumen e kerkuar!";
				}
			}
		}
		return "Shuma e kerkuar nuk eshte e disponueshme!";
	}

}
