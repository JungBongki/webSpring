package imgBoard_img;

import java.util.ArrayList;

public interface ImgService {
	void AddImg(Img i);
	Img getImg(int num);
	ArrayList<Img> getAll();
	void delimg(int num);
}
