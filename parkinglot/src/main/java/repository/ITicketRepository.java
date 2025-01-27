package repository;

import models.Ticket;

public interface ITicketRepository {
    public Ticket save(Ticket ticket);
}
