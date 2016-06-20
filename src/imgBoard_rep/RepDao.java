package imgBoard_rep;

import java.util.ArrayList;

public interface RepDao {
	void insert(ImgRep ir);
	ImgRep select(int num);
	ArrayList<ImgRep> selectAll(int imgNum);
	void delete(int num);
}
