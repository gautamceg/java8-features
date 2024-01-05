package com.example.java8.duplicateCheck;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCheckExample {
    public static void main(String[] args) {
        List<ColleagueEventDto> eventDtos = List.of(
                new ColleagueEventDto(1L, "event1"),
                new ColleagueEventDto(2L, "event2"),
                new ColleagueEventDto(3L, "event1"),
                new ColleagueEventDto(4L, "event2"),
                new ColleagueEventDto(5L, "event1"),
                new ColleagueEventDto(6L, "event2"),
                new ColleagueEventDto(7L, "event3"),
                new ColleagueEventDto(8L, "event4"));

        Set<String> filteredEventIds = Set.of("event1", "event2");

        final Set<Long> ids = mapToIds1(eventDtos, filteredEventIds);
        System.out.println(ids);

    }

    private static Set<Long> mapToIds(List<ColleagueEventDto> eventDtos, Set<String> filteredEventIds) {
        return filteredEventIds.stream()
                .map(
                        eventId ->
                                eventDtos.stream()
                                        .filter(eventDto -> eventDto.getEventId().equals(eventId))
                                        .map(ColleagueEventDto::getId)
                                        .findAny())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private static Set<Long> mapToIds1(List<ColleagueEventDto> eventDtos, Set<String> filteredEventIds) {

        return eventDtos.stream()
                .map(
                        dto ->
                                filteredEventIds.stream()
                                        .filter(eventId -> eventId.equals(dto.getEventId()))
                                        .map(s -> dto.getId())
                                        .findAny())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}

class ColleagueEventDto {
    private final Long id;
    private final String eventId;

    public ColleagueEventDto(Long id, String eventId) {
        this.id = id;
        this.eventId = eventId;
    }

    public Long getId() {
        return id;
    }

    public String getEventId() {
        return eventId;
    }
}
