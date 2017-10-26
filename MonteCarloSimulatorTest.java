package montecarlo;

import org.junit.Test;

import static montecarlo.MonteCarloSimulator.printOut;

/**
 * Run a test simulation
 * @author AX
 *
 */
public class MonteCarloSimulatorTest {

	@Test
	public void SimulationTest1(){
		Portfolio aggressive = new Portfolio("Aggressive", 100000, 0.094324, 0.15675);
		Portfolio conservative = new Portfolio("Conservative", 100000, 0.06189, 0.063438);
		
		MonteCarloSimulator simulator = new MonteCarloSimulator(aggressive, conservative);
		// call Monte Carlo Simulation
		simulator.mcSimulate();
		printOut(aggressive, conservative);
	}

	@Test
	public void SimulationTest2(){
		Portfolio aggressive = new Portfolio("Aggressive", 500000, 0.1025, 0.2012);
		Portfolio conservative = new Portfolio("Conservative", 500000, 0.0523, 0.04521);

		MonteCarloSimulator simulator = new MonteCarloSimulator(aggressive, conservative);
		// call Monte Carlo Simulation
		simulator.mcSimulate();
		printOut(aggressive, conservative);
	}

	@Test
	public void SimulationTest3(){
		Portfolio aggressive = new Portfolio("Aggressive", 3000, 0.145312, 0.16523);
		Portfolio conservative = new Portfolio("Conservative", 3000, 0.04513, 0.03422);

		MonteCarloSimulator simulator = new MonteCarloSimulator(aggressive, conservative);
		// call Monte Carlo Simulation
		simulator.mcSimulate();
		printOut(aggressive, conservative);
	}
}