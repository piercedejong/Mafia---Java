package playerInfo;
/**
 * The Mafia is an abstract class that
 * signifies a mafia affiliation of a player
 * 
 * Unlike the Town class, Mafia is abstract
 * @author Elvin Limpin 30018832
 *
 */
public abstract class Mafia extends Player {

	/**
	 * Constructor passing values from different mafia
	 * classes to the Player class
	 * @param name
	 * @param position
	 */
	public Mafia(String name, int position) {
		super(name, position);
	}
	
	/**
	 * Used for continuing saved games
	 * @param name
	 * @param position
	 * @param status
	 * @param isLynched
	 */
	public Mafia(String name, int position, int status, boolean isLynched){
		super(name, position, status, isLynched);
	}
	
	public Mafia(Mafia toCopy){
		super(toCopy);
	}

	@Override
	public Player copy() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public int doAction(Player p) {
		// TODO Auto-generated method stub
		return p.getStatus();
	}
}