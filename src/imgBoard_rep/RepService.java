package imgBoard_rep;

import java.util.ArrayList;

public interface RepService {
	void addRep(ImgRep ir);
	ImgRep getRep(int num);
	ArrayList<ImgRep> getAll(int imgNum);
	void delImgrep(int num);
}
