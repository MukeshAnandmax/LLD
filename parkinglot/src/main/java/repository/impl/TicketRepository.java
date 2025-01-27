package repository.impl;

import models.Gate;
import models.Ticket;
import repository.ITicketRepository;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository implements ITicketRepository {
    private final Map<Long, Ticket> ticketMap =  new TreeMap<>();

    private long lastSavedId = 0L;
    public Ticket save(Ticket ticket){

        ticket.setId(lastSavedId+1);
        lastSavedId++;
        ticketMap.put(lastSavedId,ticket);

        return ticket;
    }
}
