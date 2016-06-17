package member;

public interface Dao {
	void insert(Join j);
	Join select(String id);
	void update(Join j);
	void delete(String id);
}
