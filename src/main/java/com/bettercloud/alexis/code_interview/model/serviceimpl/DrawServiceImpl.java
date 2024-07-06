package com.bettercloud.alexis.code_interview.model.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bettercloud.alexis.code_interview.dto.DrawDto;
import com.bettercloud.alexis.code_interview.model.DrawSelection;
import com.bettercloud.alexis.code_interview.model.Family;
import com.bettercloud.alexis.code_interview.model.Person;
import com.bettercloud.alexis.code_interview.model.service.DrawService;
import com.bettercloud.alexis.code_interview.repository.DrawSelectionRepository;
import com.bettercloud.alexis.code_interview.repository.FamilyRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class DrawServiceImpl implements DrawService {

	@Autowired
	private FamilyRepository familyRepository;

	@Autowired
	private DrawSelectionRepository drawSelectionRepository;

	@Override
	public List<DrawDto> executeDraw(int clientId) {
		List<DrawDto> response = new ArrayList<>();

		List<Family> families = familyRepository.findByUserSysDrawUserSysDrawId(clientId);

		// a partir de aqui comienza el algoritmo
		List<Person> allPeople = new ArrayList<>();
		for (Family family : families) {
			allPeople.addAll(family.getMembers());
		}
		// mezclamos a todos de manera random
		Collections.shuffle(allPeople);

		List<Integer> idPersonList = allPeople.stream().map(x -> x.getPersonId()).toList();

		int currentYear = LocalDate.now().getYear();

		Set<DrawSelection> lastDraws = drawSelectionRepository
				.findByPersonReceivePersonIdInAndYearDrawBetween(idPersonList, currentYear - 3, currentYear - 1);

		// toda la gente con sus excepciones de repeticion
		Map<Person, Set<DrawSelection>> personLastDraws = new HashMap<>();
		for (Person p : allPeople) {
			personLastDraws.put(p,
					lastDraws.stream().filter(x -> x.getPersonReceive().equals(p)).collect(Collectors.toSet()));

		}
		Map<Person, Person> drawExecuted = null;
		int attempts = 0;
		int maxAttempts = 100; // Limitar a 100 intentos
		do {
			log.info("Attempt number {}", attempts);
			drawExecuted = getDraw(new ArrayList<>(allPeople), personLastDraws);
			attempts++;
		} while (drawExecuted.containsValue(null) && attempts < maxAttempts); // Reintentar hasta que no haya null o se
																				// alcance el límite de intentos
		if (drawExecuted.containsValue(null)) {
			log.info("It's not possible get a draw");
		} else {
			for (Map.Entry<Person, Person> entry : drawExecuted.entrySet()) {
				Person receiver = entry.getKey();
				Person giver = entry.getValue();
				DrawDto drawDto = new DrawDto(receiver.getFirstName(), giver.getFirstName());
				response.add(drawDto);
				log.info("Receiver {} .... Giver {}", receiver.getFirstName(), giver.getFirstName());

			}
		}
		return response;

	}

	private Map<Person, Person> getDraw(List<Person> allPeople, Map<Person, Set<DrawSelection>> personLastDraws) {
		Map<Person, Person> drawResult = new HashMap<>();

		for (Map.Entry<Person, Set<DrawSelection>> entry : personLastDraws.entrySet()) {

			Person personWhoReceiveGift = entry.getKey();
			Set<DrawSelection> peopleWhoGivenGift = entry.getValue();

			// se quita a si mismo de la lista, despues se quitan familiares directos y
			// personas que ya le dieron regalo
			// solo nos quedamos con los restantes
			List<Person> possibleSantas = allPeople.stream().filter(x -> !x.equals(personWhoReceiveGift))
					.filter(x -> x.getFamily().getFamilyId() != personWhoReceiveGift.getFamily().getFamilyId())
					.filter(x -> peopleWhoGivenGift.stream().noneMatch(ds -> ds.getPersonGive().equals(x)))
					.collect(Collectors.toList());

			if (possibleSantas.isEmpty()) {
				drawResult.put(personWhoReceiveGift, null);
			} else {

				Collections.shuffle(possibleSantas);
				Person secretSanta = possibleSantas.get(0);
				drawResult.put(personWhoReceiveGift, secretSanta);
				allPeople.remove(secretSanta);

			}

		}
		return drawResult;

	}

}
