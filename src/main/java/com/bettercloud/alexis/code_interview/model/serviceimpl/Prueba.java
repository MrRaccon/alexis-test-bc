package com.bettercloud.alexis.code_interview.model.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.bettercloud.alexis.code_interview.model.DrawSelection;
import com.bettercloud.alexis.code_interview.model.Family;
import com.bettercloud.alexis.code_interview.model.Person;

public class Prueba {

//	public static void main(String[] args) {
//
//		executeDraw("");
//	}
//
//	public static void executeDraw(String clientId) {
//		// definimos familias
//		Person pr1 = new Person("Carlos", "sadasd23112", 1);
//		Person pr2 = new Person("Juan", "kspsd23112", 1);
//		Person pr3 = new Person("Ana", "owissd23112", 1);
//
//		Family family1 = new Family(1, "LOPEZ", Arrays.asList(pr1, pr2, pr3));
//
//		Person pr1_2 = new Person("PEDRO", "sdfazsd23112", 2);
//		Person pr2_2 = new Person("KARLA", "pswjd23112", 2);
//
//		Family family2 = new Family(2, "Gonzalez", Arrays.asList(pr1_2, pr2_2));
//
//		Person pr1_3 = new Person("Hugo", "sdfazsd23112", 3);
//		Person pr2_3 = new Person("Martha", "pswjd23112", 3);
//
//		Family family3 = new Family(3, "Romo", Arrays.asList(pr1_3, pr2_3));
//
//		List<DrawSelection> lastDraws = new ArrayList<>();
//		// persona que recibe por 4 años seguidos por la misma persona
//		// el santa es quien da, no quien recibe OJO CON ESO
//		DrawSelection se2 = new DrawSelection(pr1, pr1_2, 2021);
//		DrawSelection se3 = new DrawSelection(pr1, pr1_2, 2022);
//		DrawSelection se4 = new DrawSelection(pr1, pr1_2, 2023);
//
//		DrawSelection se5 = new DrawSelection(pr2, pr2_2, 2023);
//		DrawSelection se6 = new DrawSelection(pr2, pr2_3, 2022);
//
//		DrawSelection se7 = new DrawSelection(pr2_3, pr2, 2022);
//		lastDraws.add(se2);
//		lastDraws.add(se3);
//		lastDraws.add(se4);
//		lastDraws.add(se5);
//		lastDraws.add(se6);
//		lastDraws.add(se7);
//
//		List<Family> families = Arrays.asList(family1, family2, family3);
//
//		// a partir de aqui comienza el algoritmo
//		List<Person> allPeople = new ArrayList<>();
//		for (Family family : families) {
//			allPeople.addAll(family.getMembers());
//		}
//		// mezclamos a todos de manera random
//		Collections.shuffle(allPeople);
//		// toda la gente con sus excepciones de repeticion
//		Map<Person, Set<DrawSelection>> personLastDraws = new HashMap<>();
//		for (Person p : allPeople) {
//			personLastDraws.put(p,
//					lastDraws.stream().filter(x -> x.getPersonReceiveGift().equals(p)).collect(Collectors.toSet()));
//		}
//		Map<Person, Person> drawExecuted = null;
//		int attempts = 0;
//		int maxAttempts = 100; // Limitar a 100 intentos
//		do {
//			System.out.println("INTENTO NUMERO  ".concat(String.valueOf(attempts)));
//			drawExecuted = getDraw(new ArrayList<>(allPeople), personLastDraws);
//			attempts++;
//		} while (drawExecuted.containsValue(null) && attempts < maxAttempts); // Reintentar hasta que no haya null o se
//																				// alcance el límite de intentos
//
//		if (drawExecuted.containsValue(null)) {
//			System.out.println("No se pudo encontrar una asignación válida después de " + maxAttempts + " intentos.");
//		} else {
//			for (Map.Entry<Person, Person> entry : drawExecuted.entrySet()) {
//				Person receiver = entry.getKey();
//				Person giver = entry.getValue();
//				System.out.println("Receiver: " + receiver.getName() + ", giver: " + giver.getName());
//			}
//		}
//
//	}
//
//	private static Map<Person, Person> getDraw(List<Person> allPeople,
//			Map<Person, Set<DrawSelection>> personLastDraws) {
//		Map<Person, Person> drawResult = new HashMap<>();
//
//		for (Map.Entry<Person, Set<DrawSelection>> entry : personLastDraws.entrySet()) {
//
//			Person personWhoReceiveGift = entry.getKey();
//			Set<DrawSelection> peopleWhoGivenGift = entry.getValue();
//
//			// se quita a si mismo de la lista, despues se quitan familiares directos y
//			// personas que ya le dieron regalo
//			// solo nos quedamos con los restantes
//			List<Person> possibleSantas = allPeople.stream().filter(x -> !x.equals(personWhoReceiveGift))
//					.filter(x -> x.getFamilyId() != personWhoReceiveGift.getFamilyId())
//					.filter(x -> peopleWhoGivenGift.stream().noneMatch(ds -> ds.getPersonGiveGift().equals(x)))
//					.collect(Collectors.toList());
//
//			if (possibleSantas.isEmpty()) {
//				drawResult.put(personWhoReceiveGift, null);
//			} else {
//
//				Collections.shuffle(possibleSantas);
//				Person secretSanta = possibleSantas.get(0);
//				drawResult.put(personWhoReceiveGift, secretSanta);
//				allPeople.remove(secretSanta);
//
//			}
//
//		}
//		return drawResult;
//
//	}
}
