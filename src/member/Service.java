package member;

public interface Service {
	void addJoin(Join j);

	Join getJoin(String id);

	boolean login(Join j);

	void editJoin(Join j);

	void delJoin(String id);

}
