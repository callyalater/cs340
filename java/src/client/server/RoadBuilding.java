/**
 * 
 */
package client.server;

import server.commands.ICommandParams;
import server.commands.exceptions.CommandParamNotValidException;

/**
 * Holds info to play a Road Building card
 * @author scottdaly
 *
 */
public class RoadBuilding implements ICommandParams{
	private String type;
	private int playerIndex;
	private Spot spot1;
	private Spot spot2;
	
	public RoadBuilding(String type, int playerIndex, Spot spot1, Spot spot2) {
		this.type = type;
		this.playerIndex = playerIndex;
		this.spot1 = spot1;
		this.spot2 = spot2;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the playerIndex
	 */
	public int getPlayerIndex() {
		return playerIndex;
	}
	/**
	 * @param playerIndex the playerIndex to set
	 */
	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}
	/**
	 * @return the spot1
	 */
	public Spot getSpot1() {
		return spot1;
	}
	/**
	 * @param spot1 the spot1 to set
	 */
	public void setSpot1(Spot spot1) {
		this.spot1 = spot1;
	}
	/**
	 * @return the spot2
	 */
	public Spot getSpot2() {
		return spot2;
	}
	/**
	 * @param spot2 the spot2 to set
	 */
	public void setSpot2(Spot spot2) {
		this.spot2 = spot2;
	}
	@Override
	public void validate() throws CommandParamNotValidException {
		if(this.type == null || this.type.length() == 0 || !this.type.equals("roadBuilding") || this.playerIndex < 0)
			throw new CommandParamNotValidException("Type musnt be null, length zero, or not equal to 'maritimeTrade', player index must be greater than zero: " + this.toString());
		if(this.spot1 == null || this.spot2 == null)
			throw new CommandParamNotValidException("the spots musnt be null: " + this.toString());
		this.spot1.validate();
		this.spot2.validate();
	}
	
	
}
