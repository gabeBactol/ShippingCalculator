package gbactol.cs134.miracosta.shippingcalculator;

/**
 * ShipItem.java: The class that would store information about the ShipItem base cost,
 * the added cost based on the weight of the item, and lastly, the total cost between the
 * base cost and the added cost.
 *
 * @author Gabriel Bactol
 * @since 2-11-19
 */
public class ShipItem
{
    //variables based on the weight of the item, base cost, the added cost, total cost,
    //and ounces left
    private int weight;
    private double baseCost;
    private double addedCost;
    private double totalCost;
    private int ouncesLeft;

    /**
     * The default constructor, sets up values when there
     * are no values given in the parameters. The base cost is initially set to $3 no matter
     * what item is being shipped
     */
    public ShipItem()
    {
        weight = 0;
        baseCost = 3.0;
        addedCost = 0.0;
        totalCost = 0.0;
        ouncesLeft = 0;
    }

    /**
     * Mutator for the weight value. This method also sets up the values for other variables,
     * since the addedCost, totalCost, and ouncesLeft are based on the weight value typed in.
     *
     * @param weight
     *            An int value containing how much the item weights in ounces
     */
    public void setWeight(int weight)
    {
        //set weight value based on the variable passed in
        this.weight = weight;

        //remove 16 ounces since it matters after 16 ounces
        ouncesLeft = weight - 16;

        //Should the ounces minus 16 be negative or zero, the added cost is automatically zero
        if(ouncesLeft <= 0)
        {
            addedCost = 0.0;
        }
        else
        {
            //the added cost is calculated by diving the ounces by 4 multiplied by .50
            addedCost = (ouncesLeft/4)*.50;

            //should there be any remainder, i.e. 21, it should be $1.00, so it adds .50 to
            //added cost
            if(ouncesLeft % 4 != 0)
            {
                addedCost += .50;
            }
        }
        //total cost is calculated by adding the added cost and base cost
        totalCost = baseCost + addedCost;
    }

    /**
     * Accessor to get the ouncesLeft value within the ShipItem class
     *
     * @return the int value within the ouncesLeft variable
     */
    public int getOuncesLeft()
    {
        return ouncesLeft;
    }
    public double getBaseCost()
    {
        return baseCost;
    }
    /**
     * Accessor to get the addedCost value within the ShipItem class
     *
     * @return the double value within the addedCost variable
     */
    public double getAddedCost()
    {
        return addedCost;
    }
    /**
     * Accessor to get the totalCost value within the ShipItem class
     *
     * @return the double value within the totalCost variable
     */
    public double getTotalCost()
    {
        return totalCost;
    }
    /**
     * Accessor to get the weight value within the ShipItem class
     *
     * @return the int value within the weight variable
     */
    public double getWeight()
    {
        return weight;
    }
}
