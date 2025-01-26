package dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenerateTicketResponseDto {

    private  long ticketId;
    private String operatorName;
    private  int spotNumber;
}
