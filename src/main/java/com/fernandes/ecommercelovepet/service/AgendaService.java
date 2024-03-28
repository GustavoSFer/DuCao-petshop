package com.fernandes.ecommercelovepet.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Agenda;
import com.fernandes.ecommercelovepet.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	AgendaRepository agendaRepository;
	
	
	public List<Agenda> findAll() {
		List<Agenda> agendas = agendaRepository.findAll();
		
		return agendas;
	}

	public void abrirAgenda(LocalDate dataInicio, LocalDate dataFim, LocalTime horaInicio, LocalTime horaFim, int duracao) {
		LocalDate dataMomento = dataInicio;
		LocalTime horario = horaInicio;
		
		//negativo (se menor); 0(se for igual) ou  positivo maior 0 (se maior).
		 while(dataMomento.compareTo(dataFim) <= 0) {
			 int diaSemana = semana(dataMomento);
			 while(horario.compareTo(horaFim) <= 0) {
				 
				 Agenda agenda = new Agenda(dataInicio, horario, true, diaSemana);
							
				 agendaRepository.save(agenda);
				 
				 horario = horario.plusMinutes(duracao);
			 };
			 dataMomento = dataMomento.plusDays(1);
			 horario = horaInicio;
		};
	}
	
	private int semana(LocalDate data) {
		GregorianCalendar gc = new GregorianCalendar();
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				return 1;
				
			case Calendar.MONDAY:
				return 2;
				
			case Calendar.TUESDAY:
				return 3;
				
            case Calendar.WEDNESDAY:
            	return 4;
                
            case Calendar.THURSDAY:
            	return 5;
                
            case Calendar.FRIDAY:
            	return 6;
                
            case Calendar.SATURDAY:
                return 7;
		}
		return 0;		
	}
}
