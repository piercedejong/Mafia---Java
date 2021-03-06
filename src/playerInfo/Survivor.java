package playerInfo;
/**
 * This class extends Player class.
 * Unlike the Mafia class, some Town Players are classified
 * only as town players.
 * @author Mahsa Lotfi 10072013
 *
 */
public class Survivor extends Townie {

	/**
	 * Used for inheriting different town subclasses
	 * @param name, String
	 * @param position, integer
	 */
	public Survivor(String name, int position) {
		super(name, position);
		setRole(scan("Survivor"));
	}
	
	/**
	 * Used for continuing saved games
	 * @param name, String
	 * @param position, integer
	 * @param status, integer
	 * @param isLynched, boolean
	 */
	public Survivor(String name, int position, int status, boolean isLynched){
		super(name, position, status, isLynched);
		setRole(scan("Survivor"));
	}
	
	/**
	 * Copy constructor
	 * @param s, Survivor
	 */
	public Survivor(Survivor s){
		super(s);
	}
	
	/**Copy method*/
	public Player copy(){
		return new Survivor(this);
	}

	/** The lyncher does not do anything at night */
	@Override
	public int doAction(Player p) {
		// These players do nothing
		return p.getStatus();
	}
}
