package imgBoard_img;

import java.util.ArrayList;

public interface ImgDao {
	void insert(Img i);
	Img select(int num);
	ArrayList<Img> selectAll();
	void delete(int num);
}
