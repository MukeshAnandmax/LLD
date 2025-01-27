import controller.TicketController;
import repository.IGateRepository;
import repository.IParkingLotRepository;
import repository.ITicketRepository;
import repository.IVehicleRepository;
import repository.impl.GateRepository;
import repository.impl.ParkingLotRepository;
import repository.impl.TicketRepository;
import repository.impl.VehicleRepository;
import service.ITicketService;
import service.IVehicalService;
import service.impl.TicketService;
import service.impl.VehicleService;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;
import strategies.spotAssignmentStrategy.impl.RandomSpotAssignmentStrategy;

public class ParkingLotApplication {

    public static void main(String[] args) {

        IGateRepository gateRepository = new GateRepository();
        IParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ITicketRepository ticketRepository = new TicketRepository();
        IVehicleRepository vehicleRepository =  new VehicleRepository();


        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();
        IVehicalService vehicalService =  new VehicleService(vehicleRepository);

        ITicketService ticketService = new TicketService(
                spotAssignmentStrategy,
                gateRepository,
                vehicleRepository,
                vehicalService,
                ticketRepository,
                parkingLotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        System.out.println("\n");

        System.out.println("Application has started ...........");

        System.out.println("\n");


        System.out.println("██████╗  █████╗ ██████╗ ██╗  ██╗██╗███╗   ██╗ ██████╗     ██╗      ██████╗ ████████╗");
        System.out.println("██╔══██╗██╔══██╗██╔══██╗██║ ██╔╝██║████╗  ██║██╔════╝     ██║     ██╔═══██╗╚══██╔══╝");
        System.out.println("██████╔╝███████║██████╔╝█████╔╝ ██║██╔██╗ ██║██║  ███╗    ██║     ██║   ██║   ██║   ");
        System.out.println("██╔═══╝ ██╔══██║██╔═══╝ ██╔═██╗ ██║██║╚██╗██║██║   ██║    ██║     ██║   ██║   ██║   ");
        System.out.println("██║     ██║  ██║██║     ██║  ██╗██║██║ ╚████║╚██████╔╝    ███████╗╚██████╔╝   ██║   ");
        System.out.println("╚═╝     ╚═╝  ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚══════╝ ╚═════╝    ╚═╝   ");
        System.out.println();


        System.out.println(" █████╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗ █████╗ ████████╗ ██████╗  ██████╗ ███╗   ██╗");
        System.out.println("██╔══██╗██╔══██╗██╔══██╗██║     ██║██╔════╝██╔══██╗╚══██╔══╝██╔═══██╗██╔═══██╗████╗  ██║");
        System.out.println("███████║██████╔╝██████╔╝██║     ██║██║     ███████║   ██║   ██║   ██║██║   ██║██╔██╗ ██║");
        System.out.println("██╔══██║██╔═══╝ ██╔═══╝ ██║     ██║██║     ██╔══██║   ██║   ██║   ██║██║   ██║██║╚██╗██║");
        System.out.println("██║  ██║██║     ██║     ███████╗██║╚██████╗██║  ██║   ██║   ╚██████╔╝╚██████╔╝██║ ╚████║");
        System.out.println("╚═╝  ╚═╝╚═╝     ╚═╝     ╚══════╝╚═╝ ╚═════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝");



    }
}
