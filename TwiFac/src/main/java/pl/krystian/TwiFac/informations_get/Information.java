package pl.krystian.TwiFac.informations_get;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Information {
	private String title;
	private String mainText;
	private String authorName;
	private String date;
	private ArrayList<UserComment> listOfComments;
}
