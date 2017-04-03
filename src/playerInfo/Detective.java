package playerInfo;
/**
 * The detective is a town member that may check
 * the affiliation of any player at night.
 * @author Elvin Limpin 30018832
 */

public class Detective extends Town{

	/**
	 * Constructor passes values to player while
	 * creating a detective role
	 * @param name
	 * @param position
	 * @param role
	 */
	public Detective(String name, int position, Role role) {
		super(name, position, role);
	}
	
	/**
	 * Copy constructor
	 * @param d
	 */
	public Detective(Detective d){
		super(d);
	}
	

	/**
	 * Unique action of vigilante
	 * @param p
	 */
	@Override
	public int doAction(Player p){
		if(getStatus() == ACTIVE){
			//TODO Detective
		} return p.getStatus();
	}
	
	@Override
	public String toString() {
		return "Town Detective";
	}	
}