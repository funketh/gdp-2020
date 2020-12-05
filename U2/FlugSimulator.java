public class FlugSimulator {
    public static void main(String[] args) {
        int SEATS = 75;
        int TICKETS = 78;
        double TURN_UP_RATE = .92;

        int numFlights = Integer.parseInt(args[0]);

        int passengerSum = 0;
        int overbookedSum = 0;

        for (int i = 1; i <= numFlights; i++) {
            int passengers = 0;
            for (int ticket = 1; ticket <= TICKETS; ticket++)
                if (Math.random() <= TURN_UP_RATE)
                    passengers++;
            
            passengerSum += passengers;
            if (passengers > SEATS)
                overbookedSum++;
        }

        double overbookedPercentage = 100.0 * overbookedSum / numFlights;
        double averagePassengers = (double) passengerSum / numFlights;

        System.out.printf("Überbuchungen: %d (%.2f%%)%nMittelwert: %.1f%n",
                overbookedSum, overbookedPercentage, averagePassengers);
    }
}
