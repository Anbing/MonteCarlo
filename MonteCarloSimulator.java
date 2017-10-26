package montecarlo;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 10/23/2017
 * Description: Running the simulation
 *
 * @author AX
 */
public class MonteCarloSimulator {
  private Map<Portfolio, SimulatorType> portfolioMap;
  private double inflation;
  private long counter;
  private int periods;

  /**
   * constructor
   * @param aggressive
   * @param conservative
   */
  public MonteCarloSimulator(Portfolio aggressive, Portfolio conservative) {
    this.portfolioMap = new HashMap<>();
    this.portfolioMap.put(aggressive, new SimulatorType(aggressive.getMean(), aggressive.getStandardDeviation()));
    this.portfolioMap.put(conservative, new SimulatorType(conservative.getMean(), conservative.getStandardDeviation()));

    // initial setting
    this.inflation = 0.035; // means inflation adjustment 3.5% / year
    this.counter = 10000;   // run 10000 simulation
    this.periods = 20;      //20 yrs
  }

  /**
   * print out simulation result with format
   * @param aggressive : portfolio type
   * @param conservative : portfolio type
   */
  public static void printOut(Portfolio aggressive, Portfolio conservative) {
    System.out.println("\n");
    System.out.println("========= Portfolio Inflation Adjusted Values from Simulation =========");
    System.out.println("Portfolio Type | Median 20th Year | 10 % Best Case | 10 % Worst Case");
    System.out.println("-------------- | ---------------- | -------------- | ---------------");
    System.out.println(aggressive.simulationResult());
    System.out.println(conservative.simulationResult());
    System.out.println("Note: the simulation is based on: inflation 3.5%/year, simuation period: 20 years, count of simulation: 10000");
  }

  public static void main(String[] args) {
    Portfolio aggressive = new Portfolio("Aggressive", 100000, 0.094324, 0.15675);
    Portfolio conservative = new Portfolio("Conservative", 100000, 0.06189, 0.063438);

    MonteCarloSimulator simulator = new MonteCarloSimulator(aggressive, conservative);
    // call Monte Carlo Simulation
    simulator.mcSimulate();
    printOut(aggressive, conservative);
  }

  /**
   * run Monte Carlo Simulation
   * @param : N/A
   */
  public void mcSimulate() {
    for (int i = 0; i < counter; i++) { // run 10000 simulation
      for (Map.Entry<Portfolio, SimulatorType> entry : portfolioMap.entrySet()) {
        double simResult = entry.getKey().getIniInvestment();//starting value
        for (int j = 0; j < periods; j++) {
          //get next random sample return(i.e. mean) for the portfolio
          double nextReturn = entry.getValue().getNextSampleReturn();

          //value for the period
          simResult = (1 + nextReturn) * simResult;

          //inflation adjustment
          simResult = (1 - inflation) * simResult;
        }
        //save result for the porfolio
        entry.getValue().saveSimulationResult(simResult);
      }
    }

    // update portfolios at the end of counter
    for (Map.Entry<Portfolio, SimulatorType> entry : portfolioMap.entrySet()) {
      Portfolio p = entry.getKey();
      SimulatorType st = entry.getValue();
      p.setSimulationMedian(st.getPercentile(50));
      p.setSimulation10Worst(st.getPercentile(10));
      p.setSimulation10Best(st.getPercentile(90));
    }
  }

  /**
   * get inflation adjustment
   * @return
   */
  public double getInflation() {
    return inflation;
  }

  /**
   * set inflation adjustment
   * @param inflation : inflation adjustment
   */
  public void setInflation(double inflation) {
    this.inflation = inflation;
  }

  /**
   * get simulation count
   * @return
   */
  public long getCounter() {
    return counter;
  }

  /**
   * set simulation count
   * @param counter : simulation count
   */
  public void setCounter(long counter) {
    this.counter = counter;
  }

  /**
   * get running periods
   * @return
   */
  public int getPeriods() {
    return periods;
  }

  /**
   * set running periods
   * @param periods
   */
  public void setPeriods(int periods) {
    this.periods = periods;
  }

  /**
   * inner class for storing simulation status
   */
  private class SimulatorType {
    private NormalDistribution normalDistribution;
    private DescriptiveStatistics stats;

    /**
     * constructor
     * @param mean : return rate
     * @param standardDeviation : standard deviation
     */
    public SimulatorType(double mean, double standardDeviation) {
      //init distribution for sampling
      //using default Randomizer
      this.normalDistribution = new NormalDistribution(mean, standardDeviation);

      //to store results and compute percentiles
      this.stats = new DescriptiveStatistics();
    }

    /**
     * save simulation result
     * @param simResult : simulation result
     */
    public void saveSimulationResult(double simResult) {
      this.stats.addValue(simResult);
    }

    /**
     * get next sample return (i.e. mean)
     * @return
     */
    public double getNextSampleReturn() {
      return this.normalDistribution.sample();
    }

    /**
     * get percentile
     * @param n : percentile
     * @return
     */
    public double getPercentile(double n) {
      return this.stats.getPercentile(n);
    }
  }
}