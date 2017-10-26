package montecarlo;

/**
 * Date: 10/22/2017
 * Description: Portfolio object setting, getter, setter, etc.
 *
 * @author AX
 */
public class Portfolio {
  private String type;
  //initial investment, i.e. 100,000$
  private double iniInvestment;
  // return rate
  private double mean;
  //risk
  private double standardDeviation;

  //simulated values
  private double simulationMedian;
  private double simulation10Best;
  private double simulation10Worst;

  /**
   * constructor
   * @param type
   * @param iniInvestment
   * @param mean
   * @param standardDeviation
   */
  public Portfolio(String type, double iniInvestment, double mean, double standardDeviation) {
    this.type = type;
    this.iniInvestment = iniInvestment;
    this.mean = mean;
    this.standardDeviation = standardDeviation;
  }

  /**
   * get portfolio type
   * @return portfolio type
   */
  public String getType() {
    return type;
  }

  /**
   * set portfolio type
   * @param type : portfolio type, i.e. Aggressive, Conservative, etc.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * get initial investment
   * @return inital investment
   */
  public double getIniInvestment() {
    return iniInvestment;
  }

  /**
   * set inital investment
   * @param iniInvestment
   */
  public void setIniInvestment(double iniInvestment) {
    this.iniInvestment = iniInvestment;
  }

  /**
   * get return rate
   * @return return rate
   */
  public double getMean() {
    return mean;
  }

  /**
   * set return rate
   * @param mean : return rate
   */
  public void setMean(double mean) {
    this.mean = mean;
  }

  /**
   * get risk
   * @return : risk
   */
  public double getStandardDeviation() {
    return standardDeviation;
  }

  /**
   * set risk
   * @param standardDeviation : risk
   */
  public void setStandardDeviation(double standardDeviation) {
    this.standardDeviation = standardDeviation;
  }

  /**
   * get simulation median (i.e. 50%)
   * @return : simulation median (i.e. 50%)
   */
  public double getSimulationMedian() {
    return simulationMedian;
  }

  /**
   * set simulation median (i.e. 50%)
   * @param simulationMedian
   */
  public void setSimulationMedian(double simulationMedian) {
    this.simulationMedian = simulationMedian;
  }

  /**
   * get 10% best simulation case
   * @return 10% best simulation case
   */
  public double getSimulation10Best() {
    return simulation10Best;
  }

  /**
   * set 10% best simulation case
   * @param simulation10Best
   */
  public void setSimulation10Best(double simulation10Best) {
    this.simulation10Best = simulation10Best;
  }

  /**
   * get 10% worst simulation case
   * @return
   */
  public double getSimulation10Worst() {
    return simulation10Worst;
  }

  /**
   * set 10% worst simulation case
   * @param simulation10Worst : 10% worst simulation case
   */
  public void setSimulation10Worst(double simulation10Worst) {
    this.simulation10Worst = simulation10Worst;
  }

  /**
   * return simulation result with format
   * @return String : simulation result
   */
  public String simulationResult() {
    return type + " | " + simulationMedian + " | " + simulation10Best + " | " + simulation10Worst;
  }
}